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

    private EditText height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        height = (EditText) findViewById(R.id.txtUserName);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h = height.getText().toString();
                TextView enteredHeight = (TextView) findViewById(R.id.newHeight);
            }
        });

    }
}
