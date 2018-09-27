package com.example.nemo1.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ReceiverStateChanged receiverStateChanged; // khoi tao object cua class extend BroadcastReceiver.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        receiverStateChanged = new ReceiverStateChanged();

        //Khoi tao intentFilter de chua loai broadcast.
        IntentFilter actionPowerConnected = new IntentFilter();
        actionPowerConnected.addAction(Intent.ACTION_POWER_CONNECTED);

        //Dang ky broadcastReceive
        registerReceiver(receiverStateChanged,actionPowerConnected);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiverStateChanged);
    }
}
