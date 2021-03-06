package com.valentun.findgift.network;

import com.valentun.findgift.models.AuthModel;
import com.valentun.findgift.models.Gift;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIClient {
    @POST("auth/")
    Call<ResponseBody> createUser(@Body AuthModel authModel);

    @POST("auth/sign_in")
    Call<ResponseBody> createSession(@Body AuthModel authModel);

    @GET("gifts.json")
    Call<List<Gift>> getGifts(@Query("age") String age, @Query("gender") String gender, @Query("event_type") String eventType);

    @POST("gifts.json")
    Call<ResponseBody> createGift(@Body Gift gift);

    @GET("gifts/{gift}/like")
    Call<ResponseBody> upVoteGift(@Path("gift") String gift);

    @GET("gifts/{gift}/dislike")
    Call<ResponseBody> downVoteGift(@Path("gift") String gift);
}
