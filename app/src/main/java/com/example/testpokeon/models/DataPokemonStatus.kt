package com.example.testpokeon.models

import com.example.testpokeon.constants.Constants

data class DataPokemonStatus(

    var listCategory: ListPokemonResponse = ListPokemonResponse(),
    var listType: PokemonResponse = PokemonResponse(),
    var pokemon: PokemonDetails = PokemonDetails(),
    var status: Int = 0,
    var operation: String = Constants.STRING_EMPTY,
    var message: String = Constants.STRING_EMPTY

)