package tz.co.comptech.m_safariproduction.Helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    private String PREF_FILE;
    private Context context;
    SharedPreferences.Editor editor;

    private SharedPreferences settings;
    public SharedPreferenceHelper(Context context, String PREF_FILE){
        this.context = context;
        this.PREF_FILE = PREF_FILE;
        settings = context.getSharedPreferences(PREF_FILE, 0);
    }

    public void editor(){
        editor = settings.edit();
    }

    public void apply(){
        editor.apply();
    }

    public void clear(){
        editor.clear();
        editor.apply();
    }
    /**
     * Set a string shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    public void setString(String key, String value){
        editor.putString(key, value);
    }

    /**
     * Set a integer shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    public void setInt(String key, int value){
        editor.putInt(key, value);
    }

    /**
     * Set a Boolean shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    public void setBoolean(String key, boolean value){
        editor.putBoolean(key, value);
    }

    /**
     * Get a string shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public String getString(String key, String defValue){
        return settings.getString(key, defValue);
    }

    /**
     * Get a integer shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public int getInt(String key, int defValue){
        return settings.getInt(key, defValue);
    }

    /**
     * Get a boolean shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public boolean geBoolean(String key, boolean defValue){
        return settings.getBoolean(key, defValue);
    }
}