package com.example.harajtask.utils

import android.content.Context
import com.example.harajtask.domain.ProductModelsItem
import com.fasterxml.jackson.databind.ObjectMapper


fun Context.loadJsonFromAssets(): Array<ProductModelsItem> {

    return ObjectMapper().readValue(assets.open("data.json"), Array<ProductModelsItem>::class.java)


}