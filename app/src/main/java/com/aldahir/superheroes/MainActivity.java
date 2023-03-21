package com.aldahir.superheroes;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.aldahir.superheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String SUPER_HERO_KEY = "super_hero";
    //se creo esta variable para pasar la imagen a otra activity
    public static final String BITMAP_KEY = "bitmap";
    public Bitmap imgBitmap = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       /* usado para obtener una foto desde la galeria

        ActivityResultLauncher <String> aTakePhoto;
        aTakePhoto = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        binding.heroImage.setImageURI(result);
                    }
                });
        binding.heroImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aTakePhoto.launch("image/*");
            }
        });
        */
        //Se creo para tomar fotos y que se colocaran en el image View
        ActivityResultLauncher<Intent> camaraLauncher = registerForActivityResult(new
                        ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK)
                    {
                        Bundle extras = result.getData().getExtras();
                        imgBitmap = (Bitmap)extras.get("data");
                        binding.heroImage.setImageBitmap(imgBitmap);
                    }
                });

        binding.heroImage.setOnClickListener(v -> {
            camaraLauncher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
        });


        binding.saveButton.setOnClickListener(v -> {
            String superHeroName = binding.heroNameEdit.getText().toString();
            String alterEgoName = binding.alterNameEdit.getText().toString();
            String bioDescription = binding.bioEdit.getText().toString();
            float rating = binding.powerRating.getRating();

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
        intent.putExtra(BITMAP_KEY, imgBitmap);
        startActivity(intent);
    }
}