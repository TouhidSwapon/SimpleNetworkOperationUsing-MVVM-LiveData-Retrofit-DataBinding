package com.swapon.simplenetworkoperationusingmvvm.model.repository.remote;

import com.swapon.simplenetworkoperationusingmvvm.utills.URLSettings;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by metakave-android-PC on 16-Oct-18.
 */

public interface ApiInterface {


    //GET
    @GET(URLSettings.GET_USERS)
    Call<ResponseBody> getUserList();



//    @GET(URLSettings.GET_SALE_ORDER_LINE)
//    Call<SalesOrderLineResponse> getSaleOrderLineList(@Query("domain") String domain);

//
//    //POST
//
//    @POST(URLSettings.POST_QUOTATION)
//        //@Headers("Content-Type: text/html; charset=utf-8")
//    Call<ResponseBody> postQuotation(@Query("vals") String vals);
//
//    @POST(URLSettings.POST_QUOTATION_LINE)
//        //@Headers("Content-Type: text/html; charset=utf-8")
//    Call<ResponseBody> postQuotationLine(@Query("vals") String vals);
//
//
//    //PUT
//
//    @PUT(URLSettings.UPDATE_QUOTATION)
//        //@Headers("Content-Type: text/html")
//    Call<ResponseBody> updateQuotation(@Path("id") Integer userId, @Body() Quotation quotation);
//
//
//    //DELETE
//    @DELETE(URLSettings.DELETE_QUOTATION)
//    Call<ResponseBody> deleteQuotation(@Path("id") String shippingId);



}
