package com.example.becia.beatapiotrowska;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesIfLogged {

    private static final String PREFERENCES_NAME = "ifLogged";
    private static final String PREFERENCES_IF_LOGGED = "loggingIn";
    public SharedPreferences preferences;
    private final Context context;

    private static SharedPreferencesIfLogged instance = null;

    SharedPreferencesIfLogged(Context context) {
        if (null == instance){
            SharedPreferencesIfLogged.instance = this;
        }
        else{
            throw new ExceptionInInitializerError("Instance class SharedPreferencesIfLogged already exists");
        }
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
    }

    public static SharedPreferencesIfLogged getInstance() {
        return SharedPreferencesIfLogged.instance;
    }

    public void saveData(boolean ifLoggin) {
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        //String editTextData = "";
        preferencesEditor.putBoolean(PREFERENCES_IF_LOGGED, ifLoggin);
        preferencesEditor.commit();
    }

    public boolean restoreData() {

        boolean ifLoggin = false;
        //if ()
        return preferences.getBoolean(PREFERENCES_IF_LOGGED, ifLoggin);
    }
}
