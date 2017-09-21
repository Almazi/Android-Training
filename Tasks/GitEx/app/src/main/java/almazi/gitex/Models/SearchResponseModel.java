package almazi.gitex.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by almazi on 9/20/17.
 */

public class SearchResponseModel implements Parcelable {
    @SerializedName("total_count")
    private int total_count;
    @SerializedName("incomplete_results")
    private boolean incomplete_results;
    @SerializedName("items")
    private List<Items> items = null;
    public final static Creator<SearchResponseModel> CREATOR = new Creator<SearchResponseModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchResponseModel createFromParcel(Parcel in) {
            SearchResponseModel instance = new SearchResponseModel();
            instance.incomplete_results = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.total_count = ((int) in.readValue((String.class.getClassLoader())));
            in.readList(instance.items, (Items.class.getClassLoader()));
            return instance;
        }

        public SearchResponseModel[] newArray(int size) {
            return (new SearchResponseModel[size]);
        }

    };


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

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total_count);
        dest.writeValue(incomplete_results);
        dest.writeList(items);
    }

    public int describeContents() {
        return 0;
    }
}
