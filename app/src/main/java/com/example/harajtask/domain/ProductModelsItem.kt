package com.example.harajtask.domain


import com.fasterxml.jackson.annotation.JsonProperty

data class ProductModelsItem(
    @JsonProperty("body")
    val body: String,
    @JsonProperty("city")
    val city: String,
    @JsonProperty("commentCount")
    val commentCount: Int,
    @JsonProperty("date")
    val date: Int,
    @JsonProperty("thumbURL")
    val thumbURL: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("username")
    val username: String
)