package com.example.harajtask.data.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.harajtask.domain.ProductModelsItem

class MainDiffCallback(
    private val oldList: ArrayList<ProductModelsItem>,
    private val newList: Array<ProductModelsItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_, title, city, commentCount, userName) = oldList[oldItemPosition]
        val (_, title2, city2, commentCount2, userName2) = newList[newItemPosition]


        return title == title2 && city == city2 && commentCount == commentCount2 && userName == userName2
    }
}