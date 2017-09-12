package almazi.profilepotro;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.profileName)
    TextView nameProfile;

    @BindView(R.id.profileEmail)
    TextView emailProfile;

    @BindView(R.id.profilePhone)
    TextView phoneProfile;

    @BindView(R.id.profileAddress)
    TextView addressProfile;

    String name, email, phone, address;
    private MyPreference myPreference = MyPreference.getPreferences(this);
    String userGuid = myPreference.getUserGuid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        userGuid = myPreference.getUserGuid();

        Logger.d(myPreference.getEmail() + " " + myPreference.getPassword()
                + " " + myPreference.getUserGuid());

        getUserInfo(userGuid);
    }
    private void getUserInfo(String userGuid){

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
                    nameProfile.setText("Name: "+name);

                    email = responseModel.getProfileModel().getEmail();
                    emailProfile.setText("Email: "+ responseModel.getProfileModel().getEmail());

                    phone = responseModel.getProfileModel().getPhone();
                    phoneProfile.setText("Phone: "+phone);

                    address = responseModel.getProfileModel().getAddress();
                    addressProfile.setText("Address: "+address);
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

    @OnClick(R.id.editButton)
    void editButtonClicked(){
        Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("phone", phone);
        intent.putExtra("address", address);
        startActivity(intent);
        finish(); // finish
    }

    @OnClick(R.id.logoutButton)
    void logoutButtonClicked(){
        myPreference.setUserGuid(null);
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}
