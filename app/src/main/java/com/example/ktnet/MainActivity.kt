package com.example.ktnet

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktnet.adapter.RecAdapter
import com.example.ktnet.databinding.ActivityMainBinding

import com.example.ktnet.network.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //找model
    val  model : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

      val binding: ActivityMainBinding = DataBindingUtil.setContentView( this, R.layout.activity_main)
        //函数
        kotlin_rec.apply {
            //布局管理
            layoutManager = LinearLayoutManager(this@MainActivity)
            //绑定适配器
            adapter = RecAdapter()
        }

        //rec布局管理java 
//        val linearLayoutManager = LinearLayoutManager(this)
//        kotlin_rec.setLayoutManager(linearLayoutManager)
//        //
//        val aa = RecAdapter()
//        kotlin_rec.setAdapter(aa)

        model.userBean.observe(this, androidx.lifecycle.Observer {
            //打印
            Log.e("TAG",it.toString())

            //找函数java 
//            aa.setData(it.data.goodsList)
//            //刷新
//            aa.notifyDataSetChanged()

            //适配器
            val recAdapter = kotlin_rec.adapter as RecAdapter
            recAdapter.setData(it.data.goodsList)
            recAdapter.notifyDataSetChanged()

        })
    }
}