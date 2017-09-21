package almazi.profilepotro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by almazi on 9/12/17.
 */

public class ResponseModel {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("userGuid")
    private String userGuid;

    @SerializedName("profile")
    public ProfileModel profileModel;
    public ResponseModel() {
    }
    public ResponseModel(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseModel(boolean success, String message, ProfileModel profileModel) {
        this.success = success;
        this.message = message;
        this.profileModel = profileModel;
    }

    public ResponseModel(boolean success, String message, String userGuid, ProfileModel profileModel) {
        this.success = success;
        this.message = message;
        this.userGuid = userGuid;
        this.profileModel = profileModel;
    }
    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }


}
