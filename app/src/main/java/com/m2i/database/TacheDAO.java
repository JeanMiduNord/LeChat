package com.m2i.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
// import java.util.List;package fr.sm.database;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

// import com.example.formation.localsqlapp.model.Contact;

import com.m2i.toutdouxliste.Tache;

import java.util.ArrayList;
import java.util.List;

public class TacheDAO {
    private DatabaseHandler db;

    public TacheDAO(DatabaseHandler db) {
        this.db = db;
    }

    /**
     * Récupération d'une tache en fonction de sa clé primaire
     * @param id
     * @return
     */
    public Tache findOneById(long id) throws SQLiteException {
        // exécution de la requête
        String sql = "Select id, tache, done from tache where id=?";
        String[] params = {String.valueOf(id)};
        Cursor cursor = this.db.getReadableDatabase()
                .rawQuery(sql, params);
        // Instanciation d'une tache
        Tache tache = new Tache();
        // Hydratation de la tache
        if (cursor.moveToNext()) {
            hydrateTache(cursor);
        }
        cursor.close();
        return tache;
    }

    public List<Tache> findAll() throws SQLiteException{
        // Instanciation de la liste de contacts
        List<Tache> tacheList = new ArrayList<>();
        // exécution de la requête sql

        String sql = "Select id, tache, done from tache ";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql,null);

        //boucle sur le curseur
        while (cursor.moveToNext()){
            tacheList.add(hydrateTache(cursor));
        }

        cursor.close();
        return tacheList;
    }

    private Tache hydrateTache(Cursor cursor) {
        Tache tache = new Tache();
        tache.setId(cursor.getLong(0));
        tache.setTache(cursor.getString(1));
        tache.setDone(cursor.getInt(2));
        return tache;
    }

    public void deleteOneById(Long id){
        String[] params = {id.toString()};
        String sql = "DELETE FROM tache WHERE id=?";
        this.db.getWritableDatabase().execSQL(sql,params);
    }

    public void persist(Tache entity){
        if (entity.getId() == null){
            this.insert(entity);
        }
        else{
            this.update(entity);
        }
    }

    private ContentValues getContentValuesFromEntity(Tache entity){
        ContentValues values = new ContentValues();
        values.put("tache", entity.getTache());
        values.put("done", entity.getDone());
        return values;
    }

    private void insert(Tache tache){
        // la fonction retourne la valeur du dernier auto-incréùente
        Long id = this.db.getWritableDatabase().insert("tache",null,getContentValuesFromEntity(tache));
        tache.setId(id);
    }

    private void update(Tache tache){
        String[] params = {tache.getId().toString()};
        this.db.getWritableDatabase().update("tache", getContentValuesFromEntity(tache),"id=?", params);
    }
}