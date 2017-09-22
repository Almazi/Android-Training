package almazi.gitex.RecyclerView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import java.util.List;

import almazi.gitex.Models.Items;
import almazi.gitex.Models.UserDetails;
import almazi.gitex.NetworkClass.ApiInterface;
import almazi.gitex.NetworkClass.RetrofitApiClient;
import almazi.gitex.R;
import almazi.gitex.Utilities.Config;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    private Context context;
    @BindView(R.id.userImageView)
    ImageView userImageView;
    @BindView(R.id.fullNameTextView)
    TextView fullNameTextView;
    @BindView(R.id.userNameTextView)
    TextView userNameTextView;
    @BindView(R.id.companyNameTextView)
    TextView companyNameTextView;
    @BindView(R.id.emailTextView)
    TextView emailTextView;
    @BindView(R.id.blogTextView)
    TextView blogTextView;
    @BindView(R.id.followerTextView)
    TextView followerTextView;
    @BindView(R.id.reposTextView)
    TextView reposTextView;
    @BindView(R.id.bioTextView)
    TextView bioTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        String username = getIntent().getStringExtra("username");

        showDetails(username);
    }
    private void showDetails(String username){

        Logger.d(username);
        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<UserDetails> call = apiInterface.getUserDetails(username);
        call.enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(@Nullable Call<UserDetails> call, @Nullable Response<UserDetails> response) {
                if(response.code() == 200){
                    UserDetails userDetails = response.body();
                    Picasso.with(context)
                            .load(userDetails.getAvatar_url())
                            .into(userImageView);
                    fullNameTextView.setText(userDetails.getName());
                    Logger.d(userDetails.getName());
                    userNameTextView.setText(userDetails.getLogin());
                    companyNameTextView.setText(userDetails.getCompany());
                    emailTextView.setText(userDetails.getEmail());
                    blogTextView.setText(userDetails.getBlog());
                    followerTextView.setText(userDetails.getFollowers()+" ");
                    reposTextView.setText(userDetails.getRepos()+" ");
                    bioTextView.setText(userDetails.getBio());

                }
            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {

            }
        });

    }
}
