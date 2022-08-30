package com.example.thtuan2_nguyenleminh_1911505310235;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.app.Notification;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final EditText height = (EditText) findViewById(R.id.txtHeight);
        TextView result = (TextView) findViewById(R.id.txtResult);
        final Button calculate = (Button) findViewById(R.id.btnCal);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(weight.getText().toString() == "" || height.getText().toString() == ""){
                    result.setText("Missing Value");
                }else {
                    double h = Double.parseDouble(height.getText().toString());
                    double w = Double.parseDouble(weight.getText().toString());
                    double bmi = Math.round(w / (Math.pow(h, 2)));
                    String message;
                    if (bmi < 18)
                        message = "Nguoi gay";
                    else if(bmi >= 18 && bmi <= 24.9)
                        message = "nguoi binh thuong";
                    else if(bmi >= 25 && bmi <= 29.9)
                        message = "nguoi beo phi do I";
                    else if(bmi >= 30 && bmi <= 34.9)
                        message = "nguoi beo phi do II";
                    else
                        message = "nguoi beo phi do III";
                    result.setText("BMI: " + String.valueOf(bmi) + "=>" + message);

                }
            }
        });
    }
}