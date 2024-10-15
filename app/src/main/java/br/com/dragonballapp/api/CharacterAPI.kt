package br.com.dragonballapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterAPI {

   fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dragonball-api.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}