package com.swapon.simplenetworkoperationusingmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.swapon.simplenetworkoperationusingmvvm.R;
import com.swapon.simplenetworkoperationusingmvvm.model.User;
import com.swapon.simplenetworkoperationusingmvvm.viewmodel.UserActivityViewModel;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        UserActivityViewModel userActivityViewModel = new ViewModelProvider(this).get(UserActivityViewModel.class);
        userActivityViewModel.getAllUsers().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Log.d(TAG, "user.size: " + user.getData().size());


                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(UserActivity.this));

                UserAdapter userAdapter = new UserAdapter(getApplicationContext(), user.getData());
                recyclerView.setAdapter(userAdapter);


            }
        });

    }
}
