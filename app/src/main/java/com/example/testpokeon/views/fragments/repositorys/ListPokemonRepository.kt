package com.example.testpokeon.views.fragments.repositorys

import androidx.room.util.copy
import com.example.testpokeon.constants.Constants
import com.example.testpokeon.database.PokemonDatabase
import com.example.testpokeon.models.DataPokemonStatus
import com.example.testpokeon.models.ListPokemonResponse
import com.example.testpokeon.models.PokemonDAO
import com.example.testpokeon.models.PokemonDetails
import com.example.testpokeon.models.PokemonResponse
import com.example.testpokeon.services.CallServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPokemonRepository(private val database: PokemonDatabase) {

    private val _responsePokemonStatus = MutableStateFlow(DataPokemonStatus())
    val responsePokemonStatus: StateFlow<DataPokemonStatus> = _responsePokemonStatus.asStateFlow()

    suspend fun getListPokemon(limit: Int, offset: Int){
        _responsePokemonStatus.update { it.copy(status = Constants.LOAD) }
        withContext(Dispatchers.IO){
            CallServices.pokemonService().getListGeneralPokemon(limit, offset).enqueue(object :
                Callback<ListPokemonResponse> {
                override fun onResponse(
                    call: Call<ListPokemonResponse>,
                    response: Response<ListPokemonResponse>
                ) {
                    if (response.code() == 200) {
                        val responseData = response.body()
                        _responsePokemonStatus.update {
                            it.copy(
                                listCategory = responseData as ListPokemonResponse,
                                status = Constants.SUCCESS,
                                operation = Constants.GET_LIST
                            )
                        }
                    } else {
                        _responsePokemonStatus.update {
                            it.copy(
                                status = Constants.FAIL,
                                message = response.message()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ListPokemonResponse>, t: Throwable) {
                    val message = t.message
                    _responsePokemonStatus.update {
                        it.copy(
                            status = Constants.FAIL,
                            message = t.message.toString()
                        )
                    }
                }
            })
        }
    }

    suspend fun getTypesPokemon(id: Int){
        _responsePokemonStatus.update { it.copy(status = Constants.LOAD) }
        withContext(Dispatchers.IO){
            CallServices.pokemonService().getTypesPokemon(id).enqueue(object :
                Callback<PokemonResponse> {
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    if (response.code() == 200) {
                        val responseData = response.body()
                        _responsePokemonStatus.update {
                            it.copy(
                                listType = responseData as PokemonResponse,
                                status = Constants.SUCCESS,
                                operation = Constants.GET_TYPES
                            )
                        }
                    } else {
                        _responsePokemonStatus.update {
                            it.copy(
                                status = Constants.FAIL,
                                message = response.message()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    _responsePokemonStatus.update {
                        it.copy(
                            status = Constants.FAIL,
                            message = t.message.toString()
                        )
                    }
                }
            })
        }
    }

    suspend fun getPokemonDetail(id: Int){
        _responsePokemonStatus.update { it.copy(status = Constants.LOAD) }
        withContext(Dispatchers.IO){
            CallServices.pokemonService().getPokemonData(id).enqueue(object :
                Callback<PokemonDetails> {
                override fun onResponse(
                    call: Call<PokemonDetails>,
                    response: Response<PokemonDetails>
                ) {
                    if (response.code() == 200) {
                        val responseData = response.body()
                        _responsePokemonStatus.update {
                            it.copy(
                                pokemon = responseData as PokemonDetails,
                                status = Constants.SUCCESS,
                                operation = Constants.GET_POKEMON
                            )
                        }
                    } else {
                        _responsePokemonStatus.update {
                            it.copy(
                                status = Constants.FAIL,
                                message = response.message()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<PokemonDetails>, t: Throwable) {
                    _responsePokemonStatus.update {
                        it.copy(
                            status = Constants.FAIL,
                            message = t.message.toString()
                        )
                    }
                }
            })
        }
    }

    suspend fun insertListPokemon(list: List<PokemonDAO>){
        return withContext(Dispatchers.IO){
            database.pokemonDAO.insertListPokemon(list)
        }
    }

    suspend fun getListPokemonDB(): List<PokemonDAO>{
        return withContext(Dispatchers.IO){
            database.pokemonDAO.getListPokemon()
        }
    }

}