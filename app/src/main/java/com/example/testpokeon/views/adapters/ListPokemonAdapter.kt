package com.example.testpokeon.views.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testpokeon.R
import com.example.testpokeon.Utils.ValidateName
import com.example.testpokeon.databinding.ItemPokemonListBinding
import com.example.testpokeon.interfaces.Interfaces
import com.example.testpokeon.models.PokemonDAO
import com.squareup.picasso.Picasso
import okhttp3.internal.Util

class ListPokemonAdapter(private val context: Context, private val itemSelected: Interfaces.onClickItemSelect, private val cardSelected: Interfaces.onClickCardSelect): ListAdapter<PokemonDAO, ListPokemonAdapter.ViewHolder>(DiffCallBack) {

    companion object DiffCallBack: DiffUtil.ItemCallback<PokemonDAO>(){
        override fun areItemsTheSame(oldItem: PokemonDAO, newItem: PokemonDAO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PokemonDAO, newItem: PokemonDAO): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder {
        val binding: ItemPokemonListBinding = ItemPokemonListBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon: PokemonDAO = getItem(position)
        holder.bind(pokemon)
    }

    inner class ViewHolder(private val binding:ItemPokemonListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(pokemon: PokemonDAO){
            val validateName = ValidateName()
            val customView = LayoutInflater.from(binding.root.context).inflate(R.layout.image_pokemon, binding.ivPokemon, false)

            val cardCustomPokemon = customView.findViewById<CardView>(R.id.contentCard)
            val cardTextPokemon = customView.findViewById<CardView>(R.id.contentName)
            val ivCustomPokemon = customView.findViewById<ImageView>(R.id.ivPokeball)
            val tvCustomPokemon = customView.findViewById<TextView>(R.id.tvName)

            if(!pokemon.urlImage.isNullOrEmpty())
                Picasso.get().load(pokemon.urlImage).into(ivCustomPokemon)
            else if (pokemon.urlImage.isNullOrEmpty() && !pokemon.name.isNullOrEmpty() && !validateName.validateFirstLetter(pokemon.name.toString())){
                tvCustomPokemon.text = validateName.getInitialName(pokemon.name.toString())
                cardTextPokemon.visibility = View.VISIBLE
                ivCustomPokemon.visibility = View.GONE
                cardCustomPokemon.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(binding.root.context, R.color.green))
            }
            //else if(pokemon.urlImage.isNullOrEmpty() && pokemon.name.isNullOrEmpty())


            binding.ivPokemon.removeAllViews()

            binding.ivPokemon.addView(customView)

            if (pokemon.isFavorite)
                binding.ivIsFavorite.setImageResource(R.drawable.estrella_completa)

            binding.tvName.text = pokemon.name.toString()
            binding.tvType.text = pokemon.type.toString()

            binding.ivIsFavorite.setOnClickListener {
                itemSelected.itemSelect(pokemon)
            }

            binding.contentItemPokemon.setOnClickListener {
                cardSelected.cardSelect(pokemon)
            }

        }
    }

}