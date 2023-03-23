package com.nitap.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toast.makeText(this, "WELCOME", Toast.LENGTH_SHORT).show();
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