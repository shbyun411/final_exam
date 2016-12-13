package com.example.igx.problem1;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.hardware.SensorManager.DATA_X;
import static android.hardware.SensorManager.DATA_Y;
import static android.hardware.SensorManager.DATA_Z;

public class MainActivity extends AppCompatActivity implements SensorEventListener/* implements Something1, Something2 */ {

    SensorManager sensorManager;
    Sensor ACCELEROMETER;
    private float x;
    private float y;
    private float z;
    public static int cnt = 0;
    private GpsInfo gps;
    private float last_x;
    private float last_y;
    private float last_z;

    private final int SHAKE_Hold = 800;

    long lasttime;
    long speed;

    Double latitude;
    Double longitude;


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
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        ACCELEROMETER = sensorManager.getDefaultSensor(ACCELEROMETER.TYPE_ACCELEROMETER);

        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_selectedType.setText("Location");
                gps = new GpsInfo(MainActivity.this);
                // GPS 사용유무 가져오기
                if (gps.isGetLocation()) {

                    latitude = gps.getLatitude();
                    longitude = gps.getLongitude();

                    text_selectedData.setText("현재 위도는 : " + latitude + " 이고, 현재 경도는 : " + longitude+"입니다.");

                } else {
                    // GPS 를 사용할수 없으므로
                }
            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText("Sensors");
                text_selectedData.setText("오늘의 걸음수는 "+cnt+" 입니다.");
            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void onStart() {
        super.onStart();
        if (ACCELEROMETER != null)
            sensorManager.registerListener((SensorEventListener) this, ACCELEROMETER, SensorManager.SENSOR_DELAY_GAME);
    }

    public void onStop() {
        super.onStop();
        if (sensorManager != null)
            sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTime = System.currentTimeMillis();
        long GapTime = (currentTime - lasttime);
        if (GapTime > 100) {
            lasttime = currentTime;
            x = sensorEvent.values[DATA_X];
            y = sensorEvent.values[DATA_Y];
            z = sensorEvent.values[DATA_Z];
            speed = (long) (Math.abs(x + y + z - last_x - last_y - last_z) / GapTime * 10000);

            if (speed > SHAKE_Hold) {
                cnt++;
            }
            last_x = sensorEvent.values[DATA_X];
            last_y = sensorEvent.values[DATA_Y];
            last_z = sensorEvent.values[DATA_Z];

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}










