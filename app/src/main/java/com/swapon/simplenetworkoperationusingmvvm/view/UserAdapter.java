package com.swapon.simplenetworkoperationusingmvvm.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swapon.simplenetworkoperationusingmvvm.R;
import com.swapon.simplenetworkoperationusingmvvm.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User.UserData> mData;
    private Context mContext;


    public UserAdapter(Context context, List<User.UserData> data) {
        this.mData = data;
        this.mContext = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_layout_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvFirstName.setText(mData.get(position).getFirstName());
        holder.tvLastName.setText(mData.get(position).getLastName());
        holder.tvEmail.setText(mData.get(position).getEmail());

        Picasso.get()
                .load(mData.get(position).getAvatar())
                //.placeholder(R.drawable.user_placeholder)
               // .error(R.drawable.user_placeholder_error)
                .into(holder.ivProfilePhoto);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFirstName, tvLastName, tvEmail;
        private ImageView ivProfilePhoto;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            ivProfilePhoto = itemView.findViewById(R.id.ivProfilePhoto);
        }
    }
}
