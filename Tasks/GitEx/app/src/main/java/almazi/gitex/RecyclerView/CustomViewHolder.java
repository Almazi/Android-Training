package almazi.gitex.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import almazi.gitex.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by almazi on 9/21/17.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.userImageView)
    ImageView userImageView;


    @BindView(R.id.userNameTextView)
    TextView userNameTextView;
    /*@BindView(R.id.fullNameTextView)
    TextView fullNameTextView;
    @BindView(R.id.bioTextView)
    TextView bioTextView;
    @BindView(R.id.companyNameTextView)
    TextView companyNameTextView;*/

    public CustomViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
