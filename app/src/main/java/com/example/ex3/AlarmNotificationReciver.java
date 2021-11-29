package com.example.ex3;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlarmNotificationReciver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Quotes quotes = new Quotes();
        String randQuote = quotes.getRandomQuote();

        NotificationCompat.Builder builder = new NotificationCompat.Builder( context, "quoteNotification" )
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Random Quote:")
                .setContentText(randQuote)
                .setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());

    }
}
