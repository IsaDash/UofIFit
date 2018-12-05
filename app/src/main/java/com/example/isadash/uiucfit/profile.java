package com.example.isadash.uiucfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    private EditText height, weight, calorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        height = (EditText) findViewById(R.id.editHeight);
        weight = (EditText)  findViewById(R.id.editWeight);
        calorie = (EditText)  findViewById(R.id.editCalorie);

        Button btnHeight = (Button) findViewById(R.id.buttonHeight);
        Button btnWeight = (Button) findViewById(R.id.buttonWeight);
        Button btnCalorie = (Button) findViewById(R.id.buttonCalorie);
        btnHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h = height.getText().toString();
                Toast.makeText(profile.this, "Height updated successfully", Toast.LENGTH_LONG).show();
            }
        });
        btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String w = weight.getText().toString();
                Toast.makeText(profile.this, "Weight updated successfully", Toast.LENGTH_LONG).show();
            }
        });
        btnCalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c = calorie.getText().toString();
                Toast.makeText(profile.this, "Calorie goal updated successfully", Toast.LENGTH_LONG).show();
            }
        });

    }
}
