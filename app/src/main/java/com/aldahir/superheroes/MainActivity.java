package com.aldahir.superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.aldahir.superheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String SUPER_HERO_NAME = "super_hero_name";
    public static final String ALTER_EGO_NAME = "alter_ego_name";
    public static final String BIO_DESCRIPTION = "bio_description";
    public static final String RATING = "rating";

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
            System.out.println("datos 2");
            System.out.println(superHeroName);
            openDetailActivity(superHeroName,alterEgoName, bioDescription, rating);
        });
    }

    private void openDetailActivity(String superHeroName, String alterEgoName, String bioDescription, float rating)
    {
        //un intent nos ayuda a enviar información de un activity a otro
        //ejemplo de un explicit intent
        System.out.println("Datos obtenidos");
        System.out.println(superHeroName);
        System.out.println(alterEgoName);
        System.out.println(bioDescription);
        System.out.println(rating);
        Intent intent = new Intent(this, DetailAcitivity.class);
        intent.putExtra(SUPER_HERO_NAME, superHeroName );
        intent.putExtra(ALTER_EGO_NAME, alterEgoName );
        intent.putExtra(BIO_DESCRIPTION, bioDescription );
        intent.putExtra(RATING, rating );
        startActivity(intent);
    }
}