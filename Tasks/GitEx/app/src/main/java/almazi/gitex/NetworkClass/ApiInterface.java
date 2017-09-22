package almazi.gitex.NetworkClass;


import almazi.gitex.Models.SearchResponseModel;
import almazi.gitex.Models.UserDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search/users")
    Call<SearchResponseModel> getSearchResults(@Query("q") String query);

    @GET("users/{user_id}")
    Call<UserDetails> getUserDetails(@Path("user_id") String user_id);

    //Observable<SearchResponseModel> getSearchResults(@Query("q") String query, @Query("page") int page, @Query("per_page") int perPage);



}