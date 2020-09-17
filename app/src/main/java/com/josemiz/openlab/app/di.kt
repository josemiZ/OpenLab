package com.josemiz.openlab.app

import android.app.Application
import com.josemiz.openlab.main.team.TeamFragment
import com.josemiz.openlab.main.team.TeamViewModel
import com.josemiz.openlab.main.welcome.WelcomeFragment
import com.josemiz.openlab.main.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        modules(listOf(scopeModules))
    }
}

private val scopeModules = module {
    scope(named<WelcomeFragment>()) {
        viewModel { WelcomeViewModel() }
    }
    scope(named<TeamFragment>()) {
        viewModel { TeamViewModel() }
    }
}