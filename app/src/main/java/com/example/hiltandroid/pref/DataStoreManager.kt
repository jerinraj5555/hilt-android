package com.example.hiltandroid.pref

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.hiltandroid.Constants.Companion.IS_DARK_MODE
import com.example.hiltandroid.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreManager @Inject constructor(@ApplicationContext appContext: Context) {

    private val settingsDataStore = appContext.dataStore

    suspend fun setThemeMode(mode: Int) {
        settingsDataStore.edit { settings ->
            settings[ IS_DARK_MODE] = mode
        }
    }

    val themeMode: Flow<Int> = settingsDataStore.data.catch {
        if (it is IOException) {
            it.printStackTrace()
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map { preferences ->
        preferences[IS_DARK_MODE] ?: AppCompatDelegate.MODE_NIGHT_UNSPECIFIED
    }

}