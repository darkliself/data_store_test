package com.darkliself.datastoretest.viewmodel

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darkliself.datastoretest.repository.NicknameRepository
import kotlinx.coroutines.launch


class NicknameViewModel(
    private val repo: NicknameRepository
) : ViewModel() {
    private val EXAMPLE_COUNTER = "lolwhat"

    init {
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
//            repo.writeData( "lolwhat")
//            repo.writeData( "lolwhat2")
//            repo.writeData( "lolwhat3")
            println(repo.showFullData())
            println(repo.getNickname(EXAMPLE_COUNTER))
        }
    }

    suspend fun read(key: String) {
            println(repo.getNickname(key))
    }

    suspend fun write(value: String) {
        repo.writeData(value)
    }

    suspend fun remove(key: String) {
        repo.removeNickname(key)
    }

    suspend fun printAll() {
        repo.showFullData()
    }
}
