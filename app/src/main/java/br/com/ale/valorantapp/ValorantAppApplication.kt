package br.com.ale.valorantapp

import android.app.Application
import br.com.ale.valorantapp.di.appModule
import br.com.ale.valorantapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ValorantAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ValorantAppApplication)
            androidLogger()
            modules(appModule, networkModule)
        }
    }
}