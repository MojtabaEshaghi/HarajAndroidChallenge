package com.example.harajtask.data.repositorys

import android.content.Context
import com.example.harajtask.domain.ProductModelsItem
import com.example.harajtask.utils.loadJsonFromAssets
import javax.inject.Inject


class MainRepository @Inject constructor(private val context: Context) {

    suspend fun getAllProduct(): Array<ProductModelsItem> = context.loadJsonFromAssets()


}