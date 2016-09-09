package com.bridgelabz.android_sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class SQLiteDemo extends Activity {
    Button getContact,update,delete,getCount;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);

        getContact=(Button)findViewById(R.id.getContacts);
        update=(Button)findViewById(R.id.update);
        delete=(Button)findViewById(R.id.delete);
        getCount=(Button)findViewById(R.id.getCount);

        final DatabaseHandler1 db = new DatabaseHandler1(this);
        contact =new Contact();
        contact.setID(5);
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "910354500000"));
        db.addContact(new Contact("Raju", "919956599999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Rohan", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        final List<Contact> contacts = db.getAllContacts();

        getContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact myContanct=db.getContact(contact.getID());
                Toast.makeText(SQLiteDemo.this,"All Contacts "+myContanct.getName(),Toast.LENGTH_LONG).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SQLiteDemo.this,"Update "+ db.updateContact(contact),Toast.LENGTH_LONG).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteContact(contact);
                Toast.makeText(SQLiteDemo.this,"Delete ",Toast.LENGTH_LONG).show();
            }
        });

        getCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int contact5= db.getContactsCount();
                Toast.makeText(SQLiteDemo.this,"Count "+contact5,Toast.LENGTH_LONG).show();

            }
        });

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
