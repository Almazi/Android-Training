package almazi.profilepotro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by almazi on 9/12/17.
 */

public class UpdateProfileModel {
    @SerializedName("profileData")
    public ProfileData profileData;

    @SerializedName("authentication")
    public Authentication authentication;

    public UpdateProfileModel(ProfileData profileData, Authentication authentication) {
        this.profileData = profileData;
        this.authentication = authentication;
    }

    public UpdateProfileModel() {
    }

    public ProfileData getProfileData() {
        return profileData;
    }

    public void setProfileData(ProfileData profileData) {
        this.profileData = profileData;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}
