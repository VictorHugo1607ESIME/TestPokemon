package com.example.testpokeon.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testpokeon.constants.Constants
import com.example.testpokeon.models.PokemonDAO

@Database(entities = [PokemonDAO::class], version = Constants.VERSION_DB)
abstract class PokemonDatabase: RoomDatabase() {
    abstract val pokemonDAO: DbPokemonDAO
}

private lateinit var INSTANCE: PokemonDatabase

fun getDatabase(context: Context): PokemonDatabase {
    synchronized(PokemonDatabase::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE = Room
                .databaseBuilder(
                    context.applicationContext,
                    PokemonDatabase::class.java,
                    "pokemon_db"
                ).build()
        }
        return  INSTANCE
    }
}