package almazi.profilepotro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    @BindView(R.id.updateName)
    EditText nameUpdate;
    String name;

    @BindView(R.id.updatePhone)
    EditText phoneUpdate;
    String phone;

    @BindView(R.id.updateAddress)
    EditText addressUpdate;
    String address;

    private MyPreference myPreference = MyPreference.getPreferences(this);
    String email;
    String password;
    String userGuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        email = myPreference.getEmail();
        password = myPreference.getPassword();
        userGuid = myPreference.getUserGuid();

        Logger.d(myPreference.getEmail() + " " + myPreference.getPassword()
                + " " + myPreference.getUserGuid());
        updateProfile(userGuid);

    }
    public void updateProfile(String userGuid){
        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<ResponseModel> call = apiInterface.fetchUserInfo(userGuid);

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel responseModel = response.body();
                Logger.d("response:" + response.message());

                if(response.code() == 200){
                    Logger.d("response:" + response.message());
                    name = responseModel.getProfileModel().getName();
                    nameUpdate.setText(name);

                    phone = responseModel.getProfileModel().getPhone();
                    phoneUpdate.setText(phone);

                    address = responseModel.getProfileModel().getAddress();
                    addressUpdate.setText(address);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error: " + responseModel.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Logger.d("Failed: " + t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
    @OnClick(R.id.updateButton)
    void updateButtonClicked(){

        name = nameUpdate.getText().toString();
        phone = phoneUpdate.getText().toString();
        address = addressUpdate.getText().toString();

        ProfileData profileData = new ProfileData(name, phone, address);
        Authentication authentication = new Authentication(email, password, userGuid);
        UpdateProfileModel updateProfileModel = new UpdateProfileModel(profileData, authentication);

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<ResponseModel> call = apiInterface.updateInfo(updateProfileModel);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel responseModel = response.body();
                if(response.code() == 200){
                    if(response.isSuccessful()){
                        Logger.d("response:" + response.isSuccessful());
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        finish();
                    }
                    else {
                        Logger.d("response:" + response.isSuccessful());
                    }
                }
                else {
                    Logger.d("response:" + response.isSuccessful());

                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Logger.d("Failed: " + t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    @OnClick(R.id.loutButton)
    void loutButtonClicked(){
        myPreference.setUserGuid(null);
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

}
