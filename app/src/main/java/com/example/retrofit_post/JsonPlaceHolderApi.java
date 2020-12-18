package com.example.retrofit_post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    //We Can also use Map for better performance
    @FormUrlEncoded
    @POST
    Call<Post> createPost(@FieldMap Map<String , String> fields);
}
