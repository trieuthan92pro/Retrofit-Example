package com.example.retrofitexample.screen.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.retrofitexample.data.model.GithubUser;
import com.example.retrofitexample.data.model.Item;
import com.example.retrofitexample.data.source.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubUserViewModel extends AndroidViewModel {
    private MutableLiveData<List<Item>> mItemMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> mErrorMutableLiveData = new MutableLiveData<>();
    private Repository mDatasource;

    public GithubUserViewModel(@NonNull Application application) {
        super(application);
        mDatasource = Repository.getInstance();
    }

    public MutableLiveData<List<Item>> getItemMutableLiveData() {
        return mItemMutableLiveData;
    }

    public void setItemMutableLiveData(MutableLiveData<List<Item>> itemMutableLiveData) {
        mItemMutableLiveData = itemMutableLiveData;
    }

    public MutableLiveData<String> getErrorMutableLiveData() {
        return mErrorMutableLiveData;
    }

    public void setErrorMutableLiveData(MutableLiveData<String> errorMutableLiveData) {
        mErrorMutableLiveData = errorMutableLiveData;
    }

    public void loadData(String key, int limit){
        mDatasource.loadData(key, limit, new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                mItemMutableLiveData.setValue(response.body().getItems());
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {
                mErrorMutableLiveData.setValue(t.getMessage());
            }
        });
    }
}
