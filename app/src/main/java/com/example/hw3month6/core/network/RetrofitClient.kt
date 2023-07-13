package com.example.hw3month6.core.network

import androidx.viewbinding.BuildConfig
import com.example.hw3month6.data.remote.ApiServise
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object{
        fun create() : ApiServise {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

            val retrofitClient = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BUILD_TYPE)
                .client(okHttpClient)
                .build()

            return retrofitClient.create(ApiServise::class.java)
        }
    }
}