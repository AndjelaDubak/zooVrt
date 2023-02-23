package com.example.pki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ObavestenjaActivity extends AppCompatActivity {

    Korisnik ulogovan;
    List<String> obavestenja = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obavestenja);

        loadData();

        if(ulogovan.getObavestenja() != null) {
            for (int i = 0; i < ulogovan.getObavestenja().size(); i++) {
                obavestenja.add(ulogovan.getObavestenja().get(i).getOpis() + "\n" + ulogovan.getObavestenja().get(i).getVreme() + " " + ulogovan.getObavestenja().get(i).getDatum());
            }

            ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_item, obavestenja);
            ListView lv = findViewById(R.id.listView);
            lv.setAdapter(adapter);
        }
        else {
            TextView tv = findViewById(R.id.nema);
            tv.setText("Nema novih obaveštenja.");
        }

    }

    private void loadData() {
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