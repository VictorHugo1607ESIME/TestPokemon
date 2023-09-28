package com.example.testpokeon.views.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.testpokeon.R;
import com.example.testpokeon.constants.Constants;
import com.example.testpokeon.models.PokemonDAO;
import com.squareup.picasso.Picasso;

public class PokemonDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        initUI();
    }

    private void initUI(){
        Intent intent = getIntent();
        PokemonDAO pokemon = (PokemonDAO) intent.getSerializableExtra(Constants.POKEMON);

        TextView namePokemon = findViewById(R.id.tvName);
        TextView typePokemon = findViewById(R.id.tvType);
        ImageView imagePokemon = findViewById(R.id.ivPokemon);
        ImageView imageIsFavorite = findViewById(R.id.ivIsFavorite);

        if(pokemon.isFavorite())
            imageIsFavorite.setImageResource(R.drawable.estrella_completa);

        namePokemon.setText(pokemon.getName());
        typePokemon.setText(pokemon.getType());
        Picasso.get()
                .load(pokemon.getUrlImage())
                .into(imagePokemon);

    }
}