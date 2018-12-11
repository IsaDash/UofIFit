package com.example.isadash.uiucfit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
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

    private static String updateHeight;
    private static String updateWeight;
    String updateGoal;

    Button btnHeight;
    Button btnWeight;
    Button btnSteps;
    //    Button btnCalorie;
    EditText height;
    EditText weight;
    //    EditText calorie;
    TextView tWeight;
    TextView tHeight;
    //    TextView tCalorie;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = this;

        height = (EditText) findViewById(R.id.editHeight);
        weight = (EditText)  findViewById(R.id.editWeight);
//        calorie = (EditText)  findViewById(R.id.editCalorie);

        btnHeight = (Button) findViewById(R.id.buttonHeight);
        btnWeight = (Button) findViewById(R.id.buttonWeight);
        btnSteps = (Button) findViewById(R.id.buttonCalorie);
//        btnCalorie = (Button) findViewById(R.id.buttonCalorie);

        tWeight = (TextView) findViewById(R.id.textViewWeight);
        updateWeight = getDataFromPreferences(context, "weight");
        tWeight.setText("Weight: " + updateWeight);

        tHeight = (TextView) findViewById(R.id.textViewHeight);
        updateHeight = getDataFromPreferences(context, "height");
        tHeight.setText("Height: " + updateHeight);
//        tCalorie = (TextView) findViewById(R.id.textViewCalorie);


        btnHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateHeight = height.getText().toString();
                saveDataToPreferences(context, "height", updateHeight);
                tHeight.setText("Height: " + updateHeight);
                Toast.makeText(profile.this, "Height updated successfully", Toast.LENGTH_LONG).show();


            }
        });
        btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateWeight = weight.getText().toString();
                saveDataToPreferences(context, "weight", updateWeight);
                tWeight.setText("Weight: " + updateWeight);
                Toast.makeText(profile.this, "Weight updated successfully", Toast.LENGTH_LONG).show();
            }
        });

        btnSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(profile.this, "Generating Step Goal", Toast.LENGTH_LONG).show();
            }
        });


        /*btnCalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c = calorie.getText().toString();
                tCalorie.setText("Calorie: " + c);
                Toast.makeText(profile.this, "Calorie goal updated successfully", Toast.LENGTH_LONG).show();
            }
        });
*/



    }

    public static void saveDataToPreferences(Context context, String key,
                                             String value) {
        SharedPreferences preferences = context.getSharedPreferences("your package name",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getDataFromPreferences(Context context, String key) {

        SharedPreferences preferences = context.getSharedPreferences("your package name",
                Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    public static double getWeight() {
        String w = updateWeight.split("$")[0].trim();
        double wNumeric = Double.parseDouble(w);
        return wNumeric;
    }
    public static double getHeight() {
        String h = updateHeight.split("$")[0].trim();
        double hNumeric = Double.parseDouble(h);
        return hNumeric;
    }


}

