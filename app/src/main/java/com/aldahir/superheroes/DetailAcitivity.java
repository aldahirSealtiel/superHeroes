package com.aldahir.superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
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
        SuperHero superHero = extras.getParcelable(MainActivity.SUPER_HERO_KEY);
        Bitmap imgBitmap = extras.getParcelable(MainActivity.BITMAP_KEY);
        if(imgBitmap != null)
        {
            bindingDetail.imageView2.setImageBitmap(imgBitmap);
        }
        bindingDetail.heroName.setText(superHero.getSuperHeroName());
        bindingDetail.alterEgoName.setText(superHero.getAlterEgoName());
        bindingDetail.bioDescriptionText.setText(superHero.getBioDescription());
        bindingDetail.ratingBar.setRating(superHero.getRating());
    }
}