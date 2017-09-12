package almazi.profilepotro;

import android.content.Intent;
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
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class RegistrationActivity extends AppCompatActivity {
    @BindView(R.id.name)
    EditText nameActv;

    @BindView(R.id.email)
    EditText emailActv;

    @BindView(R.id.password)
    EditText passwordActv;

    @BindView(R.id.phone)
    EditText phoneActv;

    @BindView(R.id.address)
    EditText addressActv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        //View and SharedPreference initialization
    }


    @OnClick(R.id.registrationButton)
    void submitRegistration(){
        String name = nameActv.getText().toString();
        String email = emailActv.getText().toString();
        String password = passwordActv.getText().toString();
        String phone = phoneActv.getText().toString();
        String address = addressActv.getText().toString();

        //User's object
        User user = new User(name, email, password, phone, address);

        //Apiinterface object to call retrofit client
        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

        //Call object to send the user data we got from User class to ApiInterface class
        Call<ResponseModel> call = apiInterface.registration(user);

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Logger.d("Raw response: " + response.raw());
                if (response.code() == 200) {
                    ResponseModel responseModel = response.body();
                    Toast.makeText(getApplicationContext(),responseModel.getMessage(), Toast.LENGTH_LONG).show();
                    if(responseModel.isSuccess()) { // registration successful
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish(); // finish Registration activity
                    }

                } else {
                    ResponseModel responseModel = response.body();
                    Toast.makeText(getApplicationContext(), responseModel.getMessage(), Toast.LENGTH_LONG).show();


                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Logger.d("Failed:" + t.toString());
            }
        });

    }

    @OnClick(R.id.logButton)
    void logButtonClicked(){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }


}
