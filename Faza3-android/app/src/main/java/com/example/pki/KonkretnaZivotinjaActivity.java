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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class KonkretnaZivotinjaActivity extends AppCompatActivity {

   Zivotinja zivotinja;
    private ArrayList<Komentar> listaKomentara;
    private Korisnik ulogovan;
    private ArrayList<Zivotinja> listaZivotinja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konkretna_zivotinja);

        loadData();
        loadZivotinje();
        loadKorisnik();

        TextView txt = findViewById(R.id.textView1);
        txt.setText(zivotinja.getNaziv());

        TextView txt1 = findViewById(R.id.textView2);
        txt1.setText(zivotinja.getOpis());

        ImageView img = findViewById(R.id.imageView);
        img.setImageResource(zivotinja.getSlika());

        listaKomentara = zivotinja.getKomentari();

        KomentarAdapter numbersArrayAdapter = new KomentarAdapter(this, listaKomentara);

        // create the instance of the ListView to set the numbersViewAdapter
        ListView komentarListView = findViewById(R.id.listView);

        // set the numbersViewAdapter for ListView
        komentarListView.setAdapter(numbersArrayAdapter);

        Helper.getListViewSize(komentarListView);
    }

    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("konkretnaZivotinja", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("konkretna", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<Zivotinja>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        zivotinja = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (zivotinja == null) {
            // if the array list is empty
            // creating a new array list.
            zivotinja = new Zivotinja();
        }
    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("konkretnaZivotinja", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(zivotinja);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("konkretna", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }

    public void dodajKom(View view) {
        EditText editTxt = findViewById(R.id.edit);
        String komentar = editTxt.getText().toString();
        Komentar k = new Komentar(komentar, ulogovan.getKorIme());
        if(!komentar.equals("")) {
            zivotinja.komentari.add(k);
            for (int i = 0; i < listaZivotinja.size(); i++) {
                if(listaZivotinja.get(i).getNaziv().equals(zivotinja.getNaziv())) {
                    listaZivotinja.get(i).setKomentari(zivotinja.getKomentari());
                }
            }
            saveZivotinje();
            saveData();

            KomentarAdapter numbersArrayAdapter = new KomentarAdapter(this, listaKomentara);

            // create the instance of the ListView to set the numbersViewAdapter
            ListView komentarListView = findViewById(R.id.listView);

            // set the numbersViewAdapter for ListView
            komentarListView.setAdapter(numbersArrayAdapter);

            Helper.getListViewSize(komentarListView);

            EditText editTxt1 = findViewById(R.id.edit);
            editTxt1.setText("");
        }

    }

    private void loadKorisnik() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Ulogovan", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("ulogovan", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<Korisnik>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        ulogovan = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (ulogovan == null) {
            // if the array list is empty
            // creating a new array list.
            ulogovan = new Korisnik();
        }
    }

    private void saveZivotinje() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Zivotinje", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(listaZivotinja);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("zivotinje", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }

    private void loadZivotinje() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Zivotinje", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("zivotinje", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<Zivotinja>>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        listaZivotinja = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (listaZivotinja == null) {
            // if the array list is empty
            // creating a new array list.
            listaZivotinja= new ArrayList<>();
        }
    }

    public void dogadjajiKonkretna(View view) {
        Intent intent = new Intent(this, DogadjajiActivity.class);
        startActivity(intent);
    }

    public void obavestenjaKonkretna(View view) {
        Intent intent = new Intent(this, ObavestenjaActivity.class);
        startActivity(intent);
    }

    public void profilKonkretna(View view) {
        Intent intent = new Intent(this,ProfilActivity.class);
        startActivity(intent);
    }

    public void odjavaKonkretna(View view) {
        saveData();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void zivotinjeKonkretna(View view) {
        Intent intent = new Intent(this,ZivotinjeActivity.class);
        startActivity(intent);
    }

    public void paketiKonkretna(View view) {
        Intent intent = new Intent(this,PaketiActivity.class);
        startActivity(intent);
    }

    public void pocetnaKonkretna(View view) {
        Intent intent = new Intent(this,PocetnaActivity.class);
        startActivity(intent);
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