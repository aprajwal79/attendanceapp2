package com.nitap.attendance;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;

public class PermissionsActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    boolean check(String permission) {
        return  checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean hasPermissions() {
        boolean locCoarse = check(Manifest.permission.ACCESS_COARSE_LOCATION);
        boolean locFine = check(Manifest.permission.ACCESS_FINE_LOCATION);
        boolean bt = check(Manifest.permission.BLUETOOTH);
        boolean btAdmin = check(Manifest.permission.BLUETOOTH_ADMIN);

        boolean btScan = true;
        boolean btConnect = true;
        boolean btAdvertise = true;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
             btScan = check(Manifest.permission.BLUETOOTH_SCAN);
            btConnect = check(Manifest.permission.BLUETOOTH_CONNECT);
            btAdvertise = check(Manifest.permission.BLUETOOTH_ADVERTISE);
        }
        boolean nearbyDevices = true;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
             nearbyDevices = check(Manifest.permission.NEARBY_WIFI_DEVICES);
        }



        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {
                    Manifest.permission.BLUETOOTH,
                    Manifest.permission.BLUETOOTH_ADMIN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_ADVERTISE,
                    Manifest.permission.NEARBY_WIFI_DEVICES,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_MEDIA_AUDIO,
                    Manifest.permission.READ_MEDIA_IMAGES,
                    Manifest.permission.READ_MEDIA_VIDEO,
                    Manifest.permission.CAMERA

            },0);

            boolean locStatus = true;
            try {
                if(Settings.Secure.getInt(this.getContentResolver(), Settings.Secure.LOCATION_MODE) != Settings.Secure.LOCATION_MODE_HIGH_ACCURACY) {
                    locStatus = false;
                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }
            } catch (Settings.SettingNotFoundException e) {
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
            if (hasPermissions() && locStatus) {
                startActivity(new Intent(this,AuthenticationActivity.class));
            }
        }



    }
}