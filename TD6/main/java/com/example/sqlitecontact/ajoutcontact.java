package com.example.sqlitecontact;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ajoutcontact extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creercontact);
        final DatabaseHelper db = new DatabaseHelper(this);
        db.open();

        Button Ajout = (Button) findViewById(R.id.ajout);
        Ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("JMF", "insertion d'un Contacts");
                List<Contact> contacts = db.getAllContacts();
                Integer i = contacts.size()+1;
                EditText tNom = (EditText) findViewById(R.id.editname);
                String Nom = tNom.getText().toString();
                EditText tNum = (EditText) findViewById(R.id.editnum);
                String Num = tNum.getText().toString();
                Contact contact= new Contact(i,Nom,Num);
                db.insertContact(contact);

                finish();
            }
        });
    }

}
