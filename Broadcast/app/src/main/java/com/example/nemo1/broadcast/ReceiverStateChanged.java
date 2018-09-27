package com.example.nemo1.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReceiverStateChanged extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intertService = new Intent(context,ToastService.class);
        context.startService(intertService);
    }
}
