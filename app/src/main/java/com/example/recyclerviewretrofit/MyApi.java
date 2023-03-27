package com.example.recyclerviewretrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("posts")
    Call<ArrayList<Post>> modelColl();

}
