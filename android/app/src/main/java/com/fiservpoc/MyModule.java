package com.fiservpoc;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class MyModule extends ReactContextBaseJavaModule {

    ReactApplicationContext context = getReactApplicationContext();

    public MyModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull @Override public String getName() {
        return "MyModule";
    }

    @ReactMethod public void NavigateToZelle(String appName, String baseURL, String instId, String product, String ssoKey)
        {
            final Intent intent = new Intent(context, LaunchZelleActivity.class);
            if(intent.resolveActivity(context.getPackageManager()) != null){
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Log.d("Data from ui ======>", appName+" "+baseURL);
                intent.putExtra("appName", appName);
                intent.putExtra("baseURL", baseURL);
                intent.putExtra("instId", instId);
                intent.putExtra("product", product);
                intent.putExtra("ssoKey", ssoKey);
                context.startActivity(intent);
        }
    }
}