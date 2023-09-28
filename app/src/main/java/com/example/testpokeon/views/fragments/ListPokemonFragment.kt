package com.example.testpokeon.views.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testpokeon.constants.Constants
import com.example.testpokeon.databinding.FragmentPokemonsBinding
import com.example.testpokeon.interfaces.Interfaces
import com.example.testpokeon.models.PokemonDAO
import com.example.testpokeon.views.activitys.PokemonDetailActivity
import com.example.testpokeon.views.adapters.ListPokemonAdapter
import com.example.testpokeon.views.fragments.viewmodels.ListPokemonViewModel
import kotlinx.coroutines.launch

class ListPokemonFragment : Fragment(), Interfaces.onClickItemSelect, Interfaces.onClickCardSelect {

    private lateinit var binding: FragmentPokemonsBinding
    private lateinit var listPokemonViewModel: ListPokemonViewModel
    private lateinit var listPokemonAdapter: ListPokemonAdapter
    private var listPokemon: ArrayList<PokemonDAO> = ArrayList()
    private var isLastItemReached = false
    private var isUpdateListPokemon = true
    private var setListFirst = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        listPokemonViewModel = ListPokemonViewModel(requireActivity())
        initUI()
        initListeners()
        initObserve()
        return binding.root
    }

    private fun initUI() {
        binding.rvListPokemon.layoutManager = LinearLayoutManager(context)
        listPokemonAdapter = ListPokemonAdapter(requireContext(),this, this)
        binding.rvListPokemon.adapter = listPokemonAdapter

        val connectivityManager = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)

        if (capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) != true)
            listPokemonViewModel.getListPokemonDB()
        else
            listPokemonViewModel.getListPokemon()
    }

    private fun initListeners() {
        binding.rvListPokemon.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager
                val visibleItemCount = layoutManager?.childCount ?: 0
                val totalItemCount = layoutManager?.itemCount ?: 0
                val firstVisibleItemPosition = (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (!isLastItemReached && visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 && isUpdateListPokemon
                ) {
                    isUpdateListPokemon = false
                    listPokemonViewModel.getListPokemon()
                    isLastItemReached = true
                } else if (isLastItemReached && firstVisibleItemPosition < totalItemCount - 1) {
                    isLastItemReached = false
                }
            }
        })
    }

    private fun initObserve() {
        lifecycleScope.launch {
            listPokemonViewModel.listPokemonStatus.collect{response ->
                when(response.status){
                    Constants.LOAD -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    Constants.SUCCESS -> {
                        if(!response.listPokemon.isEmpty()){
                            binding.tvListEmpty.visibility = View.GONE
                            listPokemon.addAll(response.listPokemon)
                            loadList()
                        }else
                            binding.tvListEmpty.visibility = View.VISIBLE

                        binding.progressBar.visibility = View.GONE
                    }
                    Constants.FAIL -> {

                    }
                }
            }
        }
    }

    private fun loadList() {
        listPokemon.distinct()
        if (setListFirst)
            listPokemonAdapter.notifyDataSetChanged()
        else{
            setListFirst = true
            listPokemonAdapter.submitList(listPokemon)
        }
        isUpdateListPokemon = true
    }

    override fun itemSelect(value: Any) {
        val pokemonFavorite = value as PokemonDAO
        val pokemonToUpdate = listPokemon.find { it.id == pokemonFavorite.id }
        pokemonToUpdate!!.isFavorite = !pokemonToUpdate.isFavorite
        listPokemonAdapter.notifyDataSetChanged()
        listPokemonViewModel.insertListPokemonDB(listPokemon)
    }

    override fun cardSelect(value: Any) {
        val pokemon = value as PokemonDAO
        val intent = Intent(requireActivity(), PokemonDetailActivity::class.java)
        intent.putExtra(Constants.POKEMON, pokemon)
        startActivity(intent)
    }
}