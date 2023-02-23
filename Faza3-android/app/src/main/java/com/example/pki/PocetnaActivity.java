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

import com.google.gson.Gson;

public class PocetnaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetna);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void dogadjajiPocetna(View view) {
        Intent intent = new Intent(this, DogadjajiActivity.class);
        startActivity(intent);
    }

    public void vidiSve(View view) {
        Intent intent = new Intent(this, ZivotinjeActivity.class);
        startActivity(intent);
    }

    public void obavestenjaPocetna(View view) {
        Intent intent = new Intent(this, ObavestenjaActivity.class);
        startActivity(intent);
    }

    public void profilPocetna(View view) {
        Intent intent = new Intent(this,ProfilActivity.class);
        startActivity(intent);
    }

    public void odjavaPocetna(View view) {
        saveData();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Ulogovan", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(null);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("ulogovan", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }

    public void zivotinjePocetna(View view) {
        Intent intent = new Intent(this,ZivotinjeActivity.class);
        startActivity(intent);
    }

    public void paketiPocetna(View view) {
        Intent intent = new Intent(this,PaketiActivity.class);
        startActivity(intent);
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