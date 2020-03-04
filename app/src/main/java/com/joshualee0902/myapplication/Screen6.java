package com.joshualee0902.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;


public class Screen6 extends AppCompatActivity {


    Button submit;
    TextView final_product;
    TextView format;
    public Database myDb = new Database(this);
    StringBuffer buffer;
    Button home;
    public static String resText;
    private static final int PERMISSION_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);

        format = findViewById(R.id.format);

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
                makeTxt();
            }
        });

    }

    public void submitData() {
        boolean isInserted = myDb.insertData(Screen2.teamNumber, Screen2.matchNumber, Screen5.windrawlose, Screen3.didCrossLine, Screen3.autoUpper, Screen3.autoLower, Screen4.teleUpper, Screen4.teleLower, Screen4.wheel, Screen4.climbed, Screen4.fouls, Screen5.totPoints, Screen5.rankingPoints, Screen5.bricked, Screen5.say);
        if (isInserted) {
            //if the data is successfully submitted, "Data Inserted" Toast will appear
            Toast.makeText(Screen6.this, "Data Inserted", Toast.LENGTH_LONG).show();
        } else {
            //if the data is not successfully submitted, "Data Not Inserted" Toast will appear
            Toast.makeText(Screen6.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
        }

        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            Toast.makeText(Screen6.this, "Nothing is found.", Toast.LENGTH_SHORT).show();
        }

        buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append(res.getString(0) + "|" + res.getString(1) + "|" + res.getString(2) + "|" + res.getString(3) + "|" + res.getString(4) +
                    "|" + res.getString(5) + "|" + res.getString(6) + "|" + res.getString(7) + "|" + res.getString(8) +
                    "|" + res.getString(9) + "|" + res.getString(11) + "|" + res.getString(12) + "|" + res.getString(13) + "|" + res.getString(14) + "\n");
        }

        resText = buffer.toString();
        final_product = findViewById(R.id.final_product);
        final_product.setText(resText);
        final_product.setFocusable(true);
        final_product.setEnabled(true);
        final_product.setClickable(true);
        final_product.setFocusableInTouchMode(true);

    }

     public void makeTxt() {
         if (!resText.isEmpty()) {
             String state = Environment.getExternalStorageState();
             if (Environment.MEDIA_MOUNTED.equals(state)) {
                 if (Build.VERSION.SDK_INT >= 23) {
                     if (checkPermission()) {
                         File sdcard = Environment.getExternalStorageDirectory();
                         File dir = new File(sdcard.getAbsolutePath() + "/text files/");
                         dir.mkdir();
                         File file = new File(dir, "data.txt");
                         FileOutputStream os = null;
                         try {
                             os = new FileOutputStream(file);
                             os.write(resText.getBytes());
                             os.close();
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     } else {
                         requestPermission();
                     }
                 } else {

                     File sdcard = Environment.getExternalStorageDirectory();
                     File dir = new File(sdcard.getAbsolutePath() + "/text files/");
                     dir.mkdir();
                     File file = new File(dir, "data.txt");
                     FileOutputStream os = null;
                     try {
                         os = new FileOutputStream(file);
                         os.write(resText.getBytes());
                         os.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }


             }


         }

     }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(Screen6.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(Screen6.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(Screen6.this, "Write External Storage permission allows us to create files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(Screen6.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }

                break;
        }
    }

    public void openHome() {
        Intent intent9 = new Intent(this, MainActivity.class);
        startActivity(intent9);
    }

}
