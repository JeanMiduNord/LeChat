package com.m2i.toutdouxliste;



public class Tache {
    private Long id;
    private String tache;
    private int done;
    private String userName;

    public Tache() {
    }

    public Tache(Long id, String tache, int done) {
        this.id = id;
        this.tache = tache;
        this.done = done;
    }

    public Tache(String tache, int done, String userName) {
        this.tache = tache;
        this.done = done;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public Tache setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTache() {
        return tache;
    }

    public Tache setTache(String tache) {
        this.tache = tache;
        return this;
    }

    public int getDone() {
        return done;
    }

    public Tache setDone(int done) {
        this.done = done;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Tache setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
