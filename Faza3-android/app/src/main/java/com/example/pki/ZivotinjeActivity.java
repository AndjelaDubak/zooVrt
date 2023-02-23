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
import java.util.List;

public class ZivotinjeActivity extends AppCompatActivity {

    private ArrayList<Zivotinja> listaZivotinja = new ArrayList<>();
    private Zivotinja zivotinja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zivotinje);

        ArrayList<Komentar> kom = new ArrayList<>();
        Komentar k1 = new Komentar("Opasna životinja", "marko");
        Komentar k2 = new Komentar("Beautiful!", "nikola");
        kom.add(k1);
        kom.add(k2);

        Zivotinja z = new Zivotinja("Tigar","Tigar je sisar iz porodice mačaka i jedan od " +
                "četiri vrste „velikih mačaka“ roda pantera. On je vrhunski predator i najveća živa" +
                " mačka na svetu. U brojnim istorijskim mitovima istočnjačkih zemalja tigar je kralj svih zveri. " +
                "Bengalski tigar je najpoznatija podvrsta i sačinjava približno 80% ukupne populacije tigrova.", R.drawable.tigar,kom);

        ArrayList<Komentar> kom1 = new ArrayList<>();
        Komentar k3 = new Komentar("Preslatki su!", "marko");
        kom1.add(k3);

        Zivotinja z1 = new Zivotinja("Merkat","Merkat je vrsta malih sisara iz reda zveri i " +
                "porodice mungosa. Ova vrsta je jedini živi član roda Suricata. Merkati žive u svim " +
                "delovima pustinje Kalahari u Bocvani, u većem delu Namibijske pustinje u Namibiji i u" +
                " jugozapadnim delovima Angole, kao i u Južnoj Africi. Žive u grupama koje se nazivaju klanovi.", R.drawable.merkat,kom1);


        ArrayList<Komentar> kom2 = new ArrayList<>();
        Komentar k4 = new Komentar("Iako su lukave, slatke su.", "petar");
        kom2.add(k4);

        Zivotinja z2 = new Zivotinja("Lisica","Riđa lisica je najpoznatija od svih vrsta lisica. " +
                "Takođe je najrasprostranjenija ne samo vrsta lisica, već i od svih ostalih kopnenih mesojeda. " +
                "Kao što ime govori, njeno krzno je najčešće riđo-braon boje. Postoji oko 40 podvrsta.", R.drawable.lija,kom2);

        ArrayList<Komentar> kom3 = new ArrayList<>();
        Komentar k5 = new Komentar("Divni su.", "mia");
        kom3.add(k5);

        Zivotinja z3 = new Zivotinja("Majmun","Majmun je naziv za pojedine životinjske vrste iz sisarskog" +
                " reda primata. Red primata možemo deliti na dve grupe: u prvu grupu bi se mogli ubrajati svi polumajmuni, " +
                "a u drugu pravi majmuni, čovekoliki majmuni i ljudi.", R.drawable.majmuni,kom3);

        ArrayList<Komentar> kom4 = new ArrayList<>();
        Komentar k6 = new Komentar("Njihova surla je zanimljiva.", "marija");
        kom4.add(k6);

        Zivotinja z4 = new Zivotinja("Slon","Slonovi su velike životinje iz familije Elephantidae" +
                " iz reda Proboscidea. Tri vrste su trenutno priznate: afrički slon, afrički šumski slon, i " +
                "azijski slon. Stanište slonova se prostire širom podsaharijske Afrike, južne Azije, i jugoistočne Azije.", R.drawable.slon,kom4);

        ArrayList<Komentar> kom5 = new ArrayList<>();
        Komentar k7 = new Komentar("Zebra print je najbolji!", "milos");
        kom5.add(k7);

        Zivotinja z5 = new Zivotinja("Zebra","Zebra je životinja koja pripada porodici Equidae " +
                "(porodici konja) i koja živi u centralnoj i južnoj Africi. Zebra živi u manjim krdima u savani. " +
                "Jedna porodica se obično sastoji od pastuva, nekoliko kobila i njihovih ždrebadi. Grupa porodica čini krdo. " +
                "Danju pase travu i odmara se u senci nekog drveta.", R.drawable.zebra,kom5);


        ArrayList<Komentar> kom6 = new ArrayList<>();
        Komentar k8 = new Komentar("Lav je kralj životinja.", "milos");
        Komentar k9 = new Komentar("Volim mačke, kao i lava.", "andjela");
        kom6.add(k8);
        kom6.add(k9);

        Zivotinja z6 = new Zivotinja("Lav","Lav je veliki sisar iz porodice mačaka i jedna od " +
                "„velikih mačaka“ roda pantera. Mužjak lava, lako prepoznatljiv po svojoj grivi, u proseku teži" +
                " između 180-255 kilograma. Ženke su manje i teže od 110-155 kilograma.", R.drawable.lav,kom6);

        ArrayList<Komentar> kom7 = new ArrayList<>();
        Komentar k10 = new Komentar("Najsladji su.", "andjela");
        kom7.add(k10);

        Zivotinja z7 = new Zivotinja("Pingvin","Pingvini su monotipični red vodenih, neletećih ptica," +
                " koje žive uglavnom na južnoj hemisferi. Jedini član reda je istoimena porodica Spheniscidae, " +
                "koja obuhvata šest rodova sa 17 ili 20 vrsta, u zavisnosti od autora.", R.drawable.pingvin,kom7);

        ArrayList<Komentar> kom8 = new ArrayList<>();
        Komentar k11 = new Komentar("Ovo je ugrožena vrsta.", "mira");
        kom8.add(k11);

        Zivotinja z8 = new Zivotinja("Koala","Koala je australijski torbarski biljojed i jedini živi predstavnik " +
                "istoimene porodice Phascolarctidae. Naseljava obalska područja istočne i južne Australije, od okoline Adelejda " +
                "do južnih delova rta Jork.", R.drawable.koala,kom8);

        ArrayList<Komentar> kom9 = new ArrayList<>();
        Komentar k12 = new Komentar("Foke su nekada živele na kopnu.", "nikola");
        kom9.add(k12);

        Zivotinja z9 = new Zivotinja("Foka","Foka ili prava foka je rod perajara koji pripada porodici pravih foka. " +
                "Takođe, foka je naziv za nekoliko drugih rodova i vrsta vodenih sisara iz grupe perajara, koji spadaju u porodice: " +
                "pravih foka i ušatih foka. ", R.drawable.foka,kom9);

        loadData();

        if(listaZivotinja.isEmpty()) {
            listaZivotinja.add(z);
            listaZivotinja.add(z1);
            listaZivotinja.add(z2);
            listaZivotinja.add(z3);
            listaZivotinja.add(z4);
            listaZivotinja.add(z5);
            listaZivotinja.add(z6);
            listaZivotinja.add(z7);
            listaZivotinja.add(z8);
            listaZivotinja.add(z9);
            saveData();
        }

        ZivotinjeAdapter numbersArrayAdapter = new ZivotinjeAdapter(this, listaZivotinja);

        // create the instance of the ListView to set the numbersViewAdapter
        ListView zivotinjeListView = findViewById(R.id.listView);

        // set the numbersViewAdapter for ListView
        zivotinjeListView.setAdapter(numbersArrayAdapter);

        zivotinjeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                zivotinja = listaZivotinja.get(i);
                saveZivotinju();
                Intent intent = new Intent(getApplicationContext(), KonkretnaZivotinjaActivity.class);
                startActivity(intent);
            }
        });

    }

    private void saveData() {
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

    private void loadData() {
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

    public void dogadjajiZivotinje(View view) {
        Intent intent = new Intent(this, DogadjajiActivity.class);
        startActivity(intent);
    }

    public void obavestenjaZivotinje(View view) {
        Intent intent = new Intent(this, ObavestenjaActivity.class);
        startActivity(intent);
    }

    public void profilZivotinje(View view) {
        Intent intent = new Intent(this,ProfilActivity.class);
        startActivity(intent);
    }

    public void odjavaZivotinje(View view) {
        saveData();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void zivotinjeZivotinje(View view) {
        Intent intent = new Intent(this,ZivotinjeActivity.class);
        startActivity(intent);
    }

    public void paketiZivotinje(View view) {
        Intent intent = new Intent(this,PaketiActivity.class);
        startActivity(intent);
    }

    public void pocetnaZivotinje(View view) {
        Intent intent = new Intent(this,PocetnaActivity.class);
        startActivity(intent);
    }

    private void saveZivotinju() {
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