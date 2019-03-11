package com.example.retrofitexample.data.source;

import com.example.retrofitexample.data.model.GithubUser;
import com.example.retrofitexample.data.source.remote.RemoteDataSource;

import retrofit2.Callback;

public class Repository {
    private static Repository sRepository;
    private RemoteDataSource mRemoteDataSource;

    private Repository(){
        mRemoteDataSource = RemoteDataSource.getInstance();
    }

    public static Repository getInstance(){
        if(sRepository == null) {
            sRepository = new Repository();
        }
        return sRepository;
    }

    public void loadData(String key, int limit, Callback<GithubUser> callback) {
        mRemoteDataSource.loadData(key, limit, callback);
    }
}
