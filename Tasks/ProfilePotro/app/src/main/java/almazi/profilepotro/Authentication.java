package almazi.profilepotro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by almazi on 9/12/17.
 */

public class Authentication {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("userGuid")
    private String userGuid;

    public Authentication() {
    }

    public Authentication(String email, String password, String userGuid) {
        this.email = email;
        this.password = password;
        this.userGuid = userGuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }
}
