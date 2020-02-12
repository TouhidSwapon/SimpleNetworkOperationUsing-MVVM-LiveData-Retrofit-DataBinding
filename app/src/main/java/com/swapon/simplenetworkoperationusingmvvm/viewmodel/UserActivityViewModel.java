package com.swapon.simplenetworkoperationusingmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.swapon.simplenetworkoperationusingmvvm.model.User;
import com.swapon.simplenetworkoperationusingmvvm.model.UserRepository;

public class UserActivityViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public UserActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }


    public LiveData<User> getAllUsers(){

        return userRepository.getUserData();
    }

}
