package com.example.ex3;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class QuotesService extends Service {
    private final int LOOP_TIME_MINUTES = 5;

    public QuotesService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        long loopTimeInMill = LOOP_TIME_MINUTES * 60 * 1000;

        Intent myIntent = new Intent(this, AlarmNotificationReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                loopTimeInMill,
                pendingIntent
        );

        Toast.makeText( getApplicationContext(), "Started Quotes Service", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText( getApplicationContext(), "Stopped Quotes Service", Toast.LENGTH_SHORT).show();
    }
}