package com.sample.project.find_a_hack;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.lang.String;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    /* get instance of database. needs to be a final attribute of class or a global variable to be used
       in the functions.
     */
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("data");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* sets button variable */
        Button button;
        button = (Button) findViewById(R.id.usernamebutton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* sets text data variable and stores it into database upon button click.
                 changed type to string to make it easier to debug can store any class. */
                EditText textData;
                textData = (EditText) findViewById(R.id.editText);
                myRef.push().setValue(textData.getText().toString());
                Intent nextWindow = new Intent(v.getContext(), LanguagesActivity.class);
                startActivity(nextWindow);
            }
        });

        /* listens for data change. outputs data from database.  */
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue(String.class);
                Log.d("success", value);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String commentKey = dataSnapshot.getKey();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String commentKey = dataSnapshot.getKey();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                String commentKey = dataSnapshot.getKey();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                String commentKey = "sup";
            }
        };
    }
}
