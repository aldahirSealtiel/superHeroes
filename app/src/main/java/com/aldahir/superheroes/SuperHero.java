package com.aldahir.superheroes;

import android.os.Parcel;
import android.os.Parcelable;

// es necesario que se implemente parcelable para mandar el objeto en un intent, esto nos permite
//colocar el formato correcto para poder enviarse en el intent, se le conoce como serializar el objeto
class SuperHero implements Parcelable {
    private String superHeroName;
    private String alterEgoName;
    private String bioDescription;
    private float rating;

    public SuperHero()
    {
        this.superHeroName = "";
        this.alterEgoName = "";
        this.bioDescription = "";
        this.rating = 0;
    }
    public SuperHero(String heroName, String alterEgo, String bio, float rating)
    {
        this.superHeroName = heroName;
        this.alterEgoName = alterEgo;
        this.bioDescription = bio;
        this.rating = rating;
    }

    protected SuperHero(Parcel in) {
        superHeroName = in.readString();
        alterEgoName = in.readString();
        bioDescription = in.readString();
        rating = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(superHeroName);
        dest.writeString(alterEgoName);
        dest.writeString(bioDescription);
        dest.writeFloat(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SuperHero> CREATOR = new Creator<SuperHero>() {
        @Override
        public SuperHero createFromParcel(Parcel in) {
            return new SuperHero(in);
        }

        @Override
        public SuperHero[] newArray(int size) {
            return new SuperHero[size];
        }
    };

    public String getAlterEgoName() {
        return alterEgoName;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }


    public String getBioDescription() {
        return bioDescription;
    }

    public float getRating() {
        return rating;
    }
}
