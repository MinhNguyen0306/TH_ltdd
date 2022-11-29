package com.example.ktck_lan3_nguyenleminh_1911505310235;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button) findViewById(R.id.btnLoginMain);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenLoginActivity();
            }
        });
    }

    public void doOpenLoginActivity(){
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
        finish();
    }
}