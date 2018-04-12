package jp.bascule.soundar.soundar_gps;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

/**
 * Created by moriyukihiro on 2018/04/12.
 */

public class PermissionManager {
    private static final int REQUEST_PERMISSION = 10;

    public static boolean checkPermision(Activity activity){
        if(Build.VERSION.SDK_INT >= 23){
            if (ActivityCompat.checkSelfPermission(activity,
                    Manifest.permission.ACCESS_FINE_LOCATION)==
                    PackageManager.PERMISSION_GRANTED){
                return true;
            }
            else{
                return requestLocationPermission(activity);
            }
        }
        return true;
    }

    private static boolean requestLocationPermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSION);
            return true;

        } else {
            Toast toast = Toast.makeText(activity,
                    R.string.permission_warning, Toast.LENGTH_SHORT);
            toast.show();

            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},
                    REQUEST_PERMISSION);
            return false;
        }
    }
}
