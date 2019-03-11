package com.example.retrofitexample.screen.home;


import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofitexample.R;
import com.example.retrofitexample.data.model.Item;
import com.example.retrofitexample.screen.detail.DetailActivity;

import java.util.List;

public class ResultFragment extends Fragment implements GithubUserAdapter.OnItemClickListener {
    private static ResultFragment sResultFragment;
    private GithubUserViewModel mViewModel;
    private RecyclerView mRecyclerResult;
    private ProgressBar mProgressBar;
    private GithubUserAdapter mAdapter;

    public ResultFragment() {

    }

    public static ResultFragment getInstance() {
        if(sResultFragment == null){
            sResultFragment = new ResultFragment();
        }
        return sResultFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel = MainActivity.optainViewModel(getActivity());
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.getItemMutableLiveData().observe(getActivity(), new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                showListUser(items);
            }
        });

        mViewModel.getErrorMutableLiveData().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                showError(s);
            }
        });

        initView(view);
    }

    private void initView(View view) {
        mProgressBar = view.findViewById(R.id.progress_bar);
        mRecyclerResult = view.findViewById(R.id.recycler_result_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new GithubUserAdapter(getContext(), this);
        mRecyclerResult.setLayoutManager(layoutManager);
        mRecyclerResult.setAdapter(mAdapter);
        showProgressBar(true);
    }

    public void showProgressBar(boolean isShowing) {
        if (isShowing) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    public void showListUser(List<Item> items) {
        showProgressBar(false);
        mAdapter.setItems(items);
    }

    public void showError(String err) {
        Toast.makeText(getContext(), err, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(Item item) {
        startActivity(DetailActivity.getIntent(getContext(), item));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("DESTROYED", "onDestroy: " );
    }
}
