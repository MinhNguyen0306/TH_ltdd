package com.example.thtuan3_nguyenleminh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    Button switchRegis;
    EditText txtUserName;
    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        switchRegis = (Button) findViewById(R.id.switchSignup);

        switchRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToRegis();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenProfileActivity();
            }
        });
    }

    public void doOpenProfileActivity(){
        Intent intent = new Intent(LoginActivity.this, ListActivity.class);
        startActivity(intent);
    }

    public void onClickGoToRegis(){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}