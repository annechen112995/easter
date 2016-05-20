package com.westwood.resti;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class RestiActivity extends AppCompatActivity {

    RadioButton rbOne, rbTwo;
    TextView tvLogo, tvSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resti);

        //fonts
        Typeface arimaMadurai = Typeface.createFromAsset(this.getAssets(),"ArimaMadurai-Bold.ttf");

        rbOne = (RadioButton) findViewById(R.id.rbOne);
        rbTwo = (RadioButton) findViewById(R.id.rbTwo);
        tvLogo = (TextView) findViewById(R.id.tvLogo);
        tvSlogan = (TextView) findViewById(R.id.tvSlogan);

        rbOne.setTypeface(arimaMadurai);
        rbTwo.setTypeface(arimaMadurai);
        tvLogo.setTypeface(arimaMadurai);
        tvSlogan.setTypeface(arimaMadurai);

        rbOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onRadioClick(v);
            }
        });

        rbTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onRadioClick(v);
            }
        });
    }

    public void onRadioClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.rbOne:
                if (checked) {
                    rbTwo.setChecked(false);
                    Intent i = new Intent(RestiActivity.this, SettingsActivity.class);
                    startActivity(i);
                    break;
                }
            case R.id.rbTwo:
                if (checked) {
                    rbOne.setChecked(false);
                    Intent i = new Intent(RestiActivity.this, Settings2Activity.class);
                    startActivity(i);
                    break;
                }
        }
    }
}
