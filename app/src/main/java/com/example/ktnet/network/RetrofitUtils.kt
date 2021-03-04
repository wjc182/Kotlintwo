package com.example.ktnet.network

import androidx.lifecycle.ViewModel
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//主构造函数
class RetrofitUtils private constructor(){

    val retrofit :  Retrofit

    //初始块
    init {
        val okHttpClient = OkHttpClient.Builder()
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl("http://cdwan.cn/api/goods/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    //    类似于java里面得静态，静态区域
    companion object{
        val retrofitUtils : RetrofitUtils by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitUtils()
        }
    }
    // 单独写 便于很多个 services
    fun <T> getApiServies(services: Class<T>) : T{
        return retrofit.create(services)
    }
}