package com.example.rickmortyapp_paolo.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // Inicialización de Retrofit con la URL base de la API y el convertidor Gson
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())  // Agregar el convertidor Gson
            .build()
            .create(ApiService::class.java)
    }
}
