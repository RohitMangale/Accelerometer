package com.example.kudos;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView textViewX,textViewY,textViewZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewX = findViewById(R.id.sensorX);
        textViewY = findViewById(R.id.sensorY);
        textViewZ = findViewById(R.id.sensorZ);

        SensorManager sensor =(SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensor!=null){
            Sensor acceleroSensor=sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(acceleroSensor!=null){
                sensor.registerListener(this, acceleroSensor,SensorManager.SENSOR_DELAY_NORMAL);

            }
        }
        else{
            Toast.makeText(this, "Sensor service not detected.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
                     textViewX.setText("x: "+event.values[0]);
                     textViewY.setText("y: "+event.values[1]);
                     textViewZ.setText("z:"+event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
}