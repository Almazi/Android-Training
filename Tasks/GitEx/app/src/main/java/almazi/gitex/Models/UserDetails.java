package almazi.gitex.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by almazi on 9/20/17.
 */

public class UserDetails {

    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("company")
    private String company;

    @SerializedName("bio")
    private String bio;

    @SerializedName("blog")
    private String blog;

    @SerializedName("location")
    private String location;

    @SerializedName("avatar_url")
    private String avatar_url;

    @SerializedName("gravatar_id")
    private String gravatar_id;

    @SerializedName("url")
    private String url;

    @SerializedName("html_url")
    private String html_url;

    @SerializedName("followers")
    private int followers;

    @SerializedName("following")
    private int following;

    @SerializedName("repos")
    private int repos;

    public UserDetails() {
    }

    public UserDetails(String name, String email, String company, String bio,
                       String blog, int followers, int following, int repos) {
        this.name = name;
        this.email = email;
        this.company = company;
        this.bio = bio;
        this.blog = blog;
        this.followers = followers;
        this.following = following;
        this.repos = repos;
    }

    public UserDetails(String login, int id, String name, String email, String company,
                       String bio, String blog, String location, String avatar_url,
                       String gravatar_id, String url, String html_url, int followers,
                       int following, int repos) {
        this.login = login;
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
        this.bio = bio;
        this.blog = blog;
        this.location = location;
        this.avatar_url = avatar_url;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.html_url = html_url;
        this.followers = followers;
        this.following = following;
        this.repos = repos;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getRepos() {
        return repos;
    }

    public void setRepos(int repos) {
        this.repos = repos;
    }
}
