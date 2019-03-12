package com.example.retrofitexample.screen.detail;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retrofitexample.R;
import com.example.retrofitexample.data.model.Item;
import com.example.retrofitexample.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    public static final String KEY_ITEM = "KEY_ITEM";

    public DetailFragment() {
    }

    public static DetailFragment getInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Item item = getArguments().getParcelable(KEY_ITEM);
        FragmentDetailBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        binding.setItem(item);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
