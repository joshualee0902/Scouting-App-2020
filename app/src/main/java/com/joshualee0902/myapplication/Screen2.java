package com.joshualee0902.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {

    String teamNumber;
    String matchNumber;
    public EditText teamNum;
    public EditText matchNum;
    Button next1;
    Bundle extras;
    public final static String TEAM_KEY = "TEAM_NUM";
    public final static String MATCH_KEY = "MATCH_NUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        teamNum = findViewById(R.id.teamNum);
        matchNum = findViewById(R.id.matchNum);

        teamNumber = teamNum.getText().toString();
        matchNumber = matchNum.getText().toString();

        extras = new Bundle();
        extras.putString(TEAM_KEY, teamNumber);
        extras.putString(MATCH_KEY, matchNumber);

        next1 = findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent pass1 = new Intent(Screen2.this, Screen6.class);
                String teamNumber = teamNum.getText().toString();
                pass1.putExtra("team_number", teamNumber);
                startActivity(pass1);

                Intent pass2 = new Intent(Screen2.this, Screen6.class);
                String matchNumber = matchNum.getText().toString();
                pass1.putExtra("match_number", matchNumber);
                startActivity(pass2);
                */

                passData();
                openScreen3();
                finish();
            }
        });

    }


    public void passData() {
        Intent intent = new Intent(Screen2.this, Screen6.class);
        //pass.putExtra("TEAM_NUM", teamNumber);
        //pass.putExtra("MATCH_NUM", matchNumber);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void openScreen3() {
        Intent intent2 = new Intent(this, Screen3.class);
        startActivity(intent2);
    }

}
