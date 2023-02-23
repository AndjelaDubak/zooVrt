package com.example.pki;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DogadjajiAdapter extends ArrayAdapter<Dogadjaj> {

    Korisnik ulogovan;

    public DogadjajiAdapter(@NonNull Context context, ArrayList<Dogadjaj> arrayList) {
        super(context, 0, arrayList);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        loadData();
        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.dogadjaji_list_view, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Dogadjaj dogadjajPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView paketImage = currentItemView.findViewById(R.id.imageView);
        assert dogadjajPosition != null;
        paketImage.setImageResource(dogadjajPosition.getSlika());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.textView1);
        textView1.setText(dogadjajPosition.getNaziv());

        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(dogadjajPosition.getOpis());

        TextView textView3 = currentItemView.findViewById(R.id.textView3);
        textView3.setText(String.valueOf(dogadjajPosition.getBrLajkova()));

        ImageView dogImage = currentItemView.findViewById(R.id.imageView1);
        assert dogadjajPosition != null;
        boolean jeste = false;
        for (int i = 0; i < dogadjajPosition.getLajkovali().size(); i++) {
            if(dogadjajPosition.getLajkovali().get(i).equals(ulogovan.getKorIme())) {
                jeste = true;
            }
        }

        if(jeste == true) {
            dogImage.setImageResource(R.drawable.lajk1);
        }
        else {
            dogImage.setImageResource(R.drawable.lajk);
        }

        // then return the recyclable view
        return currentItemView;
    }

    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Ulogovan", Context.MODE_PRIVATE);

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

}
