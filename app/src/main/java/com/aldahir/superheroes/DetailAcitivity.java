package com.aldahir.superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.aldahir.superheroes.databinding.ActivityDetailAcitivityBinding;
import com.aldahir.superheroes.databinding.ActivityMainBinding;

public class DetailAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailAcitivityBinding bindingDetail = ActivityDetailAcitivityBinding.inflate(getLayoutInflater());
        setContentView(bindingDetail.getRoot());

        Intent mainActivityIntent = getIntent();

        Bundle extras = mainActivityIntent.getExtras();
        String superHeroName = extras.getString(MainActivity.SUPER_HERO_NAME);
        String alterEgoName = extras.getString(MainActivity.ALTER_EGO_NAME);
        String bioDesciption = extras.getString(MainActivity.BIO_DESCRIPTION);
        float rating = extras.getFloat(MainActivity.RATING);
        bindingDetail.heroName.setText(superHeroName);
        bindingDetail.alterEgoName.setText(alterEgoName);
        bindingDetail.bioDescriptionText.setText(bioDesciption);
        bindingDetail.ratingBar.setRating(rating);
    }
}