package p.gpscheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;

/**
 * Created by P P on 16-May-17.
 */

public class GpsLocationReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
//        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
//
//            Toast.makeText(context, "in android.location.PROVIDERS_CHANGED",
//                    Toast.LENGTH_SHORT).show();
//            Intent pushIntent = new Intent(context, GpsLocationReceiver.class);
//            context.startService(pushIntent);
//        }



        final LocationManager manager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) )
            Toast.makeText(context, "GPS is disable!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "GPS is Enable!", Toast.LENGTH_SHORT).show();
    }

}
