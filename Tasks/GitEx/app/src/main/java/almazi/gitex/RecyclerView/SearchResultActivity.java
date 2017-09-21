package almazi.gitex.RecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import almazi.gitex.Models.SearchResponseModel;
import almazi.gitex.NetworkClass.ApiInterface;
import almazi.gitex.NetworkClass.RetrofitApiClient;
import almazi.gitex.R;
import almazi.gitex.Utilities.MyPreference;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {
    private String query;
    private MyPreference myPreference;
    @BindView(R.id.searchResult)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        myPreference = myPreference.getPreferences(this);
        ButterKnife.bind(this);


        query = myPreference.getData("query","");

        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d(query);
        searchResults();
    }
    private void searchResults(){
        Logger.d(query);

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<SearchResponseModel> call = apiInterface.getSearchResults(query);
        call.enqueue(new Callback<SearchResponseModel>() {
            @Override
            public void onResponse(Call<SearchResponseModel> call, Response<SearchResponseModel> response) {
                Logger.d(query);

                Logger.d("Raw http data: "+response.raw());
                if (response.code() == 200) {
                    SearchResponseModel searchResponseModel = response.body();
                    Gson gson = new Gson();
                    String json = gson.toJson(searchResponseModel, SearchResponseModel.class);
                    Logger.d(json);

                    if(searchResponseModel!=null) {
                        Logger.d(searchResponseModel.getTotal_count());
                        //recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), searchResponseModel.getItems());
                        Logger.d(searchResponseModel.getItems().getLogin());
                        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                        //recyclerView.setAdapter(recyclerViewAdapter);
                    } else
                        Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();

                } else
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SearchResponseModel> call, Throwable t) {
                Logger.d("Failed: " + t.getMessage());

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
