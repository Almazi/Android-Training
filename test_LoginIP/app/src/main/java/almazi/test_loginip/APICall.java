package almazi.test_loginip;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by almazi on 9/8/17.
 */

public interface APICall {

    @POST("login.php")
    Call<ResponseBody> sendUserData(@Body UserModel userModel);

}
