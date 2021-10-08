package com.example.proyekuts;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyekuts.SharedPreferences.Entity.User;
import com.example.proyekuts.SharedPreferences.Preferences.UserPreferences;

public class FragmentHome extends Fragment {

    // TODO: Rename and change types of parameters
    private User user;
    private UserPreferences userPreferences;


    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userPreferences = new UserPreferences(getContext());

        user = userPreferences.getUserLogin();

        checkLogin();
    }

    private void checkLogin() {
        /* this function will check if user login, akan memunculkan toast jika tidak redirect ke login activity */
        if(!userPreferences.checkLogin()) {
            startActivity(new Intent(getContext(), LoginActivity.class));
        } else {
            Toast.makeText(getContext(), "Selamat Datang Kembali :)", Toast.LENGTH_LONG).show();
        }
    }
}