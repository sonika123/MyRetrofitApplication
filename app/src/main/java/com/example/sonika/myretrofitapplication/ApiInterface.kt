package com.example.sonika.myretrofitapplication


import com.example.sonika.myretrofitapplication.Model.Model
import retrofit2.Call

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


interface ApiInterface {



     @GET("list/occupation")
    fun reposForUser() :
             Call<List<Model.User>>

     companion object {

         var httpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))


         var builder: Retrofit.Builder = Retrofit.Builder()
                 .baseUrl(Constant.BASE_URL)
                 .addConverterFactory(
                         GsonConverterFactory.create()
                 )

         var retrofit = builder
                 .client(
                         httpClient.build()
                 )
                 .build()

         var client = retrofit.create<ApiInterface>(ApiInterface::class.java)
     }
 }
