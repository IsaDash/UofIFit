package com.example.isadash.uiucfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class meals extends AppCompatActivity {

    private EditText food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        food = (EditText) findViewById(R.id.editFood);

        Button btnEnter = (Button) findViewById(R.id.buttonEnter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h = food.getText().toString();
                Toast.makeText(meals.this, "food entered successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}
