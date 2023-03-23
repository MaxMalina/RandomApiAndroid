package com.exam.randomuser.di

import com.exam.randomuser.data.RandomApi
import com.exam.randomuser.data.RandomRepository
import com.exam.randomuser.data.RandomRepositoryImpl
import com.exam.randomuser.data.Urls
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        OkHttpClient.Builder().build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Urls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(RandomApi::class.java)
    }

    factory<RandomRepository> {
        RandomRepositoryImpl(
            randomApi = get()
        )
    }
}

val appModules = listOf(
    appModule,
    viewModelModule,
)
