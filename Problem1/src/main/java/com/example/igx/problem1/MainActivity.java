package com.example.igx.problem1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class MainActivity extends AppCompatActivity implements LocationListener /* implements Something1, Something2 */ {

    public void onLocationChanged(Location location) {
        Double latitude = location.getLatitude();
        Double longitude = location.getLongitude();

        String msg = "위도 : "+ latitude + "\n경도:"+ longitude;
        Log.i("GPSLocationService", msg);

        // 현재 위치의 지도를 보여주기 위해 정의한 메소드 호출
        // showCurrentLocation(latitude, longitude);
    }

    public void onProviderDisabled(String provider) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }


    //public interface LocationListener

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
                text_selectedType.setText("LOCATION");
                text_selectedData.setText("위도: "+" 경도:");


            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("SENSORS");
                text_selectedData.setText("사용하고 있는 센서는 : ");

            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //text_selectedData = Integer.parseInt(String.valueOf(edit_phoneNumber.getText()));

            }
        });
    }
}




