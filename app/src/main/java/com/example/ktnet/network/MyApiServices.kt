package com.example.ktnet.network

import com.example.ktnet.bean.UserBean
import retrofit2.http.GET

interface MyApiServices {
    //接口
   @GET("list?categoryId=1005001&page=1&size=10")

    //挂起函数
    suspend fun getUserInfo(): UserBean
}