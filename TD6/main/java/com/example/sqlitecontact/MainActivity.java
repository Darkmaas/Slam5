package com.example.sqlitecontact;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.provider.ContactsContract;
        import android.util.Log;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TableLayout;
        import android.widget.TableRow;
        import android.widget.TextView;

        import org.w3c.dom.Text;

        import java.util.Iterator;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DatabaseHelper db = new DatabaseHelper(this);
        db.open();
        db.videlabase();

        /*Log.d("JMF", "Insertion de Contact");
        db.insertContact(new Contact(1,"Jo", "9100000000"));
        db.insertContact(new Contact(2,"Jack", "9199999999"));
        db.insertContact(new Contact(3,"William", "9522222222"));
        db.insertContact(new Contact(4,"Averel", "9533333333"));

        // Reading all contacts
        Log.d("JMF", "Lecture des Contacts");
        List<Contact> contacts = db.getAllContacts();
        Log.d("hey","aled");
        for (Contact cn : contacts) {
            String log = "Id: "+cn.get_id()+" ,Name: "+ cn.getNom() + " ,Phone: "+cn.getNumTelephone();
            //Writing Contacts to log
            Log.d("JMF", log);
        }
        */

        ListView lv = (ListView)findViewById(R.id.listView);
        String[] listApp = new String[]{
                "Afficher tous vos contacts",
                "Ajouter un contact",
                "Modifier un contact",
                "Initialisation de la base !"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listApp);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("jii,kik,","position"+position);
                if (position == 0){
                    Intent intent;
                    intent = new Intent(MainActivity.this, ListContact.class);
                    startActivity(intent);

                }else if (position == 1){
                    Intent intent;
                    intent = new Intent(MainActivity.this, ajoutcontact.class);
                    startActivity(intent);

                }else if(position == 2){
                    Intent intent;
                    intent = new Intent(MainActivity.this, EditContact.class);
                    startActivity(intent);

                }else if (position == 3){
                    db.videlabase();
                    Log.d("JMF", "Insertion de Contact");
                    db.insertContact(new Contact(1,"Jo", "9100000000"));
                    db.insertContact(new Contact(2,"Jack", "9199999999"));
                    db.insertContact(new Contact(3,"William", "9522222222"));
                    db.insertContact(new Contact(4,"Averel", "9533333333"));
                }
            }
        });
    }
}
