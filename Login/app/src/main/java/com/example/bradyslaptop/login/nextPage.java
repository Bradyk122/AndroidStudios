package com.example.bradyslaptop.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class nextPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        Intent nextPage = getIntent();
        String PASSWORD = nextPage.getStringExtra(Login.NEXT);
        TextView show = findViewById(R.id.textView);
        show.setText(PASSWORD);
    }

}
