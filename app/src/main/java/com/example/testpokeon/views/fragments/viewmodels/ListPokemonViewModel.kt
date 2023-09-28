package com.example.testpokeon.views.fragments.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testpokeon.constants.Constants
import com.example.testpokeon.constants.Constants.NUMBER_POKEMON_PAGE
import com.example.testpokeon.database.PokemonDatabase
import com.example.testpokeon.database.getDatabase
import com.example.testpokeon.models.Ability
import com.example.testpokeon.models.ListPokemonStatus
import com.example.testpokeon.models.PokemonDAO
import com.example.testpokeon.views.fragments.repositorys.ListPokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListPokemonViewModel(private val context: Context):ViewModel() {

    private val database: PokemonDatabase = getDatabase(context)
    private val listPokemonRepository = ListPokemonRepository(database)
    private var offest = 0
    var listPokemon: ArrayList<PokemonDAO> = ArrayList()
    private var numberListPokemon: Int = 0
    private var itemListPokemon: Int = 0

    private val _listPokemonStatus = MutableStateFlow(ListPokemonStatus())
    val listPokemonStatus: StateFlow<ListPokemonStatus> = _listPokemonStatus.asStateFlow()

    init {
        observe()
    }

    fun getListPokemon(){
        viewModelScope.launch {
            try {
                listPokemonRepository.getListPokemon(NUMBER_POKEMON_PAGE, offest)
            }catch (e: Exception){

            }
        }
    }

    private fun getTypePokemon(id: Int){
        viewModelScope.launch {
            try {
                listPokemonRepository.getTypesPokemon(id)
            }catch (e: Exception){

            }
        }
    }

    private fun getPokemonDetails(id: Int){
        viewModelScope.launch {
            try {
                listPokemonRepository.getPokemonDetail(id)
            }catch (e: Exception){

            }
        }
    }

    private fun observe() {
        viewModelScope.launch {
            listPokemonRepository.responsePokemonStatus.collect{ response ->
                when(response.status){

                    Constants.LOAD -> {

                    }

                    Constants.SUCCESS -> {
                        when(response.operation){
                            Constants.GET_LIST -> {
                                offest += NUMBER_POKEMON_PAGE
                                listPokemon.clear()
                                val list = response.listCategory.results as ArrayList<Ability>
                                numberListPokemon = list.count()
                                itemListPokemon = 0
                                list.forEach {
                                    getPokemonDetails(getIdURL(it.url.toString()))
                                }
                            }
                            Constants.GET_TYPES -> {

                            }
                            Constants.GET_POKEMON -> {
                                _listPokemonStatus.update { it.copy( status = Constants.LOAD ) }
                                itemListPokemon += 1
                                val pokemonDetails = response.pokemon
                                val types = pokemonDetails.types?.joinToString(" ") { it.type.name } ?: ""
                                listPokemon.add(PokemonDAO(
                                    pokemonDetails.id,
                                    pokemonDetails.name,
                                    pokemonDetails.sprites!!.frontDefault,
                                    pokemonDetails.height,
                                    pokemonDetails.weight,
                                    types
                                ))
                                if(itemListPokemon == numberListPokemon){
                                    itemListPokemon = 0
                                    listPokemon.sortBy { it.id }
                                    insertListPokemonDB(listPokemon)
                                    listPokemonRepository.insertListPokemon(listPokemon)
                                    _listPokemonStatus.update {
                                        it.copy(
                                            listPokemon = listPokemon,
                                            status = Constants.SUCCESS
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Constants.FAIL -> {

                    }

                }
            }
        }
    }

    fun insertListPokemonDB(list: List<PokemonDAO>){
        viewModelScope.launch {
            listPokemonRepository.insertListPokemon(list)
        }
    }

     fun getListPokemonDB(){
        viewModelScope.launch {
            val getListPokemon = listPokemonRepository.getListPokemonDB()
            _listPokemonStatus.update {
                it.copy(
                    listPokemon = getListPokemon as ArrayList<PokemonDAO>,
                    status = Constants.SUCCESS
                )
            }
        }
    }

    fun getIdURL(url: String): Int {
        var number = url.replaceFirst("https://pokeapi.co/api/v2/pokemon/", "")
        number = number.replace("/", "")
        return number.toInt()
    }
}