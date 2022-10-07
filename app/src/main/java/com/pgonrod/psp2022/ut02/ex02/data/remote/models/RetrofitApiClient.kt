package com.pgonrod.psp2022.ut02.ex02.data.remote.models

import com.pgonrod.psp2022.ut02.ex01.data.remote.ApiEndPoints
import com.pgonrod.psp2022.ut02.ex01.data.remote.models.UserApiModel
import com.pgonrod.psp2022.ut02.ex02.data.remote.ApiEndPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {
    private val urlEndPoint = "https://plagricola.sitehub.es/api/public/alerts"
    private var apiEnPoints: ApiEndPoints

    init {
        apiEnPoints = buildApiEndPoints()

    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun buildApiEndPoints(): ApiEndPoints {
        return buildClient().create(ApiEndPoints::class.java)
    }
    fun getAlert(): List<PlagueApiModel>{
        val callAlert = ApiEndPoint.getAlert() //Llamada
        val response = callAlert.execute //Ejecucion de la llamada
        return if (response.isSuccessful){
            val users = response.body() //La respuesta del Gson estara en el body
            users ?: emptyList() // si es nulo me devuelve una lista vacia
        } else {
            emptyList()
        }
    }
}