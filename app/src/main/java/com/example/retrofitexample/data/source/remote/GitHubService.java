package com.example.retrofitexample.data.source.remote;

import com.example.retrofitexample.data.model.GithubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {
    String LIMIT_PATH = "users?";

    @GET(LIMIT_PATH)
    Call<GithubUser> getUsers(@Query("per_page") int limit, @Query("q") String key);
}
