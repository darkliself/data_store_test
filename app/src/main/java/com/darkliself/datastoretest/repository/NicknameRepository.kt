package com.darkliself.datastoretest.repository

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.nio.channels.spi.AbstractSelectionKey



//suspend fun main(args: Array<String>) {
//    val t = NicknamePreferenceRepo()
//    val z = stringPreferencesKey("test")
//    t.write( "test")
//}



class NicknameRepository(context: Context) {
    val innerContex = context
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "nickname_repo")
    private val key: Preferences.Key<String> = stringPreferencesKey("nickname")

    suspend fun rewriteNickname(nickname: String, key: Preferences.Key<String>) {
        innerContex.dataStore.edit { preferences->
            preferences[key] = nickname
        }
    }
    suspend fun writeData(nickname: String) {
        val key: Preferences.Key<String> = stringPreferencesKey(nickname)
        innerContex.dataStore.edit { preferences->
            // Read the current value from preferences
            // Write the current value + 1 into the preferences
            preferences[key] = nickname
        }
    }

    suspend fun getNickname(key: String): String {
        return innerContex.dataStore.data.first()[stringPreferencesKey(key)]!!
    }

    suspend fun removeNickname(key: String) {
        innerContex.dataStore.edit {
            innerContex.dataStore.edit { preferences->
                // Read the current value from preferences
                // val currentCounterValue = preferences[repoKey] ?: "Test Nickname"
                // Write the current value + 1 into the preferences
                preferences.remove(stringPreferencesKey(key))
            }
        }
    }

    @SuppressLint("NewApi")
    suspend fun showFullData() {
        innerContex.dataStore.data.first().asMap().forEach { (k, v) ->
            println("key is $k and value is $v")
        }
    }
}