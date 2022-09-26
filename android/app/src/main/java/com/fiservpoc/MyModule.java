package com.fiservpoc;
import android.util.Log;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.fiserv.dps.mobile.sdk.bridge.controller.Bridge;
//import com.fiserv.dps.mobile.sdk.
//Implementing GenericTag for session timeout
public class MyModule extends ReactContextBaseJavaModule  {
    ReactApplicationContext context = getReactApplicationContext();
    public MyModule(@NonNull ReactApplicationContext reactContext) { super(reactContext);
    }
    @NonNull @Override public String getName() {
        return "MyModule";
    }
    Callback callback;
    @ReactMethod public void NavigateToZelle(String appName, String baseURL, String instId, String product, String ssoKey, ReadableMap parameters, ReadableMap pd, Callback callback){
        this.callback = callback;
//        Bridge.genericTag = this;

        Intent intent = new Intent(context, LaunchZelleActivity.class);

        if(intent.resolveActivity(context.getPackageManager()) != null){
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.d("Data from ui ======>", parameters.toHashMap()+" "+pd.toHashMap()); intent.putExtra("appName", appName);
            intent.putExtra("baseURL", baseURL);
            intent.putExtra("instId", instId);
            intent.putExtra("product", product);
            intent.putExtra("ssoKey", ssoKey);
            intent.putExtra("parameters", parameters.toHashMap());
            intent.putExtra("pd", pd.toHashMap());
            context.startActivity(intent);
        }

//        @Override public void sessionTag(@NonNull String s) {//override method for session timeout
//            if (!s.equals("")){ try {
//                callback.invoke(s); }catch (Exception e){
//                Log.e("ReactNative", "Caught Exception: " + e.getMessage()); }
//            } }
    }
}