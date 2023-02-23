package com.example.pki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PaketAdapter extends ArrayAdapter<Paket> {

    public PaketAdapter(@NonNull Context context, ArrayList<Paket> arrayList) {
        super(context, 0, arrayList);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.paketi_list_view, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Paket paketPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView paketImage = currentItemView.findViewById(R.id.imageView);
        assert paketPosition != null;
        paketImage.setImageResource(paketPosition.getSlika());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.textView1);
        textView1.setText(paketPosition.getNaziv());

        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(paketPosition.getOpis());


        // then return the recyclable view
        return currentItemView;
    }

}
