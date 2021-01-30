package com.riyanurdiansyah.trawlbens.codetest2.api

import com.riyanurdiansyah.trawlbens.codetest2.model.Categories
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("categories.php")
    fun getCategories(): Call<Categories>
}