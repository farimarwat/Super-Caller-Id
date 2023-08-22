package com.fungiggle.fridatest.ui.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {
    val baseurl = "https://www.tcendpoint.net/"

    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}