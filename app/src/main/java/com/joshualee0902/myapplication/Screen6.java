package com.joshualee0902.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


public class Screen6 extends AppCompatActivity {


    Button submit;
    //String teamNumberDisplay;
    //String matchNumberDisplay
    String total;
    TextView final_product;
    String teamNumber;
    String matchNumber;
    Bundle extras;

    public final static String TEAM_KEY = "TEAM_NUM";
    public final static String MATCH_KEY = "MATCH_NUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);
        /*
        teamNumberDisplay = getIntent().getStringExtra("team_number");
        matchNumberDisplay = getIntent().getStringExtra("match_number");
        */

        Context context = getApplicationContext();
        CharSequence textIntent = "getIntent() is null.";
        CharSequence extraInent = "extras is null.";
        CharSequence stringsIntent = "string variables are null.";
        int duration = Toast.LENGTH_SHORT;

        Intent intent = getIntent();
        if(getIntent() != null) {
            extras = intent.getExtras();

            if (extras != null) {
                teamNumber = extras.getString(TEAM_KEY);
                matchNumber = extras.getString(MATCH_KEY);

                if (teamNumber != null && matchNumber != null) {
                    total = (matchNumber + " | " + teamNumber);
                } else {
                    Toast toast3 = Toast.makeText(context, stringsIntent, duration);
                    toast3.show();
                }
            } else {
                Toast toast2 = Toast.makeText(context, extraInent, duration);
                toast2.show();
            }
        } else {
            Toast toast1 = Toast.makeText(context, textIntent, duration);
            toast1.show();
        }

        submit = findViewById(R.id.next4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitData();
            }
        });

        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }



        fileName = (EditText) findViewById(R.id.file_name);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = fileName.getText().toString();
                String total = Screen2.matchNumber + " | " + Screen2.teamNumber;

                if(!filename.equals("")) {
                    saveTextAsFile(filename, total);
                }
            }

            /*
            private void printString(String total) {
                final String fileName = "data.txt";
                try {
                    final PrintWriter outputStream = new PrintWriter(fileName);
                    outputStream.print(total);
                    outputStream.close();
                } catch (final FileNotFoundException e) {
                    e.printStackTrace();
                }
            }


        });

         */
    }

    public void submitData() {

        //teamNumber = getIntent().getExtras().getString("TEAM_NUM");
        //matchNumber = getIntent().getExtras().getString("MATCH_NUM");

        final_product = findViewById(R.id.final_product);
        final_product.setText(total);

    }

    /*

    private void saveTextAsFile(String filename, String total) {
        filename = filename + ".txt";

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(total.getBytes());
            fos.close();
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1000:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission not granted.", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }


     */

}
