package com.example.testpokeon.services

object CallServices {

    fun pokemonService() = RetrofitClient.retrofit().create(
        PokemonServices::class.java
    )

}