package com.sample.project.find_a_hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("projects");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Button button;
        button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* sets text data variable and stores it into database upon button click.
                 changed type to string to make it easier to debug can store any class. */
                EditText textData = (EditText) findViewById(R.id.projname);
                String title = textData.getText().toString();
                myRef.setValue(title);

                EditText textData1 = (EditText) findViewById(R.id.projdesc);
                String desc = textData1.getText().toString();
                myRef.child(title).setValue(desc);

                Intent nextWindow = new Intent(v.getContext(), StartActivity.class);
                startActivity(nextWindow);

            }
        });
    }
}
