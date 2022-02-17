package com.oleg.quransayaid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oleg.data.common.Result
import com.oleg.data.domain.Surah
import com.oleg.data.source.surahsource.SurahRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Crafted by Lukman on 06/02/22.
 **/

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SurahRepository
) : ViewModel() {

    private val _surahList = MutableLiveData<HomeViewState>()
    val surahList: LiveData<HomeViewState> = _surahList

    fun fetchSurahList() {
        _surahList.value = HomeViewState.OnLoading
        viewModelScope.launch {
            repository.fetchSurahes().collectLatest { surahResponse ->
                when (surahResponse) {
                    is Result.Success -> {
                        withContext(Dispatchers.Main) {
                            _surahList.value = HomeViewState.OnLoaded(surahResponse.data)
                        }
                    }
                    is Result.Error -> {
                        _surahList.postValue(HomeViewState.OnFailure(surahResponse.exception.message))
                    }
                    else -> {
                        _surahList.postValue((HomeViewState.OnFailure()))
                    }
                }
            }
        }
    }

    sealed class HomeViewState {
        data class OnLoaded(val surahList: List<Surah>) : HomeViewState()
        data class OnFailure(val message: String? = null) : HomeViewState()
        object OnLoading : HomeViewState()
    }
}