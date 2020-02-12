package com.swapon.simplenetworkoperationusingmvvm.api;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

/**
 * Created by metakave-android-PC on 16-Oct-18.
 */

public class ApiClient {

    private static final String BASE_URL = "https://reqres.in/api/";

    private static Retrofit retrofit = null;
    private static String CLIENT_KEY;
    private static String CLIENT_SCERET;
    private static final String TAG = "ApiClient";

    public static Retrofit getApiClient() {

        Log.d(TAG, "retroit is predefined null");

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

//        CLIENT_KEY = SharedPreferenceManager.getStringFromSharePreference(MyApplication.getAppContext(), AppConstant.CLIENT_KEY);
//        CLIENT_SCERET = SharedPreferenceManager.getStringFromSharePreference(MyApplication.getAppContext(), AppConstant.CLIENT_SECRET);

//        Log.d(TAG, "CLIENT_KEY: " + CLIENT_KEY);
//        Log.d(TAG, "CLIENT_SCERET: " + CLIENT_SCERET);

//        if (CLIENT_KEY != null && CLIENT_SCERET != null) {

//        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(CLIENT_KEY, CLIENT_SCERET);
        // consumer.setTokenWithSecret(token, tokenSecret);

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
//                    .addInterceptor(new SigningInterceptor(consumer))
                .addInterceptor(interceptor)
                .build();


        //use this code for handling api error with status code globally
//            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .readTimeout(60, TimeUnit.SECONDS)
//                    .connectTimeout(60, TimeUnit.SECONDS)
////                    .addInterceptor(new SigningInterceptor(consumer))
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request request = chain.request();
//                            Response response = chain.proceed(request);
//
//                            // todo deal with the issues the way you need to
//                            if (response.code() == 500) {
//
//                                Log.d(TAG, "code 500");
////                                startActivity(
////                                        new Intent(
////                                                ErrorHandlingActivity.this,
////                                                ServerIsBrokenActivity.class
////                                        )
////                                );
//
//                                return response;
//                            } else if (response.code() == 404) {
//                                Log.d(TAG, "not found");
//
//                                new Handler(Looper.getMainLooper()).post(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Toast.makeText(MyApplication.getAppContext(), "Not found", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//
//                            }
//
//                            return response;
//                        }
//                    })
//                    .build();


        if (retrofit == null) {
            Log.d(TAG, "retroit is  null");
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        } else {
            Log.d(TAG, "retroit is not null: " + retrofit.toString());
        }

        return retrofit;
    }
}
