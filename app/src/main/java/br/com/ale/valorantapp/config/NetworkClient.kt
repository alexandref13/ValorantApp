package br.com.ale.valorantapp.config

import br.com.ale.valorantapp.services.ValorantService
import retrofit2.Retrofit

private const val BASE_URL = "https://valorant-api.com/v1/"

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideValorantService(retrofit: Retrofit): ValorantService =
    retrofit.create(ValorantService::class.java)