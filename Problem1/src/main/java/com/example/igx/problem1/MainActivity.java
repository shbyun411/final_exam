package com.example.igx.problem1;

import android.hardware.Sensor;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.location.Location;

import static android.content.Intent.ACTION_SENDTO;
import static android.hardware.Sensor.STRING_TYPE_ACCELEROMETER;
import static android.provider.ContactsContract.Intents.Insert.ACTION;

public class MainActivity extends AppCompatActivity /* implements Something1, Something2 */ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_getLocation = (Button) findViewById(R.id.btn_getLocation);
        Button btn_getSensors = (Button) findViewById(R.id.btn_getSensors);
        Button btn_sendMessage = (Button) findViewById(R.id.btn_sendMessage);

        final TextView text_selectedData = (TextView) findViewById(R.id.text_selectedData);
        final TextView text_selectedType = (TextView) findViewById(R.id.text_selectedType);
        final EditText edit_phoneNumber = (EditText) findViewById(R.id.edit_phoneNumber);


        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("Location");


                double a = location.getLongitude();
                double b = location.getAltitude();
                double c = location.getLatitude();
                text_selectedData.setText("Longitude = "+Double.toString(a) + "Altitude = "+Double.toString(b) + "Latitude = "+Double.toString(c));

            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("Sensors");

                String x = STRING_TYPE_ACCELEROMETER;

                text_selectedData.setText("STRING_TYPE_ACCELEROMETER = " + x);



            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ACTION_SENDTO

            }
        });
    }



    Location location;
    LocationListener locationListener;
    Sensor sensor;
}
