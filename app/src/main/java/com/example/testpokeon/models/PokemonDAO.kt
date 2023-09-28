package com.example.testpokeon.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testpokeon.constants.Constants
import java.io.Serializable

@Entity(tableName = Constants.POKEMON)
data class PokemonDAO(

    @PrimaryKey val id: Int? = 0,
    @ColumnInfo(name = "name"           ) var name       : String? = "",
    @ColumnInfo(name = "url_image"      ) var urlImage   : String? = "",
    @ColumnInfo(name = "height"         ) val height     : Int? = 0,
    @ColumnInfo(name = "weight"         ) val weight     : Int? = 0,
    @ColumnInfo(name = "type"           ) val type       : String? = "",
    @ColumnInfo(name = "is_favorite"    ) var isFavorite : Boolean = false

): Serializable