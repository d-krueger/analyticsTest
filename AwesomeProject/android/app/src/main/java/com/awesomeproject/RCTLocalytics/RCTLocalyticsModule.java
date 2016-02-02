package com.awesomeproject.RCTLocalytics;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.localytics.android.Localytics;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by david on 25.01.16.
 */
public class RCTLocalyticsModule extends ReactContextBaseJavaModule {

    public RCTLocalyticsModule(ReactApplicationContext reactContext){
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Localytics";
    }

    @ReactMethod
    public void tagEvent(String eventName) {
        Localytics.tagEvent(eventName);
    }

    @ReactMethod
    public void tagEventWithAttr(String eventName, ReadableMap attributes) {
        Map<String, String> values = recursivelyDeconstructReadableMap(attributes);
        Localytics.tagEvent(eventName, values);
    }

    @ReactMethod
    public void tagRevenueEvent(String eventName, ReadableMap attributes, Integer customerValueIncrease ) {
        Map<String, String> values = recursivelyDeconstructReadableMap(attributes);
        Localytics.tagEvent(eventName, values, customerValueIncrease);

    }

    @ReactMethod
    public void tagScreen(String screenName) {
        Localytics.tagScreen(screenName);
    }

    @ReactMethod
    public void triggerInAppMessage(String messageName) {
        Localytics.triggerInAppMessage(messageName);
    }

    @ReactMethod
    public void setCustomerId(String uid) {
            Localytics.setCustomerId(uid);
    }


    private Map<String, String> recursivelyDeconstructReadableMap(ReadableMap readableMap) {
        ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
        Map<String, String> deconstructedMap = new HashMap<>();
        while (iterator.hasNextKey()) {
            String key = iterator.nextKey();
            ReadableType type = readableMap.getType(key);
            switch (type) {
                case Null:
                    deconstructedMap.put(key, null);
                    break;
                case String:
                    deconstructedMap.put(key, readableMap.getString(key));
                    break;
                case Boolean:
                    deconstructedMap.put(key, String.valueOf(readableMap.getBoolean(key)));
                    break;
                case Number:
                    deconstructedMap.put(key, String.valueOf(readableMap.getDouble(key)));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object with key: " + key + "." + type);
            }

        }
        return deconstructedMap;
    }
}
