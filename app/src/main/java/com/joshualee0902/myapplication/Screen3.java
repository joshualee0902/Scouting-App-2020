package com.joshualee0902.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class Screen3 extends AppCompatActivity {

    Button next2;
    Button back1;
    boolean checkCrossedLine;
    ElegantNumberButton upperScore;
    ElegantNumberButton lowerScore;
    String autoUpper;
    String autoLower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        next2 = findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreen4();
                finish();
            }
        });

        back1 = findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreen2();
                finish();
            }
        });

        checkCrossedLine = ((CheckBox) findViewById(R.id.checkCrossedLine)).isChecked();

        upperScore = findViewById(R.id.AutoUpper);
        autoUpper = upperScore.getNumber();

        lowerScore = findViewById(R.id.AutoLower);
        autoLower = lowerScore.getNumber();
    }

    public void openScreen4() {
        Intent intent3 = new Intent(this, Screen4.class);
        startActivity(intent3);
    }

    public void openScreen2() {
        Intent intent4 = new Intent(this, Screen2.class);
        startActivity(intent4);
    }
}
