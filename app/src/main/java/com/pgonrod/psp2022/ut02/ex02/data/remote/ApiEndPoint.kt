package com.pgonrod.psp2022.ut02.ex02.data.remote

import com.pgonrod.psp2022.ut02.ex02.data.remote.models.PlagueApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET ("alert")
    fun getAlert(): Call<List<PlagueApiModel>>

}