package almazi.gitex.ShowGithubDetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import almazi.gitex.Models.Items;
import almazi.gitex.R;
import almazi.gitex.Utilities.Config;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsActivity extends AppCompatActivity {
/*
    @BindView(R.id.userImageView)
    ImageView userImageView;
    @BindView(R.id.userFullName)
    TextView userFullName;
    @BindView(R.id.loginName)
    TextView loginName;
    @BindView(R.id.companyName)
    TextView companyName;
    @BindView(R.id.emailText)
    TextView emailText;
    @BindView(R.id.blogText)
    TextView blogText;
    @BindView(R.id.followerText)
    TextView followerText;
    @BindView(R.id.reposText)
    TextView reposText;
    @BindView(R.id.bioText)
    TextView bioText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Items items = getIntent().getParcelableExtra(Config.ITEM);


        Gson gson = new Gson();
        String movieJson = gson.toJson(items, Items.class);
        Logger.json(movieJson);
        //End of log message print

        Picasso.with(this)
                .load(items.getAvatar_url())
                .into(userImageView);

        userFullName.setText(items.getUserDetails().getName());
        companyName.setText(items.getUserDetails().getCompany());
        loginName.setText(items.getUserDetails().getLogin());
        emailText.setText(items.getUserDetails().getEmail());
        blogText.setText(items.getUserDetails().getBio());
        followerText.setText(items.getUserDetails().getFollowers());
        reposText.setText(items.getUserDetails().getRepos());
        bioText.setText(items.getUserDetails().getCompany());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
}
