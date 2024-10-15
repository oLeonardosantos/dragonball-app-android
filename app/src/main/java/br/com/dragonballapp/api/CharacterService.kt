package br.com.dragonballapp.api

import br.com.dragonballapp.models.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {

    @GET("characters")
    suspend fun getCharacters(): Response<CharacterResponse>
}