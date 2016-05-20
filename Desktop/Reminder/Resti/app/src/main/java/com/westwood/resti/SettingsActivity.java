package com.westwood.resti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity {

    ImageButton ibSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ibSubmit = (ImageButton) findViewById(R.id.ibSubmit);

        ibSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SettingsActivity.this, RoutesActivity.class);
                startActivity(i);
            }
        });
    }
}
