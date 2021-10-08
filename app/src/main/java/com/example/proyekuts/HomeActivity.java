package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

        changeFragment(new FragmentHome());
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment,fragment)
                .commit();
    }
}