package com.sample.project.find_a_hack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LanguagesActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");
    boolean Web, iOS, Android, GameVR, Hardware;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        TextView text = (TextView)findViewById(R.id.textView2);
        text.setText("Which category do you want to work on?");
        Button button = (Button) findViewById(R.id.next2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Web = ((RadioButton) findViewById(R.id.Web)).isChecked();
                iOS = ((RadioButton) findViewById(R.id.iOS)).isChecked();
                Android = ((RadioButton) findViewById(R.id.Android)).isChecked();
                GameVR = ((RadioButton) findViewById(R.id.GameVR)).isChecked();
                Hardware = ((RadioButton) findViewById(R.id.Hardware)).isChecked();

                ArrayList<String> selections = new ArrayList<String>();

                if(Web){ selections.add("web"); };
                if(iOS){ selections.add("ios"); };
                if(Android)selections.add("droid");;
                if(GameVR){ selections.add("game"); };
                if(Hardware){ selections.add("hardware"); };
                worker addWorker = new worker();
                addWorker.setUsername(getIntent().getStringExtra("EXTRA_USERNAME"));
                addWorker.setCategories(selections);
                myRef.setValue(addWorker.username);
                myRef.child(addWorker.username).setValue(addWorker.categories);
                Intent nextWindow = new Intent(v.getContext(), StartActivity.class);
                startActivity(nextWindow);
            }
        });
    }
}
