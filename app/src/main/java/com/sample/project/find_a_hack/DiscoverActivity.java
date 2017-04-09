package com.sample.project.find_a_hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class DiscoverActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("projects");
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> descl = new ArrayList<String>();
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
//        ArrayList<String> titles = new ArrayList<String>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            for(DataSnapshot child: dataSnapshot.getChildren()){
//
//                Log.i("fsafdfdfas", child.getKey());
//            }

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren()) {
//                    titles.add(child.getKey());
//                    descl.add(child.getValue(String.class));
//                    if(child != null && child.getKey() != null) {
                        Log.d("this isn't null", child.getKey());
//                        TextView title = (TextView) findViewById(R.id.projname);
//                        title.setText(child.getKey());
//                        TextView desc = (TextView) findViewById(R.id.projdesc);
//                        desc.setText(child.getValue(String.class));
//                    Log.d("this is a key ", "haha " + descl.get(0));
//                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("error", "whoops");
            }
        });

//        Log.d("size of title", "val " + titles.size());
//        TextView title = (TextView) findViewById(R.id.projname);
//        title.setText(titles.get(0));
//        TextView desc = (TextView) findViewById(R.id.projdesc);
//        desc.setText(descl.get(0));

        Button yes = (Button) findViewById(R.id.select);
        Button no = (Button) findViewById(R.id.pass);

        yes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("success", "notify project leader of match");
//                Intent nextWindow = new Intent(v.getContext(), DiscoverActivity.class);
//                startActivity(nextWindow);
            }
        });

        no.setOnClickListener(new View.OnClickListener(){
//            int counter = 1;
            @Override
            public void onClick(View v){
                TextView title = (TextView) findViewById(R.id.projname);
                title.setText(titles.get(counter));
                TextView desc = (TextView) findViewById(R.id.projdesc);
                desc.setText(descl.get(counter));
                ++counter;
//                Intent nextWindow = new Intent(v.getContext(), DiscoverActivity.class);
//                startActivity(nextWindow);
            }
        });

    }
}
