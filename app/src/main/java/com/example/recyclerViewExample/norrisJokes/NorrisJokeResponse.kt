package com.example.recyclerViewExample.norrisJokes

import com.google.gson.annotations.SerializedName

data class NorrisJokeResponse (
    val categories: List<String>,
    val created_at: String,
    val icon_url: String,
    val id: String,
    val updated_at: String,
    val url: String,
    @SerializedName("value") var joke:String
    )
