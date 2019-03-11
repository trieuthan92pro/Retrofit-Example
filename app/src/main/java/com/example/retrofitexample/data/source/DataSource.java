package com.example.retrofitexample.data.source;

import com.example.retrofitexample.data.model.Item;

import java.util.List;

public interface DataSource {
    interface LoadGithubUserCallback {
        void onSuccess(List<Item> items);

        void onFailed(Exception e);
    }
}
