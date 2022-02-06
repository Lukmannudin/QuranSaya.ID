package com.oleg.quransayaid

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oleg.quransayaid.data.Result
import com.oleg.quransayaid.data.surahsource.SurahRepository
import com.oleg.quransayaid.data.surahsource.SurahRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Crafted by Lukman on 06/02/22.
 **/

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: SurahRepository
): ViewModel() {

    fun test() {
        viewModelScope.launch {
            repository.fetchSurahes().collectLatest {
                if (it is Result.Success) {
                    Log.d("cekcekcek", "success")
                }
            }
        }
    }

}