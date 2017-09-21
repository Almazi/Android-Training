package almazi.gitex.RecyclerView;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import almazi.gitex.Models.Items;
import almazi.gitex.Models.SearchResponseModel;
import almazi.gitex.R;

/**
 * Created by almazi on 9/21/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<Items> itemsList;

    public RecyclerViewAdapter(Context context, List<Items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_items, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Items item = itemsList.get(position);
        Picasso.with(context)
                .load(item.getAvatar_url())
                .into(holder.userImageView);
        holder.userNameTextView.setText(item.getLogin());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
