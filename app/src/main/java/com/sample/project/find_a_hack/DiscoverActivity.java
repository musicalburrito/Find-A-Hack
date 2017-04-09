package com.sample.project.find_a_hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class DiscoverActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Project");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        Button select = (Button) findViewById(R.id.select);
        Button reject = (Button) findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
        reject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextWindow = new Intent(v.getContext(), CreateActivity.class);
                startActivity(nextWindow);
            }
        });
    }
}
