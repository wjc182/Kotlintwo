package com.example.ktnet.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktnet.bean.UserBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel  : ViewModel() {

    val userBean : MutableLiveData<UserBean> by lazy {
        MutableLiveData<UserBean>().also {
            getHttpUserInfo()
        }
    }

    //网络请求
    fun getHttpUserInfo(){
//        创建协程
        viewModelScope.launch {
//       网络请求耗时操作，返回得，协程构建起，可以获得延迟返回结果得构建起
            val data : UserBean = withContext(Dispatchers.IO){
                RetrofitUtils.retrofitUtils.getApiServies(MyApiServices::class.java).getUserInfo()
            }
            userBean.postValue(data)
        }
    }
}