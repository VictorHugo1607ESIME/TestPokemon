package com.example.testpokeon.models

import com.example.testpokeon.constants.Constants
import java.io.Serializable

data class ListPokemonStatus(

    var listPokemon: ArrayList<PokemonDAO> = ArrayList(),
    var status: Int = 0,
    var message: String = Constants.STRING_EMPTY

): Serializable