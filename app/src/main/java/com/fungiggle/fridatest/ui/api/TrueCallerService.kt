package com.fungiggle.fridatest.ui.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface TrueCallerService {

    @GET("v2/search?q=03149494094&countryCode=PK&type=1&encoding=json")
    @Headers(
        "Host: search5-noneu.truecaller.com",
        "Accept: application/x-protobuf",
        "Authorization: Bearer a2i0X--hNsQYCkv-K_JBehR8o9G3ahnbYqYvizh2OIhwAxxxynMsGO08L6vh39u",
        "Accept-Encoding: gzip, deflate"
    )
    suspend fun searchPhone():Response<String>
}