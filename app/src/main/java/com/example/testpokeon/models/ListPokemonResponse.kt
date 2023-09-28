package com.example.testpokeon.models

import java.io.Serializable

data class ListPokemonResponse(
    val count: Int? = 0,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Ability> ?= emptyList()
):Serializable

data class Ability(
    val name: String? = "",
    val url: String? = ""
):Serializable