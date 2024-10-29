package com.example.rickmortyapp_paolo.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.rickmortyapp_paolo.model.Character
import com.example.rickmortyapp_paolo.model.CharacterResponse

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") characterId: Int): Response<Character>
}
