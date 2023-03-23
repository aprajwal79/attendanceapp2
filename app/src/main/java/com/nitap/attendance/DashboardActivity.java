package com.nitap.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void takeAttendance(View view) {
        loadDetails();
        setConfigurations();
        startActivity(new Intent(this,FaceRecognitionActivity.class));
    }

    private void setConfigurations() {
    }

    private void loadDetails() {
    }
}