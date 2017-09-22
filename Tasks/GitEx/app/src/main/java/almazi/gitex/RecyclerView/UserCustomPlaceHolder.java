package almazi.gitex.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import almazi.gitex.R;
import butterknife.BindView;

/**
 * Created by almazi on 9/22/17.
 */

public class UserCustomPlaceHolder extends RecyclerView.ViewHolder {

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
    @BindView(R.id.bioText)
    TextView bioText;

    public UserCustomPlaceHolder(View itemView) {
        super(itemView);
    }
}
