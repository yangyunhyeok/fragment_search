package com.example.npcamp_fragmentsearch20230918.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetWorkClient {

//    fun getService(): NetWorkInterface = retrofit.create(NetWorkInterface::class.java)
//
//    private val retrofit =
//        Retrofit.Builder()
//            .baseUrl("https://dapi.kakao.com") // 도메인 주소
//            .addConverterFactory(GsonConverterFactory.create()) // GSON을 사요아기 위해 ConverterFactory에 GSON 지정
//            .build()
    private const val Search_BASE_URL = "https://dapi.kakao.com/v2/search/image/"
    val apiService: NetWorkInterface
        get() = instance.create(NetWorkInterface::class.java)

    private val instance: Retrofit
        private get() {
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(Search_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

}