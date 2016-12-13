package com.example.igx.problem1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /* implements Something1, Something2 */ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_getLocation = (Button) findViewById(R.id.btn_getLocation);
        Button btn_getSensors = (Button) findViewById(R.id.btn_getSensors);
        Button btn_sendMessage = (Button) findViewById(R.id.btn_sendMessage);

        final TextView text_selectedData = (TextView) findViewById(R.id.text_selectedData);
        final TextView text_selectedType = (TextView) findViewById(R.id.text_selectedType);
        final EditText edit_phoneNumber = (EditText) findViewById(R.id.edit_phoneNumber);

        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_selectedType.setText("Location");
                text_selectedData.setText("현재위치");

            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_selectedType.setText("Sensors");
                text_selectedData.setText("센서값");

            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = "현재위치 + 센서값";

                Uri attachment
                        edit_phoneNumber.

                public void composeMmsMessage(String message, Uri attachment) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
                    intent.putExtra("sms_body", message);
                    intent.putExtra(Intent.EXTRA_STREAM, attachment);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }

            }
        });
    }
}
