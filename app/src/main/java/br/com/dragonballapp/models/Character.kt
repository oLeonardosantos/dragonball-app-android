package br.com.dragonballapp.models

import java.io.Serializable

data class Character (
    val image: String,
    val name: String,
    val description: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val affiliation: String,
):Serializable