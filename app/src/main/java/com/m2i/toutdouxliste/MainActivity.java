package com.m2i.toutdouxliste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.m2i.database.DatabaseHandler;
import com.m2i.database.TacheDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{
    private Spinner spSelectEtat;
    private final String[] CONTENU_SPINNER = {"","En cours", "Inactif", "Les deux"};
    private ListView tacheListView;
    private List<Tache> tacheList;
    private TacheDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spSelectEtat = (Spinner) findViewById(R.id.spSelectEtat);
        spSelectEtat.setOnItemSelectedListener(this);
        tacheListView = findViewById(R.id.tacheListView);

        dao = new TacheDAO(new DatabaseHandler(this));

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,CONTENU_SPINNER);

        spSelectEtat.setAdapter(aa);

        tacheListInit();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (CONTENU_SPINNER[i] != "") {
            Toast.makeText(this, CONTENU_SPINNER[i], Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addTache(View view){
        Intent intention = new Intent(this, manageTacheActivity.class);
        startActivity(intention);
    }

    private void tacheListInit() {
        //récupération de la liste des contacts ancienne méthode

        tacheList = dao.findAll();

        TacheArrayAdapter tacheAdapter = new TacheArrayAdapter(this, tacheList);

      //  tacheListView.setOnItemClickListener(this);
        // définition de l'adapter de notre listView

        tacheListView.setAdapter(tacheAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
