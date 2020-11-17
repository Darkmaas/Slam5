package com.example.sqlitecontact;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class ListContact extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allcontacts);
        final DatabaseHelper db = new DatabaseHelper(this);
        db.open();
        
        Log.d("JMF", "Lecture des Contacts");
        List<Contact> contacts = db.getAllContacts();
        TableLayout table = (TableLayout) findViewById(R.id.allcontact);
        for (Contact cn : contacts) {
            TableRow row = new TableRow(ListContact.this);
            TextView tNom = new TextView(ListContact.this);
            tNom.setText(cn.getNom());
            row.addView(tNom);
            TextView tNum = new TextView(ListContact.this);
            tNum.setText(cn.getNumTelephone());
            row.addView(tNum);
            table.addView(row, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

            String log = "Id: " + cn.get_id() + " ,Name: " + cn.getNom() + " ,Phone: " + cn.getNumTelephone();
            //Writing Contacts to log
            Log.d("JMF", log);
        }
    }
}
