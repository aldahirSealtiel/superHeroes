package com.aldahir.superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.aldahir.superheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String SUPER_HERO_KEY = "super_hero";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.saveButton.setOnClickListener(v -> {
            String superHeroName = binding.heroNameEdit.getText().toString();
            String alterEgoName = binding.alterNameEdit.getText().toString();
            String bioDescription = binding.bioEdit.getText().toString();
            float rating = binding.powerRating.getRating();
            System.out.println("datos 4");
            System.out.println(superHeroName);
            openDetailActivity(superHeroName,alterEgoName, bioDescription, rating);
        });
    }

    private void openDetailActivity(String superHeroName, String alterEgoName, String bioDescription, float rating)
    {
        //un intent nos ayuda a enviar información de un activity a otro
        //ejemplo de un explicit intent
        SuperHero superHero = new SuperHero(superHeroName, alterEgoName, bioDescription, rating);
        Intent intent = new Intent(this, DetailAcitivity.class);
        //para poder mandar un objeto en un intent debe implementar parcelables
        intent.putExtra(SUPER_HERO_KEY, superHero);

        startActivity(intent);
    }
}