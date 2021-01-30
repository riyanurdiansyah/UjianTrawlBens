package com.riyanurdiansyah.trawlbens.codetest2.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("categories")
    val categories: List<Category>?
)