package com.example.testpokeon.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testpokeon.models.PokemonDAO

@Dao
interface DbPokemonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListPokemon(list: List<PokemonDAO>)

    @Query("SELECT * FROM pokemon")
    fun getListPokemon(): MutableList<PokemonDAO>
}