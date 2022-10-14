package com.pgonrod.psp2022.ut02.ex02.data.remote

import com.pgonrod.psp2022.ut02.ex01.data.remote.models.UserApiModel
import com.pgonrod.psp2022.ut02.ex02.data.remote.models.PlagueApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    @GET ("alerts")
    fun getAlert(): Call<List<PlagueApiModel>>

    @GET("alerts/{statusCode}")
    fun getstatus(@Path("statusCode") statusCode: Int): Call<UserApiModel>

}