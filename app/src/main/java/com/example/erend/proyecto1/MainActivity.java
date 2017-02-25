package com.example.erend.proyecto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.usernameEditText);
        password=(EditText)findViewById(R.id.passworEditText);
        Button login= (Button)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passValidation()){
                    checkCredentials();
                }

            }
        });

    }

    private boolean checkCredentials() {
        boolean passCredentials=true;
        boolean rightCredentials=true;
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        if (usernameText.equalsIgnoreCase("ere")){
            if (passwordText.equalsIgnoreCase("admin")){
                Toast.makeText(getApplicationContext(),"Credenciales correctas!!", Toast.LENGTH_LONG).show();
            }else {
                password.setError("Password incorrecto");
                rightCredentials = false;
            }
        }
        return passCredentials;
    }

    private boolean passValidation() {
        boolean passValdation = true;
        username.setError(null);
        password.setError(null);
        String usernameText = username.getText().toString();
        if (usernameText.length()==0) {
            username.setError("Username no puede estar vacío");
            passValdation = false;
        }
        String passwordText = password.getText().toString();
        if (passwordText.length()==0) {
            password.setError("Username no puede estar vacío");
            passValdation = false;
        }
        return passValdation;
    }
}
