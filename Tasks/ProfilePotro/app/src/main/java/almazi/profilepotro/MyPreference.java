package almazi.profilepotro;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreference {

    public static final String Email = "email";
    public static final String Password = "password";
    public static final String UserGuid = "userGuid";

    private static MyPreference myPreference;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private MyPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("my_sharedpreference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static MyPreference getPreferences(Context context) {
        if (myPreference == null)
            myPreference = new MyPreference(context);

        return myPreference;
    }


    public void setEmail(String email) {
        editor.putString(Email, email);
        editor.apply();
        editor.commit();
    }
    public void setPassword(String password) {
        editor.putString(Password, password);
        editor.apply();
        editor.commit();
    }
    public void setUserGuid(String userGuid) {
        editor.putString(UserGuid, userGuid);
        editor.apply();
        editor.commit();
    }

    public  String getEmail() { return sharedPreferences.getString(Email, ""); }

    public  String getPassword() {
        return sharedPreferences.getString(Password, "");
    }

    public  String getUserGuid() {
        return sharedPreferences.getString(UserGuid, "");
    }


}