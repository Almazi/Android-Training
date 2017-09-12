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
    public String userGuid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    @OnClick(R.id.loginButton)
    void logInButtonClick(){
        String email = emailLogin.getText().toString();
        String password = passwordLogin.getText().toString();
        User user = new User(email, password);

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<ResponseModel> call = apiInterface.loginToServer(user);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Logger.d("Raw Response: " + response.raw());

                if(response.code()==200){

                    ResponseModel responseModel = response.body();
                    Toast.makeText(getApplicationContext(), responseModel.getMessage(), Toast.LENGTH_LONG).show();
                    userGuid = responseModel.getUserGuid();
                    if(responseModel.isSuccess()) { // user name and password is correct
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("userGuid",userGuid);
                        startActivity(intent);
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
        if(rememberMeCheck.isChecked()) initialization(email, password, userGuid);

    }

    private void initialization(String email, String password, String userGuid) {
        myPreference = MyPreference.getPreferences(this);
        myPreference.setEmail(email);
        myPreference.setPassword(password);
        myPreference.setUserGuid(userGuid);

    }
}
