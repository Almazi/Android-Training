package almazi.gitex.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import almazi.gitex.Models.SearchResponseModel;
import almazi.gitex.NetworkClass.ApiInterface;
import almazi.gitex.NetworkClass.RetrofitApiClient;
import almazi.gitex.R;
import almazi.gitex.Utilities.MyPreference;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.search_text) EditText search_text;
    private ImageView searchLogo;
    private MyPreference myPreference;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //View and SharedPreference initialization
        initialization();
        //Load image from server
        Picasso.with(this)
                .load(myPreference.getData("logoUrl","")) //get image url from SharedPreference
                .placeholder(R.drawable.placeholder) //show before image loading from server
                .error(R.drawable.error_image) //show if any error occurred during image loading
                .into(searchLogo);
    }
    private void initialization() {
        myPreference = MyPreference.getPreferences(this);

        myPreference.setData("logoUrl","https://octodex.github.com/images/heisencat.png");

        searchLogo = (ImageView) findViewById(R.id.searchLogo);
    }

    @OnClick(R.id.search_button)
    public void searchButtonClicked(){
        query = search_text.getText().toString();
        myPreference.setData("query",query);
        startActivity(new Intent(getApplicationContext(), SearchResultActivity.class));
        finish();
    }

}
