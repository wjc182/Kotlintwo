package com.example.ktnet.adapter
import com.bumptech.glide.Glide
import com.example.ktnet.BR
import com.example.ktnet.R
import com.example.ktnet.bean.Goods
import kotlinx.android.synthetic.main.rec_item.view.*

//泛型是什么
class RecAdapter : BaseAdapter<Goods>(){

    //继承抽象方法
    override fun getAdapterLayoutID()= R.layout.rec_item

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
      //  TODO("Not yet implemented")

        val db=holder.item
        val id=list.get(position)
        //设置变量
        db.setVariable(BR.itemdata,id)
        //图片
        Glide.with(holder.item.root.rec_image).load(id.list_pic_url).into(holder.item.root.rec_image)
        
    }
}