package com.example.igx.problem1;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /* implements Something1, Something2 */ {




  SensorManager sensorManager;
    Sensor sensor;
    Sensor sensor1;
    Sensor sensor3;
    Sensor sensor4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor1 = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);

        sensor3 = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensor4 = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);


        Button btn_getLocation = (Button) findViewById(R.id.btn_getLocation);
        Button btn_getSensors = (Button) findViewById(R.id.btn_getSensors);
        Button btn_sendMessage = (Button) findViewById(R.id.btn_sendMessage);

        final TextView text_selectedData = (TextView) findViewById(R.id.text_selectedData);
        final TextView text_selectedType = (TextView) findViewById(R.id.text_selectedType);
        final EditText edit_phoneNumber = (EditText) findViewById(R.id.edit_phoneNumber);

        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              text_selectedData.setText("GYROSCOPE : "+sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE));
              text_selectedType.setText("Location");
            }
        });




        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("Sensors");



                text_selectedData.setText("ACCELEROMETER, TEMPERATURE2, ROTATION_VECTOR : "
                 +sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                  +sensorManager+sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE)
                  +sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR));

            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              edit_phoneNumber.getText();
            }
        });
    }
}












