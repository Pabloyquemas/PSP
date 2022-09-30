package com.pgonrod.psp2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pgonrod.psp2022.ut02.data.remote.RetrofitApiClient

class MainActivity : AppCompatActivity() {

    val apiClient = RetrofitApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient.getUsers()
    }
}