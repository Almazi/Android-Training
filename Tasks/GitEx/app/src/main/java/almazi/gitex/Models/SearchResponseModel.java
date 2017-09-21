package almazi.gitex.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by almazi on 9/20/17.
 */

public class SearchResponseModel {
    @SerializedName("total_count")
    private int total_count;
    @SerializedName("incomplete_results")
    private boolean incomplete_results;
    @SerializedName("items")
    private Items items;


    public SearchResponseModel() {
    }

    public SearchResponseModel(int total_count, boolean incomplete_results, Items items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
