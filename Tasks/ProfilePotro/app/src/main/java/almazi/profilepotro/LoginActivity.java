package almazi.profilepotro;

import android.content.Intent;
import android.nfc.cardemulation.HostNfcFService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
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

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.emailLogin)
    EditText emailLogin;

    @BindView(R.id.passwordLogin)
    EditText passwordLogin;

    @BindView(R.id.rememberMeCheck)
    CheckBox rememberMeCheck;

    private MyPreference myPreference;


    String email;
    String password;
    String userGuid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        myPreference = MyPreference.getPreferences(this);
        if(!myPreference.getUserGuid().isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        }
    }



    @OnClick(R.id.loginButton)
    void logInButtonClick(){

        myPreference = MyPreference.getPreferences(this);
        email = emailLogin.getText().toString();
        password = passwordLogin.getText().toString();

        User user = new User(email, password);

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<ResponseModel> call = apiInterface.loginToServer(user);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Logger.d("Raw Response: " + response.raw());

                if (response.code() == 200) {

                    ResponseModel responseModel = response.body();
                    Toast.makeText(getApplicationContext(), responseModel.getMessage(), Toast.LENGTH_LONG).show();
                    userGuid = responseModel.getUserGuid();
                    initialization();

                    if (responseModel.isSuccess()) { // user name and password is correct
                        Logger.d(myPreference.getEmail() + " " + myPreference.getPassword() + " " + myPreference.getUserGuid());

                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        finish(); // finish LoginActivity
                    }

                } else
                    Toast.makeText(getApplicationContext(), "Error: " + response.message(), Toast.LENGTH_LONG).show();

            }
            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Logger.d("Failed: " + t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
    private void initialization() {
        myPreference.setEmail(email);
        myPreference.setPassword(password);
        myPreference.setUserGuid(userGuid);

    }
    @OnClick(R.id.regButton)
    void regButtonClick(){
        Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
        startActivity(intent);
        finish();
    }
}
