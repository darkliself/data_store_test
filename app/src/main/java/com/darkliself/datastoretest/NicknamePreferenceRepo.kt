package com.darkliself.datastoretest

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
import kotlinx.coroutines.flow.map
import java.nio.channels.spi.AbstractSelectionKey



//suspend fun main(args: Array<String>) {
//    val t = NicknamePreferenceRepo()
//    val z = stringPreferencesKey("test")
//    t.write( "test")
//}



class NicknamePreferenceRepo {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "nickname_repo")
    private val key: Preferences.Key<String> = stringPreferencesKey("nickname")

    suspend fun rewriteNickname(context: Context, nickname: String, repoKey: Preferences.Key<String>) {
        context.dataStore.edit { preferences->
            // Read the current value from preferences
            // val currentCounterValue = preferences[repoKey] ?: "Test Nickname"
            // Write the current value + 1 into the preferences
            preferences[repoKey] = nickname
        }
    }
    suspend fun write(context: Context, nickname: String) {
        val key: Preferences.Key<String> = stringPreferencesKey(nickname)
        context.dataStore.edit { preferences->
            // Read the current value from preferences
            // val currentCounterValue = preferences[repoKey] ?: "Test Nickname"
            // Write the current value + 1 into the preferences
            preferences[key] = nickname
        }
    }

    suspend fun getCounter(context: Context, key: Preferences.Key<String>): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[key] ?: ""
        }
    }

    suspend fun showFullData(context: Context, key: Preferences.Key<String>): Flow<String?> {

       println("i hope its here")
        return context.dataStore.data
            .map { preferences ->
                println("is here 2")
                println(preferences[key])
                preferences[key]
            }
    }


}