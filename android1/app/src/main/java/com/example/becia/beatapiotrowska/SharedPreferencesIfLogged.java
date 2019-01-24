package com.example.becia.beatapiotrowska;

import android.content.SharedPreferences;

public class SharedPreferencesIfLogged {

    private static final String PREFERENCES_NAME = "ifLogged";
    private static final String PREFERENCES_IF_LOGGED = "loggingIn";
    private SharedPreferences preferences;

    private static SharedPreferencesIfLogged instance = null;

    SharedPreferencesIfLogged() {
        if (null == instance){
            SharedPreferencesIfLogged.instance = this;
        }
        else{
            throw new ExceptionInInitializerError("Instance class SharedPreferencesIfLogged already exists");
        }
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
}
