package com.example.isadash.uiucfit;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class steps extends AppCompatActivity implements SensorEventListener {
    private static TextView steps;
    private TextView cal;
    SensorManager sensorManager;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        steps = (TextView) findViewById(R.id.textSteps);
        String stepsTaken = steps.getText().toString();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Sensor not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        running = false;
        //if you unregister the hardware will stop detecting stop
        //sensoryManager.unregisterListener(this);

    }

    public static double getSteps() {
        String sSteps = steps.getText().toString();sSteps = sSteps.split("$")[1].trim();
        double wNumeric = Double.parseDouble(sSteps);
        return wNumeric;
    }

    public void onSensorChanged(SensorEvent event) {
        if (running) {
            steps.setText(String.valueOf(event.values[0]));
            double calories = (1.9) * profile.getWeight() * 0.45 * (getSteps()/ 660.0);
            String calString = Double.toString(calories);
            cal = (TextView) findViewById(R.id.textCalories);
            cal.setText(String.valueOf(calories));

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
