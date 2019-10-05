package com.example.androidcapstone.model.datasource.remote.network.retrofit

import com.example.androidcapstone.model.datasource.remote.network.retrofit.OwlApi_Constants.Companion.BASE_URL
import com.example.androidcapstone.model.datasource.remote.network.retrofit.services.OverwatchApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    private fun getLoggingInterceptor() : HttpLoggingInterceptor {
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    private fun getClient() : OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build()
    }

    private fun getInstance() : Retrofit{
        return Retrofit.Builder().client(getClient()).baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun getService() : OverwatchApiService {
        return getInstance().create(OverwatchApiService::class.java)
    }
}