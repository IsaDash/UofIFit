package com.example.isadash.uiucfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class  profile extends AppCompatActivity {

    ArrayList<String> updateHeight =  new ArrayList<String>();
    ArrayList<String> updateWeight =  new ArrayList<String>();
    ArrayList<String> updateCalorie =  new ArrayList<String>();

    Button btnHeight;
    Button btnWeight;
    Button btnCalorie;
    EditText height;
    EditText weight;
    EditText calorie;
    TextView tWeight;
    TextView tHeight;
    TextView tCalorie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        height = (EditText) findViewById(R.id.editHeight);
        weight = (EditText)  findViewById(R.id.editWeight);
        calorie = (EditText)  findViewById(R.id.editCalorie);

        btnHeight = (Button) findViewById(R.id.buttonHeight);
        btnWeight = (Button) findViewById(R.id.buttonWeight);
        btnCalorie = (Button) findViewById(R.id.buttonCalorie);
        tWeight = (TextView) findViewById(R.id.textViewWeight);
        tHeight = (TextView) findViewById(R.id.textViewHeight);
        tCalorie = (TextView) findViewById(R.id.textViewCalorie);


        btnHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h = height.getText().toString();
                tHeight.setText("Height: " + h);
                Toast.makeText(profile.this, "Height updated successfully", Toast.LENGTH_LONG).show();


            }
        });
        btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String w = weight.getText().toString();
                tWeight.setText("Weight: " + w);
                Toast.makeText(profile.this, "Weight updated successfully", Toast.LENGTH_LONG).show();
            }
        });
        btnCalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c = calorie.getText().toString();
                tCalorie.setText("Calorie: " + c);
                Toast.makeText(profile.this, "Calorie goal updated successfully", Toast.LENGTH_LONG).show();
            }
        });




        }








    }

