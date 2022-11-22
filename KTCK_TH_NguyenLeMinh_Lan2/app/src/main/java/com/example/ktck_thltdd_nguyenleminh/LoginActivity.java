package com.example.ktck_thltdd_nguyenleminh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUserName;
    private EditText txtPass;
    private Button btnLogin;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUserName = (EditText) findViewById(R.id.email_login);
        txtPass = (EditText) findViewById(R.id.pass_login);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            txtUserName.setText(loginPreferences.getString("username", ""));
            txtPass.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                authenticateUser();
            }
        });
    }


    public void authenticateUser(){
        if(!validateEmail() || !validatePassword()){
            return;
        }

        String name = txtUserName.getText().toString();
        String pass = txtPass.getText().toString();

        if (saveLoginCheckBox.isChecked()) {
            loginPrefsEditor.putBoolean("saveLogin", true);
            loginPrefsEditor.putString("username", name);
            loginPrefsEditor.putString("password", pass);
            loginPrefsEditor.commit();
        } else {
            loginPrefsEditor.clear();
            loginPrefsEditor.commit();
        }

        if(name.equals("minh1@gmail.com") && pass.equals("1234")){
            onListActivity();
        }else {
            Toast.makeText(this, "Sai tk hoac mat khau!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validateEmail(){
        String v_email = txtUserName.getText().toString();
        //Check if email empty
        if(v_email.isEmpty()){
            txtUserName.setError("Email can not be empty!");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(v_email).matches()){
            txtUserName.setError("Please enter a valid email");
            return false;
        }else {
            txtUserName.setError(null);
            return true;
        }
    }

    //Xac thuc field password
    public boolean validatePassword(){
        String v_pass = txtPass.getText().toString();
        if(v_pass.isEmpty()){
            txtPass.setError("Password can not be empty");
            return false;
        }else{
            txtPass.setError(null);
            return true;
        }
    }

    public void onListActivity() {
        Intent intent = new Intent(LoginActivity.this, ListActivity.class);
        startActivity(intent);
        finish();
    }
}