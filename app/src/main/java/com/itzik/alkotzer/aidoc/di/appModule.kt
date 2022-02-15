package com.itzik.alkotzer.aidoc.di

import com.itzik.alkotzer.aidoc.MainActivityViewModel
import com.itzik.alkotzer.aidoc.actions.ActionsFactory
import com.itzik.alkotzer.aidoc.helpers.DateHelper
import com.itzik.alkotzer.aidoc.helpers.NotificationsHelper
import com.itzik.alkotzer.aidoc.helpers.ResourceHelper
import com.itzik.alkotzer.aidoc.helpers.SharedPrefHelper
import com.itzik.alkotzer.aidoc.model.ConfigurationRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { ConfigurationRepository(get()) }
    factory { SharedPrefHelper(get()) }
    factory { ResourceHelper(get()) }
    factory { NotificationsHelper()}
    factory { DateHelper()}
    factory { ActionsFactory(get(), get(), get())}


    viewModel {MainActivityViewModel(get())}
}