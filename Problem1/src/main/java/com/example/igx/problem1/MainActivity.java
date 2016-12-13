package com.example.igx.problem1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Context;
import java.lang.String;



public class MainActivity extends AppCompatActivity implements SensorEventListener /* implements Something1, Something2 */ {


    private SensorManager mSensorManager;
    private Sensor sensor_Gravity;
    private Sensor sensor_accelerometer;
    private Sensor sensor_linear_acceleration;
    private Sensor sensor_Gyroscope;
    double acceleration;
    double gravity;
    double gyroscope;
    double linear;
    String result;
    double lat;
    double lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_getLocation = (Button) findViewById(R.id.btn_getLocation);
        Button btn_getSensors = (Button) findViewById(R.id.btn_getSensors);
        Button btn_sendMessage = (Button) findViewById(R.id.btn_sendMessage);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor_Gravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_linear_acceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensor_Gyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        final TextView text_selectedData = (TextView) findViewById(R.id.text_selectedData);
        final TextView text_selectedType = (TextView) findViewById(R.id.text_selectedType);
        final EditText edit_phoneNumber = (EditText) findViewById(R.id.edit_phoneNumber);


        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("Location");
                result = "lat:"+lat+" lng:"+lng;
                text_selectedData.setText(""+result);

            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("Sensors");
                result = "Accelerometer:"+acceleration+" Gravity:"+gravity+" Gyroscope:"+gyroscope+" LinearAccel:"+linear;
                text_selectedData.setText(""+result);

            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myData = edit_phoneNumber.getText().toString();
                Intent sendIntent = new Intent();
               sendIntent.setData(Uri.parse("mydata"));
                sendIntent.setAction(Intent.ACTION_SENDTO);
                sendIntent.putExtra(Intent.EXTRA_TEXT, ""+result);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }



    protected void onResume(){
        super.onResume();

        mSensorManager.registerListener(this, sensor_Gravity, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sensor_accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sensor_linear_acceleration, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sensor_Gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }



    protected void onPause(){
        super.onPause();

        mSensorManager.unregisterListener(this);
    }



    public final void onAccuracyChanged(Sensor sensor, int accuracy){
    }

    public final void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            acceleration = Math.sqrt(x * x + y * y + z * z);
        }
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY) {
            float gx = event.values[0];
            float gy = event.values[1];
            float gz = event.values[2];
            gravity = Math.sqrt(gx * gx + gy * gy + gz * gz);
        }
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            float gyx = event.values[0];
            float gyy = event.values[1];
            float gyz = event.values[2];
            gyroscope = Math.sqrt(gyx * gyx + gyy * gyy + gyz * gyz);
        }
        if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
            float lx = event.values[0];
            float ly = event.values[1];
            float lz = event.values[2];
            linear = Math.sqrt(lx * lx + ly * ly + lz * lz);
        }
    }

}

