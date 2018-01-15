package com.m2i.toutdouxliste;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.m2i.database.DatabaseHandler;
import com.m2i.database.TacheDAO;

public class manageTacheActivity extends AppCompatActivity {
    private EditText edtTache;
    private EditText edtUserName;
    private TacheDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_tache);

        edtTache = (EditText) findViewById(R.id.edtTache);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        ActionBar actionBar = getActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void valideTache(View view){
        if (!edtTache.getText().toString().trim().equals("")){
            dao = new TacheDAO(new DatabaseHandler(this));
            Tache tache = new Tache(edtTache.getText().toString(),0,edtUserName.getText().toString());
            dao.persist(tache);
            Toast.makeText(this,"Enregistrement effectué.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Veuillez saisir une tache SVP !", Toast.LENGTH_SHORT).show();
        }
    }
}
