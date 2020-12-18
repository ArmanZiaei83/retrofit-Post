package com.example.retrofit_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.security.identity.AccessControlProfileId;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public TextView textView;
    public EditText postBodyTextView;
    public EditText postTitleTextView;
    public EditText postUserIdTextView;

    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view_result);
        postBodyTextView = (EditText) findViewById(R.id.postBodyTextView);
        postTitleTextView = (EditText) findViewById(R.id.postTitle);
        postUserIdTextView = (EditText) findViewById(R.id.postUserIdTextView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
//        createPost();
    }

    public void createPost(){
        //Using FieldMap
//        Map<String , String> fields = new HashMap<>();
//        fields.put("userId" , "1");
//        fields.put("title" , "Students");
//        fields.put("body" , "He is a student");

        Post post = new Post(1 , "Students" , "He is a student");

        Call<Post> call = jsonPlaceHolderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textView.setText("Eror" + response.code());
                    return;
                }

                Post createdPosts = response.body();

                String con = "";
                con += "Title : " + createdPosts.getTitle() + "\n" ;
                con += "UserID: " + createdPosts.getUserId() + "\n" ;
                con += "Body : " + createdPosts.getBody() + "\n" ;
                con += "Id : " + createdPosts.getId() + "\n\n" ;

                textView.setText(con);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText("Failed To << LOAD >> " + t.getMessage());
            }
        });
    }
    public void sendPost (View v){
        Post post = new Post(Integer.valueOf(postUserIdTextView.getText().toString()) , postTitleTextView.getText().toString() , postBodyTextView.getText().toString());

        Call<Post> call = jsonPlaceHolderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textView.setText("Eror" + response.code());
                    return;
                }

                Post createdPosts = response.body();

                String con = "";
                con += "Title : " + createdPosts.getTitle() + "\n" ;
                con += "UserID: " + createdPosts.getUserId() + "\n" ;
                con += "Body : " + createdPosts.getBody() + "\n" ;
                con += "Id : " + createdPosts.getId() + "\n\n" ;

                textView.setText(con);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText("Failed To << LOAD >> " + t.getMessage());
            }
        });
    }

}