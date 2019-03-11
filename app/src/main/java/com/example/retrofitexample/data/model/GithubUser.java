package com.example.retrofitexample.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubUser {
    @SerializedName("total_count")
    @Expose
    private Integer mTotalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean mInCompleteResults;
    @SerializedName("items")
    @Expose
    private List<Item> mItems;

    public Integer getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        mTotalCount = totalCount;
    }

    public Boolean getInCompleteResults() {
        return mInCompleteResults;
    }

    public void setInCompleteResults(Boolean inCompleteResults) {
        mInCompleteResults = inCompleteResults;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }
}
