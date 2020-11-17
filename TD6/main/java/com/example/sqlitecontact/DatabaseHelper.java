package com.example.sqlitecontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //All Static variables
    // Database Version
    private static final int DATABASE_VERSION= 1;

    // Database Name
    private static final String DATABASE_NAME="contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS="contacts";

    // Contacts Table Columns names
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_PH_NO="phone_number";

    private String[] allColumns ={KEY_ID,KEY_NAME,KEY_PH_NO};

    private SQLiteDatabase maBDD;
    private DatabaseHelper baseHelper;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase open(){
        maBDD = getWritableDatabase();
        return maBDD;
    }

    private static final String REQUETE_CREATION_TABLE = "create table "
            + TABLE_CONTACTS +"("+ KEY_ID +" integer primary key ,"
            + KEY_NAME + " string not null,"
            + KEY_PH_NO +" string not null);";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REQUETE_CREATION_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    public long insertContact (Contact contact){
        ContentValues valeurs = new ContentValues();
        valeurs.put(KEY_ID, contact.get_id());
        valeurs.put(KEY_NAME, contact.getNom());
        valeurs.put(KEY_PH_NO, contact.getNumTelephone());
        SQLiteDatabase maBDD = this.getWritableDatabase();
        return maBDD.insert(TABLE_CONTACTS, null, valeurs);
    }


    public List<Contact> getAllContacts(){
        maBDD=getWritableDatabase();
        List<Contact> contacts = new ArrayList<Contact>();
        Cursor c = maBDD.query(DatabaseHelper.TABLE_CONTACTS, new String[]{KEY_ID,KEY_NAME,KEY_PH_NO}, null, null, null, null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            Contact contact = (Contact) cursorToContact(c);
            contacts.add(contact);
            c.moveToNext();
        }
        c.close();
        return contacts;
    }

    private Contact cursorToContact(Cursor c) {
            Contact contact = new Contact();
            contact.set_id(c.getInt(0));
            contact.setNom(c.getString(1));
            contact.setNumTelephone(c.getString(2));
        return contact;
    }

    public Contact getContact(String nom){
        Cursor c = maBDD.query(TABLE_CONTACTS,
                new String[] {KEY_ID,KEY_NAME,KEY_PH_NO},
                null,
                null,
                null,
                KEY_NAME+" LIKE "+nom,
                null);
        return cursorToContact(c);
        }


     public Contact updateContact(Contact cn){
        ContentValues cv = new ContentValues();
        cv.put(KEY_ID,cn.get_id());
        cv.put(KEY_NAME,cn.getNom());
        cv.put(KEY_PH_NO,cn.getNumTelephone());
        maBDD.update(TABLE_CONTACTS,cv,"id="+cn.get_id(),null);
        return cn;
     }

    public void videlabase(){
        maBDD.execSQL("drop table "+ TABLE_CONTACTS + ";");
        maBDD.execSQL(REQUETE_CREATION_TABLE);
    }


}




