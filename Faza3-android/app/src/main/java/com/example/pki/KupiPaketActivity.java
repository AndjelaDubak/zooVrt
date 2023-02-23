package com.example.pki;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class KupiPaketActivity extends AppCompatActivity {

    private Paket paket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kupi_paket);

        loadData();

        TextView txt = findViewById(R.id.tip);
        txt.setText(paket.getNaziv());

        TextView tv = findViewById(R.id.poruka);
        tv.setText("");

    }

    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("konkretanPaket", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("paket", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<Paket>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        paket = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (paket == null) {
            // if the array list is empty
            // creating a new array list.
            paket = new Paket();
        }
    }

    @SuppressLint("ResourceAsColor")
    public void kupi(View view) {
        TextView tv1 = findViewById(R.id.poruka);
        tv1.setText("");
        EditText et = findViewById(R.id.brLjudi);
        if(et.getText().toString().equals("")) {
            TextView tv = findViewById(R.id.poruka);
            tv.setText("Unesite broj ljudi!");
        }
        else {
            int brLjudi = Integer.parseInt(et.getText().toString());
            if(brLjudi>10) {
                TextView tv = findViewById(R.id.poruka);
                tv.setText("Maksimalan broj ljudi je 10!");
            }
            else {
                TextView tv = findViewById(R.id.poruka);
                tv.setText("Vaša kupovina je evidentirana.");
                tv.setTextColor(R.color.black);
            }
        }

    }

    public void prikaziCenu(View view) {
        TextView tv1 = findViewById(R.id.poruka);
        tv1.setText("");
        EditText et = findViewById(R.id.brLjudi);
        String br = et.getText().toString();
        if(br.equals("")) {
            TextView tv = findViewById(R.id.poruka);
            tv.setText("Unesite broj ljudi!");
        }
        else {
            int brLjudi = Integer.parseInt(br);
            if(brLjudi>10) {
                TextView tv = findViewById(R.id.poruka);
                tv.setText("Maksimalan broj ljudi je 10!");
            }
            else {
                int cena = brLjudi * Integer.parseInt(paket.getCena());
                EditText edt = findViewById(R.id.promoKod);
                if(!edt.getText().toString().equals("")) {
                    cena = cena * 90/100 ;
                }
                TextView txt = findViewById(R.id.cena);
                txt.setText(cena + " din");
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}