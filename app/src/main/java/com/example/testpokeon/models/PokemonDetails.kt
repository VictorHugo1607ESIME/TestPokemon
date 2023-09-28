package com.example.testpokeon.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonDetails(
    val id: Int? = 0,
    val abilities: List<Ability2>? = emptyList(),
    @SerializedName("base_experience") val baseExperience: Int? = 0,
    val forms: List<Form>? = emptyList(),
    @SerializedName("game_indices") val gameIndices: List<GameIndex>? = emptyList(),
    val height: Int? = 0,
    @SerializedName("held_items") val heldItems: List<Any>? = emptyList(), // Puedes cambiar Any a un tipo más específico si es necesario
    @SerializedName("is_default") val isDefault: Boolean? = false,
    @SerializedName("location_area_encounters") val locationAreaEncounters: String? = "",
    val moves: List<Move>? = emptyList(),
    val name: String? = "",
    val order: Int? = 0,
    @SerializedName("past_types") val pastTypes: List<Any> = emptyList(), // Puedes cambiar Any a un tipo más específico si es necesario
    val species: Species? = Species(),
    val sprites: Sprites? = Sprites(),
    val stats: List<Stat>? = emptyList(),
    val types: List<Type>? = emptyList(),
    val weight: Int? = 0
)

data class Ability2(
    val ability: NameUrlPair,
    @SerializedName("is_hidden")
    val isHidden: Boolean = false,
    val slot: Int = 0
)

data class NameUrlPair(
    val name: String = "",
    val url: String = ""
)

data class Form(
    val name: String = "",
    val url: String = ""
)

data class GameIndex(
    @SerializedName("game_index")
    val gameIndex: Int = 0,
    val version: NameUrlPair
)

data class Move(
    val move: NameUrlPair,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int = 0,
    @SerializedName("move_learn_method")
    val moveLearnMethod: NameUrlPair,
    @SerializedName("version_group")
    val versionGroup: NameUrlPair
)

data class Species(
    val name: String = "",
    val url: String = ""
)

data class Sprites(
    @SerializedName("back_default") val backDefault: String? = null,
    @SerializedName("back_female") val backFemale: String? = null,
    @SerializedName("back_shiny") val backShiny: String? = null,
    @SerializedName("back_shiny_female") val backShinyFemale: String? = null,
    @SerializedName("front_default") val frontDefault: String? = null,
    @SerializedName("front_female") val frontFemale: String? = null,
    @SerializedName("front_shiny") val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = "",
    val other: OtherSprites = OtherSprites(),
    val versions: VersionsSprites? = VersionsSprites()
)

data class OtherSprites(
    @SerializedName("dream_world") val dreamWorld: DreamWorldSprites? = DreamWorldSprites(),
    val home: HomeSprites? = HomeSprites(),
    @SerializedName("official-artwork") val officialArtwork: OfficialArtworkSprites? = OfficialArtworkSprites()
)

data class DreamWorldSprites(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: String? = null
)

data class HomeSprites(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null
)

data class OfficialArtworkSprites(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null
)

data class VersionsSprites(
    @SerializedName("generation-i") val generationI: GenerationI = GenerationI(),
    @SerializedName("generation-ii") val generationII: GenerationII = GenerationII(),
    @SerializedName("generation-iii") val generationIII: GenerationIII = GenerationIII(),
    @SerializedName("generation-iv") val generationIV: GenerationIV = GenerationIV(),
    @SerializedName("generation-v") val generationV: GenerationV = GenerationV(),
    @SerializedName("generation-vi") val generationVI: GenerationVI = GenerationVI(),
    @SerializedName("generation-vii") val generationVII: GenerationVII = GenerationVII(),
    @SerializedName("generation-viii") val generationVIII: GenerationVIII = GenerationVIII()
)

