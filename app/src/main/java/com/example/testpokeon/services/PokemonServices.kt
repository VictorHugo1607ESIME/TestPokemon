package com.example.testpokeon.services

import com.example.testpokeon.constants.Constants
import com.example.testpokeon.models.ListPokemonResponse
import com.example.testpokeon.models.PokemonDetails
import com.example.testpokeon.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonServices {

    @GET(Constants.URL_LIST_POKEMON)
    fun getListGeneralPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<ListPokemonResponse>

    @GET(Constants.URL_TYPES_POKEMON)
    fun getTypesPokemon(
        @Path("id") id: Int
    ): Call<PokemonResponse>

    @GET(Constants.URL_GET_POKEMON)
    fun getPokemonData(
        @Path("id") id: Int
    ): Call<PokemonDetails>

}