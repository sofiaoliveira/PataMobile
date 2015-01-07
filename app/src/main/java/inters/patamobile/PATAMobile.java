package inters.patamobile;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class PATAMobile extends Application{

    public static String ENDPOINT = "http://patawebservice.apphb.com/Pata.svc/rest";
    private static RequestQueue requestQueue;
    public static String token;



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
