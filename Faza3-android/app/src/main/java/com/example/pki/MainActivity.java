package com.example.pki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Korisnik> listaKorisnika = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        Obavestenje o = new Obavestenje("Vaš zahtev za kupovinu ulaznice za parove je prihvaćen.", "18.12.2022.", "16:32");

        Obavestenje o1 = new Obavestenje("Vaš zahtev za kupovinu individualne ulaznice je prihvaćen.", "12.01.2023.", "15:45");

        List<Obavestenje> listaObavestenja = new ArrayList<>();

        listaObavestenja.add(o);
        listaObavestenja.add(o1);

        Korisnik k = new Korisnik("Petar", "Peric", "pera", "Petar123.", "061-255-889", "Ruzveltova 14","pera@gmail.com"
        , "posetilac", listaObavestenja);

        Korisnik k1 = new Korisnik("Nikola", "Nikolic", "nikola", "Nikola123.", "061-266-323", "Knez Mihailova 10",
                "nikola@gmail.com", "posetilac", listaObavestenja);

        if(listaKorisnika.isEmpty()) {
            listaKorisnika.add(k);
            listaKorisnika.add(k1);
            saveData();
        }

    }

    public void prijava(View view) {
        Intent intent = new Intent(this, PrijavaActivity.class);
        startActivity(intent);
    }

    public void registracija(View view) {
        Intent intent = new Intent(this, RegistracijaActivity.class);
        startActivity(intent);
    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Korisnici", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(listaKorisnika);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("korisnici", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }

    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Korisnici", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("korisnici", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<Korisnik>>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        listaKorisnika = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (listaKorisnika == null) {
            // if the array list is empty
            // creating a new array list.
            listaKorisnika = new ArrayList<>();
        }
    }
}