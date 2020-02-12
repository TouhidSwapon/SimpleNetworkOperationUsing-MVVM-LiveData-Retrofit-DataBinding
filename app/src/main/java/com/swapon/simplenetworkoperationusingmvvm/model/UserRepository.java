package com.swapon.simplenetworkoperationusingmvvm.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.swapon.simplenetworkoperationusingmvvm.api.ApiClient;
import com.swapon.simplenetworkoperationusingmvvm.api.ApiInterface;


import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private Application application;
    private MutableLiveData<User> mutableLiveData;
    private ApiInterface apiInterface;

    public UserRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<User> getUserData() {

        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<User>();
        }

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<ResponseBody> call = apiInterface.getUserList();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Gson gson = new Gson();
                    User user = null;
                    try {
                        user = gson.fromJson(response.body().string(), User.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mutableLiveData.setValue(user);

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
