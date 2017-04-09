package com.sample.project.find_a_hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button create = (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextWindow = new Intent(v.getContext(), CreateActivity.class);
                startActivity(nextWindow);
            }
        });
        Button discover;
        discover = (Button) findViewById(R.id.discover);
        discover.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextWindow = new Intent(v.getContext(), DiscoverActivity.class);
                startActivity(nextWindow);
            }
        });
//        Button requests;
//        requests = (Button) findViewById(R.id.requests);
//        requests.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//
//            }
//        });

    }
}
