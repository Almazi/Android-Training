package almazi.profilepotro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by almazi on 9/12/17.
 */

public interface ApiInterface {
    @POST("user")
    Call<ResponseModel> registration(@Body User user);

    @POST("user/login")
    Call<ResponseModel> loginToServer(@Body User user);

    @GET("user/{userGuid}")
    Call<ResponseModel> fetchUserInfo(@Path("userGuid") String userGuid);


}
