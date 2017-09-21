package almazi.gitex.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreference {

    private static MyPreference myPreference;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private MyPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("user_portal", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static MyPreference getPreferences(Context context) {
        if (myPreference == null)
            myPreference = new MyPreference(context);

        return myPreference;
    }

    public void setData(String Key, String Value) {
        editor.putString(Key, Value);
        editor.apply();
        editor.commit();
    }

    public String getData(String Key, String Fallback) {
        return sharedPreferences.getString(Key, Fallback);
    }

    public void setEmpty() {
        editor.clear();
        editor.commit();
    }
}