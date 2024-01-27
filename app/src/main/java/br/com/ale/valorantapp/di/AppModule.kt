package br.com.ale.valorantapp.di

import br.com.ale.valorantapp.config.provideRetrofit
import br.com.ale.valorantapp.config.provideValorantService
import br.com.ale.valorantapp.db.provideDao
import br.com.ale.valorantapp.db.provideDatabase
import br.com.ale.valorantapp.repositories.favoriteagents.FavoriteAgentsRepository
import br.com.ale.valorantapp.repositories.favoriteagents.FavoriteAgentsRepositoryImp
import br.com.ale.valorantapp.repositories.valorant.ValorantRepository
import br.com.ale.valorantapp.repositories.valorant.ValorantRepositoryImp
import br.com.ale.valorantapp.ui.screens.agentDetail.AgentDetailsViewModel
import br.com.ale.valorantapp.ui.screens.agentsList.AgentViewModel
import br.com.ale.valorantapp.ui.screens.favoritesagents.FavoriteAgentsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    factory<ValorantRepository> { ValorantRepositoryImp(get()) }
    factory<FavoriteAgentsRepository> { FavoriteAgentsRepositoryImp(get()) }
    viewModel { AgentViewModel(get()) }
    viewModel { AgentDetailsViewModel(get()) }
    viewModel { FavoriteAgentsViewModel(get()) }
}

val networkModule = module {
    single { provideRetrofit() }
    single { provideValorantService(get()) }
}

val databaseModule = module {
    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
}
