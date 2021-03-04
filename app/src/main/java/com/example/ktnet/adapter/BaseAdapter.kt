package com.example.ktnet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder>() {

    var list : List<T> = listOf()


    //方法
    fun setData(listva : List<T>){
        list = listva
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
//     DataBinding
        val view : ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),getAdapterLayoutID(),parent,false)
        return BaseViewHolder(view)
    }
    abstract fun getAdapterLayoutID():Int

    //集合长度
    override fun getItemCount(): Int {
        return list.size
    }
    abstract override fun onBindViewHolder(holder: BaseViewHolder, position: Int)
}

class BaseViewHolder(var item: ViewDataBinding):RecyclerView.ViewHolder(item.root)