package almazi.test_loginip;

import com.google.gson.annotations.SerializedName;

/**
 * Created by almazi on 9/8/17.
 */

public class UserModel {

    @SerializedName("user_name")
    private String userName;
    @SerializedName("password")
    private String password;

    public UserModel() {
    }

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
