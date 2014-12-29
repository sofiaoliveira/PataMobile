package inters.patamobile;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class PATAMobile extends Application{

    public static String ENDPOINT = "http://localhost:41250/Pata.svc";
    private static RequestQueue requestQueue;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static RequestQueue getRequestQueue(Context context){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
}
