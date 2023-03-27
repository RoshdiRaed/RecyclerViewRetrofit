package com.example.recyclerviewretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class MainActivity extends AppCompatActivity {
        RecyclerView rv;
        ArrayList<Post> postsArrayList;
        private String BASE_URL = "https://jsonplaceholder.typicode.com";
        MyApi api;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            rv = findViewById(R.id.recyclerView);
            postsArrayList = new ArrayList<>();


            viewJsonData();

        }

        private void viewJsonData() {
    //        create retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(MyApi.class);
            Call<ArrayList<Post>> arrayListCall = api.modelColl();
            arrayListCall.enqueue(new Callback<ArrayList<Post>>() {
                @Override
                public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                    postsArrayList = response.body();
                    for (int i = 0; i < postsArrayList.size(); i++) {
                        MyAdapter ma = new MyAdapter(MainActivity.this,postsArrayList);
                        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
                        rv.setLayoutManager(lm);
                        rv.setAdapter(ma);

                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                }
            });

        }
    }