data class GenerationSprites(
    val crystal: CrystalSprites? = CrystalSprites(),
    val gold: GoldSprites? = GoldSprites(),
    val silver: SilverSprites? = SilverSprites(),
    val emerald: EmeraldSprites? = EmeraldSprites(),
    @SerializedName("firered-leafgreen") val fireRedLeafGreen: FireRedLeafGreenSprites? = FireRedLeafGreenSprites(),
    @SerializedName("ruby-sapphire") val rubySapphire: RubySapphireSprites? = RubySapphireSprites(),
    @SerializedName("diamond-pearl") val diamondPearl: DiamondPearlSprites? = DiamondPearlSprites(),
    @SerializedName("heartgold-soulsilver") val heartGoldSoulSilver: HeartGoldSoulSilverSprites? = HeartGoldSoulSilverSprites(),
    val platinum: PlatinumSprites? = PlatinumSprites(),
    @SerializedName("black-white") val blackWhite: BlackWhiteSprites? = BlackWhiteSprites(),
    @SerializedName("omegaruby-alphasapphire") val omegaRubyAlphaSapphire: OmegaRubyAlphaSapphireSprites? = OmegaRubyAlphaSapphireSprites(),
    @SerializedName("x-y") val xy: XYSprites? = XYSprites(),
    val icons: IconsSprites? = IconsSprites(),
    @SerializedName("ultra-sun-ultra-moon") val ultraSunUltraMoon: UltraSunUltraMoonSprites? = UltraSunUltraMoonSprites()
)

data class CrystalSprites(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_transparent")
    val backShinyTransparent: String? = null,
    @SerializedName("back_transparent")
    val backTransparent: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_transparent")
    val frontShinyTransparent: String? = null,
    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

// Define las clases de sprites restantes de manera similar
// ...

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int = 0,
    val effort: Int = 0,
    val stat: NameUrlPair
)

data class Type(
    val slot: Int = 0,
    val type: NameUrlPair
)

data class GoldSprites(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

data class SilverSprites(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

data class EmeraldSprites(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = ""
)

data class FireRedLeafGreenSprites(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = ""
)

data class RubySapphireSprites(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = ""
)

data class DiamondPearlSprites(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class HeartGoldSoulSilverSprites(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class PlatinumSprites(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class BlackWhiteSprites(
    @SerializedName("animated")
    val animated: AnimatedSprites = AnimatedSprites(),
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class AnimatedSprites(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class OmegaRubyAlphaSapphireSprites(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class XYSprites(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class IconsSprites(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = ""
)

data class UltraSunUltraMoonSprites(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: RedBlue = RedBlue(),
    val yellow: Yellow = Yellow()
)

data class RedBlue(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_gray")
    val backGray: String = "",
    @SerializedName("back_transparent")
    val backTransparent: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_gray")
    val frontGray: String = "",
    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

data class Yellow(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_gray")
    val backGray: String = "",
    @SerializedName("back_transparent")
    val backTransparent: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_gray")
    val frontGray: String = "",
    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

data class GenerationII(
    val crystal: Crystal = Crystal(),
    val gold: Gold = Gold(),
    val silver: Silver = Silver()
)

data class Crystal(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_transparent")
    val backShinyTransparent: String = "",
    @SerializedName("back_transparent")
    val backTransparent: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_transparent")
    val frontShinyTransparent: String = "",
    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

data class Gold(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

data class Silver(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

data class GenerationIII(
    val emerald: Emerald = Emerald(),
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen = FireredLeafgreen(),
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphire = RubySapphire()
)

data class Emerald(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = ""
)

data class FireredLeafgreen(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = ""
)

data class RubySapphire(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = ""
)

data class GenerationIV(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearl = DiamondPearl(),
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver = HeartgoldSoulsilver(),
    val platinum: Platinum = Platinum()
)

data class DiamondPearl(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class HeartgoldSoulsilver(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class Platinum(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class GenerationV(
    @SerializedName("black-white")
    val blackWhite: BlackWhite = BlackWhite()
)

data class BlackWhite(
    val animated: Animated = Animated(),
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)

data class GenerationVI(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire = OmegarubyAlphasapphire(),
    val xy: XY = XY()
)

data class OmegarubyAlphasapphire(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null
)

data class XY(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null
)

data class GenerationVII(
    val icons: Icons = Icons(),
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon = UltraSunUltraMoon()
)

data class Icons(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String? = null
)

data class UltraSunUltraMoon(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null
)

data class GenerationVIII(
    val icons: Icons = Icons()
)

data class Animated(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_female")
    val frontFemale: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String = ""
)
