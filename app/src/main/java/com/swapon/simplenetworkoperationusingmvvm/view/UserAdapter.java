package com.swapon.simplenetworkoperationusingmvvm.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swapon.simplenetworkoperationusingmvvm.R;
import com.swapon.simplenetworkoperationusingmvvm.databinding.ItemLayoutUserBinding;
import com.swapon.simplenetworkoperationusingmvvm.model.pojo.User;

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

        ItemLayoutUserBinding itemLayoutUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_layout_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutUserBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User.UserData userData = mData.get(position);
        holder.itemLayoutUserBinding.setUserData(userData);


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

        ItemLayoutUserBinding itemLayoutUserBinding;

        public ViewHolder(@NonNull ItemLayoutUserBinding binding) {
            super(binding.getRoot());

            this.itemLayoutUserBinding = binding;

        }


    }
}
