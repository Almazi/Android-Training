package almazi.gitex.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by almazi on 9/20/17.
 */

public class Items implements Parcelable{

    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private int id;

    @SerializedName("avatar_url")
    private String avatar_url;

    @SerializedName("gravatar_id")
    private String gravatar_id;

    @SerializedName("url")
    private String url;

    @SerializedName("html_url")
    private String html_url;

    @SerializedName("followers_url")
    private String followers_url;

    @SerializedName("following_url")
    private String following_url;

    @SerializedName("repos_url")
    private String repos_url;

    @SerializedName("userDetails")
    private List<UserDetails> userDetails = null;

    public final static Parcelable.Creator<Items> CREATOR = new Creator<Items>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Items createFromParcel(Parcel in) {
            Items instance = new Items();
            instance.login = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((int) in.readValue((String.class.getClassLoader())));
            instance.avatar_url = ((String) in.readValue((String.class.getClassLoader())));
            instance.gravatar_id = ((String) in.readValue((Integer.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.html_url = ((String) in.readValue((String.class.getClassLoader())));
            instance.followers_url = ((String) in.readValue((String.class.getClassLoader())));
            instance.following_url = ((String) in.readValue((String.class.getClassLoader())));
            instance.repos_url = ((String) in.readValue((String.class.getClassLoader())));
            instance.userDetails = (List<UserDetails>) in.readValue((String.class.getClassLoader()));
            return instance;
        }

        public Items[] newArray(int size) {
            return (new Items[size]);
        }

    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public List<UserDetails> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(List<UserDetails> userDetails) {
        this.userDetails = userDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(login);
        parcel.writeInt(id);
        parcel.writeString(avatar_url);
        parcel.writeString(gravatar_id);
        parcel.writeString(url);
        parcel.writeString(html_url);
        parcel.writeString(followers_url);
        parcel.writeString(following_url);
        parcel.writeString(repos_url);
    }


}
