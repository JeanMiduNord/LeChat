package com.m2i.toutdouxliste;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Formation on 11/01/2018.
 */

public class TacheArrayAdapter extends ArrayAdapter {
    private Activity context;
    private List<Tache> data;
    private LayoutInflater inflater;


    public TacheArrayAdapter(@NonNull Context context, @NonNull List<Tache> data) {
        super(context, 0, data);
        this.data = data;
        this.context = (Activity) context;
        this.inflater = this.context.getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Instanciation de la vue
         View view = this.inflater.inflate(R.layout.list_view_tache,parent,false);

        //récupération des données

        Tache  tacheData  = this.data.get(position);
        // Liaison entre les données et la Vue
        TextView tacheTextView = view.findViewById(R.id.listTextViewTache);
        tacheTextView.setText(tacheData.getTache());

        CheckBox checkBoxDone = view.findViewById(R.id.checkBoxDone);
        checkBoxDone.setChecked(tacheData.getDone()==1);

        checkBoxDone.setTag(position);

        return view;
    }

}
