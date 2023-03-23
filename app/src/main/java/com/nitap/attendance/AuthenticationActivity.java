package com.nitap.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import java.io.File;
import java.nio.file.Files;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LOGIN_STATUS","SUCCESS");
        editor.apply();
        File[] files = getFilesDir().listFiles();
       // File mycsv = new File(getFilesDir());
        boolean hasRegistered = true;
        
        if (hasRegistered) {
            loadDetails();
        } else {
            register();
        }


    }

    private void register() {
    }

    private void loadDetails() {
    }
}