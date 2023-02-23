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

public class KomentarAdapter extends ArrayAdapter<Komentar> {

    Korisnik ulogovan;

    public KomentarAdapter(@NonNull Context context, ArrayList<Komentar> arrayList) {
        super(context, 0, arrayList);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.komentari_list_view, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Komentar komentarPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.textView1);
        textView1.setText(komentarPosition.getKorIme());

        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(komentarPosition.getTekst());

        // then return the recyclable view
        return currentItemView;
    }

}
