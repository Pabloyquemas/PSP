package com.pgonrod.psp2022.ut02.ex02.data.remote.models

import com.pgonrod.psp2022.ut02.ex01.data.remote.models.UserApiModel
import com.pgonrod.psp2022.ut02.ex02.data.remote.ApiEndPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClientPlague {
    private val urlEndPoint = "https://plagricola.sitehub.es/api/public/"
    private var apiEnPoint: ApiEndPoint

    init {
        apiEnPoint = buildApiEndPoint()

    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun buildApiEndPoint(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }


    fun getAlert(): List<PlagueApiModel>{
        val callAlert = apiEnPoint.getAlert() //Llamada
        val response = callAlert.execute() //Ejecucion de la llamada
        return if (response.isSuccessful){
            val users = response.body() //La respuesta del Gson estara en el body
            users ?: emptyList() // si es nulo me devuelve una lista vacia
        } else {
            emptyList()
        }
    }
    fun getAlerts(): List<PlagueApiModel>{
        val callstatus = apiEnPoint.getstatus() //Llamada
        val responsestaus = callstatus.execute() //Ejecucion de la llamada
        return if (responsestaus.isSuccessful){
            val status = responsestaus.body()
            status ?: emptyList<>()
        } else {
            emptyList()
        }
    }

}