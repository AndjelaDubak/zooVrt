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
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ProfilActivity extends AppCompatActivity {

    private Korisnik ulogovan;
    private List<Korisnik> listaKorisnika= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        loadData();
        loadKorisnike();

        EditText ime = findViewById(R.id.ime);
        EditText prezime = findViewById(R.id.prezime);
        EditText korIme = findViewById(R.id.korIme);
        EditText telefon = findViewById(R.id.telefon);
        EditText adresa = findViewById(R.id.adresa);
        EditText email = findViewById(R.id.email);

        ime.setText(ulogovan.getIme());
        prezime.setText(ulogovan.getPrezime());
        korIme.setText(ulogovan.getKorIme());
        telefon.setText(ulogovan.getTelefon());
        adresa.setText(ulogovan.getAdresa());
        email.setText(ulogovan.getEmail());
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
        String json = gson.toJson(ulogovan);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("ulogovan", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }


    public void izmeniInformacije(View view) {

        String text2 = "";
        TextView textView2 = findViewById(R.id.text);
        textView2.setText(text2);

        EditText ime = findViewById(R.id.ime);
        EditText prezime = findViewById(R.id.prezime);
        EditText korIme = findViewById(R.id.korIme);
        EditText telefon = findViewById(R.id.telefon);
        EditText adresa = findViewById(R.id.adresa);
        EditText email = findViewById(R.id.email);

        String por = "";
        TextView textView1 = findViewById(R.id.poruka);
        textView1.setText(por);

        if(ime.getText().toString().equals(ulogovan.getIme()) && prezime.getText().toString().equals(ulogovan.getPrezime()) &&
                korIme.getText().toString().equals(ulogovan.getKorIme()) && telefon.getText().toString().equals(ulogovan.getTelefon()) &&
                adresa.getText().toString().equals(ulogovan.getAdresa()) && email.getText().toString().equals(ulogovan.getEmail())) {
            String poruka = "Nijedna informacija nije izmenjena!";
            TextView textView = findViewById(R.id.poruka);
            textView.setText(poruka);
        }
        else {
            boolean zauzeto = false;
            for (int i = 0; i < listaKorisnika.size(); i++) {
                if(!korIme.getText().toString().equals(ulogovan.getKorIme())) {
                    if (listaKorisnika.get(i).getKorIme().equals(korIme.getText().toString())) {
                        zauzeto = true;
                        String poruka = "Korisničko ime zazueto!";
                        TextView textView = findViewById(R.id.poruka);
                        textView.setText(poruka);
                    }
                }
            }
            if(zauzeto == false) {
                if(ime.getText().toString().length() < 3 && !ime.getText().toString().equals("")) {
                    String poruka = "Ime mora sadržati bar 3 slova!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(prezime.getText().toString().length() < 3 && !prezime.getText().toString().equals("")) {
                    String poruka = "Prezime mora sadržati bar 3 slova!";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else if(!Pattern.compile("^\\d\\d\\d-\\d\\d\\d-\\d{3,4}$").matcher(telefon.getText().toString()).matches() && !telefon.getText().toString().equals("")) {
                    String poruka = "Unesite telefon u formatu: xxx-xxx-xxx(x)";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);

                }
                else if(adresa.getText().toString().length() < 3 && !adresa.getText().toString().equals("")) {
                    String poruka = "Adresa mora imati bar 3 slova";
                    TextView textView = findViewById(R.id.poruka);
                    textView.setText(poruka);
                }
                else {
                    String staroKorIme = ulogovan.getKorIme();
                    if(!ime.getText().toString().equals("")) {
                        ulogovan.setIme(ime.getText().toString());
                    }
                    if(!prezime.getText().toString().equals("")) {
                        ulogovan.setPrezime(prezime.getText().toString());
                    }
                    if(!korIme.getText().toString().equals("")) {
                        ulogovan.setKorIme(korIme.getText().toString());
                    }
                    if(!telefon.getText().toString().equals("")) {
                        ulogovan.setTelefon(telefon.getText().toString());
                    }
                    if(!email.getText().toString().equals("")) {
                        ulogovan.setEmail(email.getText().toString());
                    }
                    if(!adresa.getText().toString().equals("")) {
                        ulogovan.setAdresa(adresa.getText().toString());
                    }

                    for (int i = 0; i < listaKorisnika.size(); i++) {
                        if(listaKorisnika.get(i).getKorIme().equals(staroKorIme)) {
                            listaKorisnika.get(i).setIme(ulogovan.getIme());
                            listaKorisnika.get(i).setPrezime(ulogovan.getPrezime());
                            listaKorisnika.get(i).setKorIme(ulogovan.getKorIme());
                            listaKorisnika.get(i).setAdresa(ulogovan.getAdresa());
                            listaKorisnika.get(i).setEmail(ulogovan.getEmail());
                            listaKorisnika.get(i).setTelefon(ulogovan.getTelefon());
                        }
                    }

                    saveData();
                    saveKorisnici();

                    String text = "Informacije uspešno izmenjene.";
                    TextView textView = findViewById(R.id.text);
                    textView.setText(text);

                }
            }
        }
    }



    private void loadKorisnike() {
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

    private void saveKorisnici() {
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

    public void izmeniLozinku(View view) {
        String txt = "";
        TextView txtView = findViewById(R.id.lozinkaIzmenjena);
        txtView.setText(txt);

        String por = "";
        TextView textView1 = findViewById(R.id.poruka1);
        textView1.setText(por);

        EditText staraLoz = findViewById(R.id.staraLoz);
        EditText novaLoz = findViewById(R.id.novaLoz);
        EditText potvrdaLoz = findViewById(R.id.potvrdaLoz);

        if(staraLoz.getText().toString().equals("")) {
            String poruka = "Unesite staru lozinku!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(!staraLoz.getText().toString().equals(ulogovan.getLozinka())) {
            String poruka = "Stara lozinka pogrešna!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(novaLoz.getText().toString().equals("")) {
            String poruka = "Unesite novu lozinku!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(novaLoz.getText().toString().length() < 8) {
            String poruka = "Lozinka mora sadržati bar 8 karaktera!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(!Pattern.compile("[a-zA-Z]").matcher(novaLoz.getText().toString()).lookingAt()) {
            String poruka = "Lozinka mora počinjati slovom!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(!Pattern.compile("[A-Z]+").matcher(novaLoz.getText().toString()).find()) {
            String poruka = "Lozinka mora sadržati bar 1 veliko slovo!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(!Pattern.compile("[\\d{+}]").matcher(novaLoz.getText().toString()).find()) {
            String poruka = "Lozinka mora sadržati bar 1 broj!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(!Pattern.compile("[^a-zA-Z\\d]").matcher(novaLoz.getText().toString()).find()) {
            String poruka = "Lozinka mora sadržati bar 1 specijalan karakter!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(potvrdaLoz.getText().toString().equals("")) {
            String poruka = "Unesite potvrdu lozinke!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else if(!potvrdaLoz.getText().toString().equals(novaLoz.getText().toString())) {
            String poruka = "Pogrešna potvrda lozinke!";
            TextView textView = findViewById(R.id.poruka1);
            textView.setText(poruka);
        }
        else {
            ulogovan.setLozinka(novaLoz.getText().toString());
            for (int i = 0; i < listaKorisnika.size(); i++) {
                if(listaKorisnika.get(i).getKorIme().equals(ulogovan.getKorIme())) {
                    listaKorisnika.get(i).setLozinka(ulogovan.getLozinka());
                }
            }

            saveData();
            saveKorisnici();

            String text = "Lozinka uspešno promenjena.";
            TextView textView = findViewById(R.id.lozinkaIzmenjena);
            textView.setText(text);
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