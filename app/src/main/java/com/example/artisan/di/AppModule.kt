package com.example.artisan.di

import com.example.artisan.domain.repository.ArtisanIterator
import com.example.artisan.domain.usecase.ArtisanUseCase
import com.example.artisan.ui.detail.DetailViewModel
import com.example.artisan.ui.home.HomeViewModel
import com.example.artisan.ui.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<ArtisanUseCase> { ArtisanIterator(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}