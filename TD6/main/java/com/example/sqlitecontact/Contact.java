package com.example.sqlitecontact;

import java.util.ArrayList;

public class Contact extends ArrayList<Contact> {
    private int id;
    private String nom;
    private String numTelephone;

    public Contact(int _id, String nom, String numTelephone) {
        this.id = _id;
        this.nom = nom;
        this.numTelephone = numTelephone;
    }

    public Contact() {
        id = 0;
        nom = "";
        numTelephone= "";
    }


    public int get_id() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }
}
