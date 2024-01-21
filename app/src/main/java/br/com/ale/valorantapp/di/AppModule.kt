package br.com.ale.valorantapp.di

import br.com.ale.valorantapp.config.provideRetrofit
import br.com.ale.valorantapp.config.provideValorantService
import br.com.ale.valorantapp.repositories.ValorantRepository
import br.com.ale.valorantapp.repositories.ValorantRepositoryImp
import org.koin.dsl.module


val appModule = module{
    factory<ValorantRepository> { ValorantRepositoryImp(get()) }
//    viewModel<AgentViewModel> { AgentViewModel(get()) }
}

val networkModule = module {
    single { provideRetrofit() }
    single { provideValorantService(get()) }
}
