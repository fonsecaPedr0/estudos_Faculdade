package com.example.congressounirp.Model;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConnectDataBase {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    public DatabaseReference connectCloudDataBase(Context content){
        FirebaseApp.initializeApp(content.getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();
        return databaseReference;
    }
}
