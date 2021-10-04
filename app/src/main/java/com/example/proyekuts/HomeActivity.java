package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyekuts.SharedPreferences.Entity.User;
import com.example.proyekuts.SharedPreferences.Preferences.UserPreferences;

public class HomeActivity extends AppCompatActivity {
    Button btnlogout;
    private UserPreferences userPreferences;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnlogout = findViewById(R.id.btnlogout);
        userPreferences = new UserPreferences(HomeActivity.this);

        user = userPreferences.getUserLogin();

        checkLogin();

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPreferences.logout();
                Toast.makeText(HomeActivity.this, "Baiii baiii", Toast.LENGTH_LONG).show();
                checkLogin();
            }
        });
    }
    private void checkLogin() {
        /* this function will check if user login, akan memunculkan toast jika tidak redirect ke login activity */
        if(!userPreferences.checkLogin()) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        } else {
            Toast.makeText(HomeActivity.this, "Hey kamu sudah login !!!", Toast.LENGTH_LONG).show();
        }
    }
}