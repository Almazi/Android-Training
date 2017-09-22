package almazi.gitex.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import almazi.gitex.Models.UserDetails;
import almazi.gitex.R;

/**
 * Created by almazi on 9/22/17.
 */

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserCustomPlaceHolder> {
    private Context context;
    private List<UserDetails> userDetailsList;

    public UserRecyclerViewAdapter(Context context, List<UserDetails> userDetailsList) {
        this.context = context;
        this.userDetailsList = userDetailsList;
    }

    @Override
    public UserCustomPlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_items, parent, false);
        return new UserCustomPlaceHolder(view);
    }

    @Override
    public void onBindViewHolder(UserCustomPlaceHolder holder, int position) {
        UserDetails userDetails = userDetailsList.get(position);
        Picasso.with(context)
                .load(userDetails.getAvatar_url())
                .into(holder.userImageView);
        holder.fullNameTextView.setText(userDetails.getName());
        holder.userNameTextView.setText(userDetails.getLogin());
        holder.companyNameTextView.setText(userDetails.getCompany());
        holder.emailTextView.setText(userDetails.getEmail());
        holder.blogTextView.setText(userDetails.getBlog());
        holder.followerTextView.setText(userDetails.getFollowers());
        holder.reposTextView.setText(userDetails.getRepos());
        holder.bioText.setText(userDetails.getBio());


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
