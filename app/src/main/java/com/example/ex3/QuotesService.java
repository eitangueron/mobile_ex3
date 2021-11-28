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
    public QuotesService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int loopTimeInSecs = 3;      // every 3 seconds
        long loopTimeInMill = 1000 * loopTimeInSecs;

        Toast.makeText( getApplicationContext(), "Started Quotes Service", Toast.LENGTH_SHORT).show();

        AlarmNotificationReciver alarmNotificationReciver = new AlarmNotificationReciver();
        Intent myIntent = new Intent(this, AlarmNotificationReciver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                loopTimeInMill,
                pendingIntent
        );

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText( getApplicationContext(), "Stopped Quotes Service", Toast.LENGTH_SHORT).show();
    }
}