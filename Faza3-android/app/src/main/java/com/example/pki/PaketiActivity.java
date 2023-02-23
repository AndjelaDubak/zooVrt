package com.example.pki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PaketiActivity extends AppCompatActivity {

    private ArrayList<Paket> listaPaketa = new ArrayList<>();
    private Paket paket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paketi);

        Paket p = new Paket("Individualna ili obična grupna poseta","Ugrabite svoj dan i " +
                "posetite zoo vrt Pandica, jedno od dobrih mesta za fizičku rekreaciju i mentalno opuštanje," +
                " u samom centru grada.","550", R.drawable.individualna);

        Paket p1 = new Paket("Za parove","Upoznajte bolje svog partnera uz zoo vrt Pandica." +
                " Ovo je idealni trenutak da sa voljenom osobom uživate na otvorenom okruženi prirodnim " +
                "ambijentom i zanimljivim životinjama.","500", R.drawable.parovi);

        Paket p2 = new Paket("Porodični paket","Zoo vrt Pandica je definitivno mesto gde se cela " +
                "porodica druži i zajedničkim osmehom prati sve trenutke i vratolomije naših životinja.","400", R.drawable.porodicni);

        Paket p3 = new Paket("Paket za kompanije","Od korporativnih proslava i prigodnih koktela, preko sastanaka i tim bildiniga – " +
                "unesite dodir prirode i divljine u svoj naredni koroporativni događaj koji će se prepričavati.","450", R.drawable.kompanija);

        loadData();

        if(listaPaketa.isEmpty()) {
            listaPaketa.add(p);
            listaPaketa.add(p1);
            listaPaketa.add(p2);
            listaPaketa.add(p3);
            saveData();
        }

        PaketAdapter numbersArrayAdapter = new PaketAdapter(this, listaPaketa);

        // create the instance of the ListView to set the numbersViewAdapter
        ListView paketiListView = findViewById(R.id.listView);

        // set the numbersViewAdapter for ListView
        paketiListView.setAdapter(numbersArrayAdapter);

        paketiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("KLIKKKKKKKKKKKKKKKK");
                paket = listaPaketa.get(i);
                savePaket();
                Intent intent = new Intent(getApplicationContext(), KupiPaketActivity.class);
                startActivity(intent);
            }
        });

    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Paketi", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(listaPaketa);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("paketi", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }

    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Paketi", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("paketi", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<Paket>>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        listaPaketa = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (listaPaketa == null) {
            // if the array list is empty
            // creating a new array list.
            listaPaketa = new ArrayList<>();
        }
    }

    public void dogadjajiPaketi(View view) {
        Intent intent = new Intent(this, DogadjajiActivity.class);
        startActivity(intent);
    }

    public void obavestenjaPaketi(View view) {
        Intent intent = new Intent(this, ObavestenjaActivity.class);
        startActivity(intent);
    }

    public void profilPaketi(View view) {
        Intent intent = new Intent(this,ProfilActivity.class);
        startActivity(intent);
    }

    public void odjavaPaketi(View view) {
        saveData();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void zivotinjePaketi(View view) {
        Intent intent = new Intent(this,ZivotinjeActivity.class);
        startActivity(intent);
    }

    public void paketiPaketi(View view) {
        Intent intent = new Intent(this,PaketiActivity.class);
        startActivity(intent);
    }

    public void pocetnaPaketi(View view) {
        Intent intent = new Intent(this,PocetnaActivity.class);
        startActivity(intent);
    }

    private void savePaket() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("konkretanPaket", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(paket);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("paket", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.obavestenja:
                Intent intent = new Intent(this, ObavestenjaActivity.class);
                startActivity(intent);
                return true;
            case R.id.profil:
                Intent intent1 = new Intent(this, ProfilActivity.class);
                startActivity(intent1);
                return true;
            case R.id.pocetna:
                Intent intent2 = new Intent(this, PocetnaActivity.class);
                startActivity(intent2);
                return true;
            case R.id.zivotinje:
                Intent intent3 = new Intent(this,ZivotinjeActivity.class);
                startActivity(intent3);
                return true;
            case R.id.paketi:
                Intent intent4 = new Intent(this, PaketiActivity.class);
                startActivity(intent4);
                return true;
            case R.id.dogadjaji:
                Intent intent5 = new Intent(this, DogadjajiActivity.class);
                startActivity(intent5);
                return true;
            case R.id.odjava:
                Intent intent6 = new Intent(this, MainActivity.class);
                startActivity(intent6);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}