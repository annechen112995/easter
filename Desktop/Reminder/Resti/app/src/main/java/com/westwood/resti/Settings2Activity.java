package com.westwood.resti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Settings2Activity extends AppCompatActivity {

    ImageButton ibSubmit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);

        ibSubmit2 = (ImageButton) findViewById(R.id.ibSubmit2);

        ibSubmit2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Settings2Activity.this, RoutesActivity.class);
                startActivity(i);
            }
        });
    }
}
