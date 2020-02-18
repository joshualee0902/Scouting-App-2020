package com.joshualee0902.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.io.StringBufferInputStream;


public class Screen6 extends AppCompatActivity {


    Button submit;
    TextView final_product;
    public Database myDb = new Database(this);
    StringBuffer buffer;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);

        submit = findViewById(R.id.next4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitData();
            }
        });

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });

    }

    public void submitData() {
        boolean isInserted = myDb.insertData(Screen2.teamNumber, Screen2.matchNumber, Screen3.didCrossLine, Screen3.autoUpper, Screen3.autoLower, Screen4.teleUpper, Screen4.teleLower, Screen4.wheelSpinned, Screen4.wheelColored, Screen4.climbed, Screen4.fouls, Screen5.totPoints, Screen5.rankingPoints, Screen5.bricked, Screen5.say);
        if(isInserted) {
            //if the data is successfully submitted, "Data Inserted" Toast will appear
            Toast.makeText(Screen6.this, "Data Inserted", Toast.LENGTH_LONG).show();
        }
        else{
            //if the data is not successfully submitted, "Data Not Inserted" Toast will appear
            Toast.makeText(Screen6.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
        }

        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            Toast.makeText(Screen6.this, "Nothing is found.", Toast.LENGTH_SHORT).show();
        }

        buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append(res.getString(0) + " | " + res.getString(1) + " | " + res.getString(2) + " | " + res.getString(3) +
                    " | " + res.getString(4) + " | " + res.getString(5) + " | " + res.getString(6) + " | " + res.getString(7) +
                    " | " + res.getString(8) + " | " + res.getString(9) + " | " + res.getString(10) + " | " + res.getString(11) + " | " +
                    res.getString(12) + " | " + res.getString(13) + " | " + res.getString(14) + "\n\n");
        }

        String resText = buffer.toString();
        final_product = findViewById(R.id.final_product);
        final_product.setText(resText);
    }

    public void openHome() {
        Intent intent9 = new Intent(this, MainActivity.class);
        startActivity(intent9);
    }

}
