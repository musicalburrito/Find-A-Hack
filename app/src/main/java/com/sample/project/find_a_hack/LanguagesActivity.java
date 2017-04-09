package com.sample.project.find_a_hack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.util.TypedValue;

public class LanguagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        TextView text = (TextView)findViewById(R.id.textView2);
        text.setText("Which languages are you interested in using?");
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 65);
        setContentView(text);
    }
}
