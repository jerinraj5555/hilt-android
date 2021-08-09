package com.example.hiltandroid

import androidx.datastore.preferences.core.intPreferencesKey

class Constants {
    companion object {
        val IS_DARK_MODE = intPreferencesKey("dark_mode")
    }
}