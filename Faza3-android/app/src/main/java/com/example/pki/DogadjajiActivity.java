package com.example.pki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DogadjajiActivity extends AppCompatActivity {

    private ArrayList<Dogadjaj> listaDogadjaja = new ArrayList<>();
    Korisnik ulogovan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogadjaji);

        loadKorisnik();

        ArrayList<String> l = new ArrayList<>();
        l.add("pera");
        Dogadjaj d = new Dogadjaj("Nova godina u zoo vrtu Pandica", "Ove godine organizujemo" +
                " proslavu Nove godine. Dođi i zabavi se sa nama.", 10, R.drawable.nova,  l);

        ArrayList<String> l1 = new ArrayList<>();
        l1.add("");
        Dogadjaj d1 = new Dogadjaj("Dan žena u zoo vrtu Pandica", "Svim damama poklanjamo " +
                "besplatan ulaz u zoo Pandica!", 15, R.drawable.lale,  l1);

        ArrayList<String> l2 = new ArrayList<>();
        l2.add("pera");
        l2.add("nikola");
        Dogadjaj d2 = new Dogadjaj("Druženje sa kengurima", "Kengur, čovekov najbolji prijatelj! " +
                "Dođi i ti da se družiš sa kengurima.", 13, R.drawable.kenguri,  l2);

        ArrayList<String> l3 = new ArrayList<>();
        l3.add("");
        Dogadjaj d3 = new Dogadjaj("Seminar", "Organizovan je seminar o dobrobiti životinja." +
                " Program traje od 24.01.2023. do 28.01.2023.", 9, R.drawable.seminar,  l3);

        ArrayList<String> l4 = new ArrayList<>();
        l4.add("");
        Dogadjaj d4 = new Dogadjaj("Zajedno hranimo foke", "Dođite da zajedno hranimo" +
                " zanimljive foke!", 4, R.drawable.hrana,  l4);

        loadData();

       if(listaDogadjaja.isEmpty()) {
            listaDogadjaja.add(d);
            listaDogadjaja.add(d1);
            listaDogadjaja.add(d2);
            listaDogadjaja.add(d3);
            listaDogadjaja.add(d4);
            saveData();
        }

        DogadjajiAdapter numbersArrayAdapter = new DogadjajiAdapter(this, listaDogadjaja);

        // create the instance of the ListView to set the numbersViewAdapter
        ListView paketiListView = findViewById(R.id.listView);

        // set the numbersViewAdapter for ListView
        paketiListView.setAdapter(numbersArrayAdapter);


        paketiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dogadjaj dogadjaj = listaDogadjaja.get(i);
                boolean jeste = false;
                int index = 0;
                for (int j = 0; j < dogadjaj.getLajkovali().size(); j++) {
                    if(dogadjaj.getLajkovali().get(j).equals(ulogovan.getKorIme())) {
                        jeste = true;
                        index = j;
                    }
                }

                if(jeste == true) {
                    ArrayList<String> lajkovi = dogadjaj.getLajkovali();
                    lajkovi.remove(index);
                    dogadjaj.setLajkovali(lajkovi);
                    dogadjaj.setBrLajkova(dogadjaj.getBrLajkova()-1);
                }
                else {
                    ArrayList<String> lajkovi = dogadjaj.getLajkovali();
                    lajkovi.add(ulogovan.getKorIme());
                    dogadjaj.setLajkovali(lajkovi);
                    dogadjaj.setBrLajkova(dogadjaj.getBrLajkova()+1);
                }

                listaDogadjaja.get(i).setBrLajkova(dogadjaj.getBrLajkova());
                listaDogadjaja.get(i).setLajkovali(dogadjaj.getLajkovali());
                saveData();

                numbersArrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Dogadjaji", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(listaDogadjaja);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("dogadjaji", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }

    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("Dogadjaji", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("dogadjaji", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<Dogadjaj>>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        listaDogadjaja = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (listaDogadjaja == null) {
            // if the array list is empty
            // creating a new array list.
            listaDogadjaja = new ArrayList<>();
        }
    }

    public void dogadjajiDogadjaji(View view) {
        Intent intent = new Intent(this, DogadjajiActivity.class);
        startActivity(intent);
    }

    public void obavestenjaDogadjaji(View view) {
        Intent intent = new Intent(this, ObavestenjaActivity.class);
        startActivity(intent);
    }

    public void profilDogadjaji(View view) {
        Intent intent = new Intent(this,ProfilActivity.class);
        startActivity(intent);
    }

    public void odjavaDogadjaji(View view) {
        saveData();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void zivotinjeDogadjaji(View view) {
        Intent intent = new Intent(this,ZivotinjeActivity.class);
        startActivity(intent);
    }

    public void paketiDogadjaji(View view) {
        Intent intent = new Intent(this,PaketiActivity.class);
        startActivity(intent);
    }

    public void pocetnaDogadjaji(View view) {
        Intent intent = new Intent(this,PocetnaActivity.class);
        startActivity(intent);
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