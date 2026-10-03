package br.com.denisecastro.androidrunner.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

private const val DATA_STORE_NAME =
    "android_runner_preferences"

val Context.androidRunnerDataStore by preferencesDataStore(
    name = DATA_STORE_NAME
)