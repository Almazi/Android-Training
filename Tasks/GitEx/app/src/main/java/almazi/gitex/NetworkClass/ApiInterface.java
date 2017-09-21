package almazi.gitex.NetworkClass;


import android.database.Observable;

import almazi.gitex.Models.SearchResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search/users")
    Call<SearchResponseModel> getSearchResults(@Query("q") String query);
    //Observable<SearchResponseModel> getSearchResults(@Query("q") String query, @Query("page") int page, @Query("per_page") int perPage);



}