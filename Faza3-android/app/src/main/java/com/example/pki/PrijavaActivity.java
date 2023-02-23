package com.example.pki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrijavaActivity extends AppCompatActivity {

    private List<Korisnik> listaKorisnika = new ArrayList<>();
    private Korisnik korisnik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava);

        korisnik = new Korisnik();

        loadData();

    }

    public void registrujSe(View view) {
        Intent intent = new Intent(this, RegistracijaActivity.class);
        startActivity(intent);
    }

    public void prijaviSe(View view) {
        EditText korIme = findViewById(R.id.korIme);
        EditText lozinka = findViewById(R.id.lozinka);

        String por = "";
        TextView textView1 = findViewById(R.id.poruka);
        textView1.setText(por);

        if(korIme.getText().toString().equals("") && lozinka.getText().toString().equals("")) {
            String poruka = "Popunite sva polja!";
            TextView textView = findViewById(R.id.poruka);
            textView.setText(poruka);
        }
        else if (korIme.getText().toString().equals("")){
            String poruka = "Unesite korisničko ime!";
            TextView textView = findViewById(R.id.poruka);
            textView.setText(poruka);
        }
        else if(lozinka.getText().toString().equals("")) {
            String poruka = "Unesite lozinku!";
            TextView textView = findViewById(R.id.poruka);
            textView.setText(poruka);
        }
        else {
            Boolean postoji = false;
            for (int i = 0; i < listaKorisnika.size(); i++) {
                if(listaKorisnika.get(i).getKorIme().equals(korIme.getText().toString())) {
                    postoji = true;
                    korisnik.setIme(listaKorisnika.get(i).getIme());
                    korisnik.setPrezime(listaKorisnika.get(i).getPrezime());
                    korisnik.setKorIme(listaKorisnika.get(i).getKorIme());
                    korisnik.setLozinka(listaKorisnika.get(i).getLozinka());
                    korisnik.setAdresa(listaKorisnika.get(i).getAdresa());
                    korisnik.setEmail(listaKorisnika.get(i).getEmail());
                    korisnik.setTelefon(listaKorisnika.get(i).getTelefon());
                    korisnik.setTip(listaKorisnika.get(i).getTip());
                    korisnik.setObavestenja(listaKorisnika.get(i).getObavestenja());
                }
            }
            if(postoji) {
                if(lozinka.getText().toString().equals(korisnik.getLozinka())) {
                    saveData();
                    Intent intent = new Intent(this, PocetnaActivity.class);
                    startActivity(intent);
                }
                else {
                    String poruka = "Pogrešna lozinka!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
            }
            else {
                String poruka = "Ne postoji korisnik!";
                TextView textView = findViewById(R.id.poruka);
                textView.setText(poruka);
            }
        }
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
        String json = gson.toJson(korisnik);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("ulogovan", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }
}