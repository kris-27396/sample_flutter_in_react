package com.reactnativeapp;
import android.app.Activity;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import io.flutter.embedding.android.FlutterActivity;

public class AppFlutterModule extends ReactContextBaseJavaModule {
    ReactApplicationContext reactApplicationContext;
    AppFlutterModule(ReactApplicationContext context) {
        super(context);
        reactApplicationContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "AppFlutterModule";
    }

    @ReactMethod
    public void startFlutterActivity(String stringArgument, int numberArgument, Callback callback) {
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        // we can pass arguments to the Intent
        currentActivity.startActivity(
                FlutterActivity.createDefaultIntent(currentActivity)
        );
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
