package com.example.sqlitecontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EditContact extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcontact);
        final DatabaseHelper db = new DatabaseHelper(this);
        db.open();



        ListView lv = (ListView)findViewById(R.id.listCon);
        final List<Contact> contacts = db.getAllContacts();
        String[] listcon = new String[contacts.size()];

        for(int i =0; i < contacts.size(); i++){
            listcon[i] = contacts.get(i).getNom();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listcon);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                intent = new Intent(EditContact.this, DetailContact.class);
                intent.putExtra("name",contacts.get(position).getNom());
                intent.putExtra("id",contacts.get(position).get_id());
                intent.putExtra("num",contacts.get(position).getNumTelephone());
                startActivity(intent);
            }
        });
    }
}
