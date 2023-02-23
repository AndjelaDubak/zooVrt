package com.example.pki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RegistracijaActivity extends AppCompatActivity {

    private List<Korisnik> listaKorisnika = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);

        loadData();
    }

    public void regSe(View view) {

        String txt = "";
        TextView txtView = findViewById(R.id.text);
        txtView.setText(txt);

        String txt1 = "";
        TextView txtView2 = findViewById(R.id.text1);
        txtView2.setText(txt1);

        EditText ime = findViewById(R.id.ime);
        EditText prezime = findViewById(R.id.prezime);
        EditText korIme = findViewById(R.id.korIme);
        EditText telefon = findViewById(R.id.telefon);
        EditText adresa = findViewById(R.id.adresa);
        EditText email = findViewById(R.id.email);
        EditText lozinka = findViewById(R.id.lozinka);
        EditText potvrdaLoz = findViewById(R.id.potvrdaLoz);

        String por = "";
        TextView textView1 = findViewById(R.id.poruka);
        textView1.setText(por);

        if(ime.getText().toString().equals("") || prezime.getText().toString().equals("") ||
            korIme.getText().toString().equals("") || telefon.getText().toString().equals("") ||
            adresa.getText().toString().equals("") || email.getText().toString().equals("") ||
            lozinka.getText().toString().equals("")) {
            String poruka = "Popunite sva polja!";
            TextView textView = findViewById(R.id.poruka);
            textView.setText(poruka);
        }
        else {
            boolean zauzeto = false;
            for (int i = 0; i < listaKorisnika.size(); i++) {
                if(listaKorisnika.get(i).getKorIme().equals(korIme.getText().toString())) {
                    zauzeto = true;
                    String poruka = "Korisničko ime zazueto!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
            }
            if(zauzeto == false) {
                if(ime.getText().toString().length() < 3) {
                    String poruka = "Ime mora sadržati bar 3 slova!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(prezime.getText().toString().length() < 3) {
                    String poruka = "Prezime mora sadržati bar 3 slova!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(!Pattern.compile("^\\d\\d\\d-\\d\\d\\d-\\d{3,4}$").matcher(telefon.getText().toString()).matches()) {
                    String poruka = "Unesite telefon u formatu: xxx-xxx-xxx(x)";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);

                }
                else if(adresa.getText().toString().length() < 3) {
                    String poruka = "Adresa mora imati bar 3 slova";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(lozinka.getText().toString().length() < 8) {
                    String poruka = "Lozinka mora sadržati bar 8 karaktera!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(!Pattern.compile("[a-zA-Z]").matcher(lozinka.getText().toString()).lookingAt()) {
                    String poruka = "Lozinka mora počinjati slovom!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(!Pattern.compile("[A-Z]+").matcher(lozinka.getText().toString()).find()) {
                    String poruka = "Lozinka mora sadržati bar 1 veliko slovo!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(!Pattern.compile("[\\d{+}]").matcher(lozinka.getText().toString()).find()) {
                    String poruka = "Lozinka mora sadržati bar 1 broj!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(!Pattern.compile("[^a-zA-Z\\d]").matcher(lozinka.getText().toString()).find()) {
                    String poruka = "Lozinka mora sadržati bar 1 specijalan karakter!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(potvrdaLoz.getText().toString().equals("")) {
                    String poruka = "Unesite potvrdu lozinke!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(!potvrdaLoz.getText().toString().equals(lozinka.getText().toString())) {
                    String poruka = "Pogrešna potvrda lozinke!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else {
                    Korisnik k = new Korisnik(ime.getText().toString(), prezime.getText().toString(), korIme.getText().toString(),
                            lozinka.getText().toString(), telefon.getText().toString(), adresa.getText().toString(),
                            email.getText().toString(), "posetilac",null);

                    listaKorisnika.add(k);
                    saveData();

                    String text = "Registracija uspešna.";
                    TextView textView = findViewById(R.id.text);
                    textView.setText(text);

                    String text1 = "Prijavite se OVDE.";
                    TextView textView2 = findViewById(R.id.text1);
                    textView2.setText(text1);
                }
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


    public void prij(View view) {
        Intent intent = new Intent(this, PrijavaActivity.class);
        startActivity(intent);
    }



}