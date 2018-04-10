package com.example.bradyslaptop.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private TextView attempt;
    private Button login_button;
    private String UnP = "User Admin";
    private String USERNAME = "";
    private String PASSWORD = "";
    private String USERandPASS = "";
    int attempt_counter=5;
    public static final String NEXT = "com.example.bradyslaptop.login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void LoginButton(View view){
        username = (EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        attempt = (TextView)findViewById(R.id.textView_attempt);
        login_button = (Button)findViewById(R.id.login_button);

        Intent nextPage = new Intent(this, nextPage.class);
        USERNAME = username.getText().toString();
        PASSWORD = password.getText().toString();
        USERandPASS= USERNAME + " " + PASSWORD;
        if (USERandPASS.equals(UnP)){
            Toast.makeText(Login.this, "You got it boss!", Toast.LENGTH_SHORT).show();
            nextPage.putExtra(NEXT,USERandPASS);
            startActivity(nextPage);
        }
        else {
            Toast.makeText(Login.this, "Not quite", Toast.LENGTH_SHORT).show();
            attempt_counter--;
            if (attempt_counter==0){
                login_button.setEnabled(false);
            }
        }
    }
    public void makeAccount(View view){
        Intent createPage = new Intent(this, createPage.class);
        startActivity(createPage);
    }
}