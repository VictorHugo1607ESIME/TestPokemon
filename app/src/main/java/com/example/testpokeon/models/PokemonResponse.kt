package com.example.testpokeon.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EffectChange(
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry> = emptyList(),
    @SerializedName("version_group") val versionGroup: VersionGroup? = VersionGroup()
)

data class EffectEntry(
    val effect: String = "",
    val language: Language? = Language(),
    @SerializedName("short_effect") val shortEffect: String? = ""
)

data class Language(
    val name: String? = "",
    val url: String? = ""
)

data class Generation(
    val name: String? = "",
    val url: String? = ""
)

data class PokemonResponse(
    val id: Int? = 0,
    @SerializedName("effect_changes") val effectChanges: List<EffectChange>? = emptyList(),
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry>? = emptyList(),
    @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>? = emptyList(),
    val generation: Generation? = Generation(),
    @SerializedName("is_main_series") val isMainSeries: Boolean? = false,
    val name: String? = "",
    val names: List<Name>? = emptyList(),
    val pokemon: List<PokemonItem>? = emptyList()
)

data class FlavorTextEntry(
    @SerializedName("flavor_text") val flavorText: String? = "",
    val language: Language? = null,
    @SerializedName("version_group") val versionGroup: VersionGroup? = VersionGroup()
)

data class Name(
    val language: Language? = Language(),
    val name: String? = ""
)

data class PokemonItem(
    @SerializedName("is_hidden") val isHidden: Boolean? = false,
    val pokemon: Pokemon? = Pokemon(),
    val slot: Int? = 0
)

data class Pokemon(
    val name: String? = "",
    val url: String? = ""
)

data class VersionGroup(
    val name: String? = "",
    val url: String? = ""
)