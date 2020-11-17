package com.example.sqlitecontact;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DetailContact extends AppCompatActivity {
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailcontact);
        final DatabaseHelper db = new DatabaseHelper(this);
        db.open();

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",-1);
        final String nom = intent.getStringExtra("name");
        final String num = intent.getStringExtra("num");


        final Contact contact = new Contact(id,nom,num);


        final EditText tnom =findViewById(R.id.nom);
        final EditText tnum =findViewById(R.id.num);

        tnom.setText(contact.getNom());
        tnum.setText(contact.getNumTelephone());

        Button mod = (Button) findViewById(R.id.mod);
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("JMF", "insertion d'un Contacts");
                /*List<Contact> contacts = db.getAllContacts();
                Integer i = contacts.size()+1;
                EditText tNom = (EditText) findViewById(R.id.editname);
                String Nom = tNom.getText().toString();
                EditText tNum = (EditText) findViewById(R.id.editnum);
                String Num = tNum.getText().toString();
                Contact contact= new Contact(i,Nom,Num);
                db.insertContact(contact);*/

                String lenom = tnom.getText().toString();
                String lenum = tnum.getText().toString();

                Contact contact = new Contact(id,lenom,lenum);
                db.updateContact(contact);


                finish();
            }
        });


    }
}
