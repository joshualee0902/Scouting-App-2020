package com.joshualee0902.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class Screen4 extends AppCompatActivity {

    Button next3;
    Button back2;
    ElegantNumberButton upperScore;
    ElegantNumberButton lowerScore;
    boolean checkWheelSpin;
    boolean checkWheelColor;
    boolean checkClimbed;
    ElegantNumberButton foul;
    String teleUpper;
    String teleLower;
    String fouls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        next3 = findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreen5();
                finish();
            }
        });

        back2 = findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreen3();
                finish();
            }
        });

        upperScore = findViewById(R.id.TeleUpper);
        teleUpper = upperScore.getNumber();

        lowerScore = findViewById(R.id.TeleLower);
        teleLower = lowerScore.getNumber();

        checkWheelSpin = ((CheckBox) findViewById(R.id.checkWheelSpin)).isChecked();
        checkWheelColor = ((CheckBox) findViewById(R.id.checkWheelColor)).isChecked();
        checkClimbed = ((CheckBox) findViewById(R.id.checkClimb)).isChecked();

        foul = findViewById(R.id.Fouls);
        fouls = foul.getNumber();
    }

    public void openScreen5() {
        Intent intent5 = new Intent(this, Screen5.class);
        startActivity(intent5);
    }

    public void openScreen3() {
        Intent intent6 = new Intent(this, Screen3.class);
        startActivity(intent6);
    }
}
