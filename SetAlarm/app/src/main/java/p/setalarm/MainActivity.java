package p.setalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar =  Calendar.getInstance();
        Toast.makeText(MainActivity.this,calendar+"",Toast.LENGTH_LONG).show();
        //calendar.set(2014,Calendar.getInstance().get(Calendar.MONTH),Calendar.SUNDAY , 8, 00, 00);
       calendar.set(0,0,0,13,00,00);
        long when = calendar.getTimeInMillis();         // notification time


        Log.d("time", when+" ");
        Intent intentAlarm = new Intent(this, AlarmReceiver.class);

// create the object
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        //set the alarm for particular time
          alarmManager.set(AlarmManager.RTC_WAKEUP,when, PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
