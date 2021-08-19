package com.example.harajtask.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harajtask.databinding.ItemRecyclerMainBinding
import com.example.harajtask.domain.ProductModelsItem

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainREVH>() {

    private val list: ArrayList<ProductModelsItem> = arrayListOf()
    lateinit var mainAdpterHelper: MainAdpterHelper


    inner class MainREVH(private val items: ItemRecyclerMainBinding) :
        RecyclerView.ViewHolder(items.root) {

        fun bindMe(productModelsItem: ProductModelsItem) {
            items.titleItem.text = productModelsItem.title

            if (productModelsItem.commentCount == 0) {
                items.txtCountComment.visibility = View.GONE
            } else {
                items.txtCountComment.text = productModelsItem.commentCount.toString()
            }


            items.txtLocations.text = productModelsItem.city
            items.txtUserName.text = productModelsItem.username


            Glide
                .with(items.imgItem)
                .load(productModelsItem.thumbURL)
                .centerCrop()
                .into(items.imgItem)





            items.root.setOnClickListener {

                mainAdpterHelper.onClickItem(adapterPosition)
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainREVH {
        val view =
            ItemRecyclerMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainREVH(view)
    }

    override fun onBindViewHolder(holder: MainREVH, position: Int) {
        holder.bindMe(list[position])
    }

    override fun getItemCount(): Int = list.size


    fun setData(newls: Array<ProductModelsItem>) {

        val diffCallBack = MainDiffCallback(list, newls)
        val defRes = DiffUtil.calculateDiff(diffCallBack)
        list.addAll(newls)
        defRes.dispatchUpdatesTo(this)

    }


}