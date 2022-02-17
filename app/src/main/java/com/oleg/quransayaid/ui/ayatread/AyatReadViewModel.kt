package com.oleg.quransayaid.ui.ayatread

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oleg.data.Result
import com.oleg.data.source.ayatsource.AyatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Crafted by Lukman on 08/02/22.
 **/

@HiltViewModel
class AyatReadViewModel @Inject constructor(
    private val repository: AyatRepository
) : ViewModel() {
    private val _ayatList = MutableLiveData<AyatReadViewState>()
    val ayatList: LiveData<AyatReadViewState> = _ayatList

    fun fetchAyatList(id: Int) {
        _ayatList.value = AyatReadViewState.OnLoading
        viewModelScope.launch {
            repository.fetchAyatList(id).collectLatest { ayatResponse ->
                when (ayatResponse) {
                    is Result.Success -> {
                        _ayatList.postValue(AyatReadViewState.OnLoaded(ayatResponse.data))
                    }
                    is Result.Error -> {
                        _ayatList.postValue(AyatReadViewState.OnFailure(ayatResponse.exception.message))
                    }
                    else -> {
                        _ayatList.postValue(AyatReadViewState.OnFailure())
                    }
                }
            }
        }
    }

    sealed class AyatReadViewState {
        data class OnLoaded(val ayatList: List<com.oleg.data.Ayat>) : AyatReadViewState()
        data class OnFailure(val message: String? = null) : AyatReadViewState()
        object OnLoading : AyatReadViewState()
    }
}