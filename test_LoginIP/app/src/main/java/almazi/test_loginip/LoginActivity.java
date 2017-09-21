package almazi.test_loginip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class LoginActivity extends AppCompatActivity {

    //@BindView(R.id.userName)
    EditText userName;
    //@BindView(R.id.passWord)
    EditText passWord;
    //@BindView(R.id.textView)
    TextView textView;
    //@BindView(R.id.button)
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        userName = (EditText) findViewById(R.id.userName);
        passWord = (EditText) findViewById(R.id.passWord);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName = userName.getText().toString();
                String pWord = passWord.getText().toString();
                APICall apc = RetrofitApiClient.getClient().create(APICall.class);
                Call<ResponseBody> call = apc.sendUserData(new UserModel(uName, pWord));
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String na = response.toString();
                        Toast.makeText(getApplicationContext(),""+response.body(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

            }
        });



    }


}
