/**
 *
 */
package com.himanshu.frameworkdemo.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Himanshu Patel
 */
public class ConnectionDetector {

    private Context context;

    public ConnectionDetector(Context context) {
        this.context = context;
    }

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (NetworkInfo anInfo : info) {
                    if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
//                        if (isURLReachable()) {
                        return true;
//                        } else {
//                            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
//                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isURLReachable() {
        try {
            URL url = new URL("http://192.168.0.96/MilAppWebApi/");   // Change to "http://google.com" for www  test.
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10 * 1000);          // 10 s.
            httpURLConnection.connect();
            // 200 = "OK" code (http connection is fine).
            return httpURLConnection.getResponseCode() == 200;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
