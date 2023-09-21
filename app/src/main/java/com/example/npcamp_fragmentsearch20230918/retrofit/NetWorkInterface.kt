package com.example.npcamp_fragmentsearch20230918.retrofit

import com.example.npcamp_fragmentsearch20230918.data.Image
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


interface NetWorkInterface {
    //    @Headers("Authorization: KakaoAK 3f68eb5f972362fbf9416af7fbea96f5")
    @GET("/v2/search/image")
    fun requestSearchImage(
        @Header("Authorization") apiKey: String?,
        @Query("query") keyword: String,
        @Query("sort") sort: String = "recency",
        @Query("page") page: Int,
        @Query("size") size: Int
    ):Call<Image>
}