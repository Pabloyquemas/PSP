package com.pgonrod.psp2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pgonrod.psp2022.ut02.ex01.data.remote.RetrofitApiClient
import com.pgonrod.psp2022.ut02.ex02.data.remote.models.RetrofitApiClientPlague

class MainActivity : AppCompatActivity() {

    //val apiClient = RetrofitApiClient()
    val apiClientplague = RetrofitApiClientPlague()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        Thread {
            val users =  apiClient.getUsers()
            Log.d("@dev", "Usuarios: $users")
        }.start()
        Thread {
            val user =  apiClient.getUser(1)
            Log.d("@dev", "Usuario: $user")
        }.start()
        */
        Thread {
            val alert = apiClientplague.getAlert()
            Log.d("@dev", "Plague: $alert")
        }.start()

    }
}