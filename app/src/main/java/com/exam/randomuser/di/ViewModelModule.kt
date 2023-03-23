package com.exam.randomuser.di

import com.exam.randomuser.ui.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        UserViewModel(randomRepository = get())
    }
}
