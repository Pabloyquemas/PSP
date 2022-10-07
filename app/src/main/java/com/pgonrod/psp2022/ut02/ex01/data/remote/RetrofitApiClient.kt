package com.pgonrod.psp2022.ut02.ex01.data.remote

import com.pgonrod.psp2022.ut02.ex01.data.remote.models.UserApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {

    private val urlEndPoint = "https://jsonplaceholder.typicode.com/"
    private var apiEnPoints: ApiEndPoints

    init {
        apiEnPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoints(): ApiEndPoints {
       return buildClient().create(ApiEndPoints::class.java)
    }

    fun getUsers(): List<UserApiModel>{
        val callUsers = apiEnPoints.getUsers() //Llamada
        val response = callUsers.execute() //Ejecucion de la llamada
        return if (response.isSuccessful){
            val users = response.body() //La respuesta del Gson estara en el body
            users ?: emptyList() // si es nulo me devuelve una lista vacia
        } else {
            emptyList()
        }
    }
    fun getUser(userId: Int): UserApiModel? {
        val userCall = apiEnPoints.getUser(userId)
        val response = userCall.execute()
        return if (response.isSuccessful) {
                response.body() //La respuesta del Gson estara en el body
        } else {
            null
        }
    }
}