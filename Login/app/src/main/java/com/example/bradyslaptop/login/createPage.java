package com.example.bradyslaptop.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class createPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_page);
    }
    public void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File Write Failed: " + e.toString());
        }
    }
    public void save(View view){
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String combined = user + " " + pass;
        writeToFile(combined, this);
        Intent back = new Intent(this, Login.class);
        startActivity(back);
    }
}
