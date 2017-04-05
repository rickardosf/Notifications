package br.com.fiap.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager notificationManager
                = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

        notificationBuilder.setContentTitle("Titulo da Notificação");
        notificationBuilder.setContentText("Aqui vai a mensagem");
        notificationBuilder.setSmallIcon(R.drawable.icon);
        notificationBuilder.setVibrate(new long[]{100, 500, 100, 250, 100, 500});
        notificationBuilder.setOngoing(false);
        notificationBuilder.setContentIntent(PendingIntent.getActivity(this, 100,
                new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));

        notificationManager.notify(100, notificationBuilder.build());
    }
}
