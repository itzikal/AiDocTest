package com.itzik.alkotzer.aidoc.general

import android.app.Application
import com.itzik.alkotzer.aidoc.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AiDocTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private fun initKoin(){
        // start Koin (di) context
        startKoin {
            androidContext(this@AiDocTestApplication)
            androidLogger(Level.ERROR)

            modules(
                appModule,
            )
        }
    }

}