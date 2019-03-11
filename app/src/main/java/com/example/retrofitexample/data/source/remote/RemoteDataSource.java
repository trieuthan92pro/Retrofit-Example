package com.example.retrofitexample.data.source.remote;

import com.example.retrofitexample.data.model.GithubUser;
import com.example.retrofitexample.data.source.DataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private static RemoteDataSource sRemoteDataSource;
    private static final String BASE_URL = "https://api.github.com/search/";

    private RemoteDataSource() {

    }

    public static RemoteDataSource getInstance() {
        if (sRemoteDataSource == null) {
            sRemoteDataSource = new RemoteDataSource();
        }
        return sRemoteDataSource;
    }

    public void loadData(String key, int limit, Callback<GithubUser> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<GithubUser> githubUsers = service.getUsers(limit, key);
        githubUsers.enqueue(callback);
    }
}
