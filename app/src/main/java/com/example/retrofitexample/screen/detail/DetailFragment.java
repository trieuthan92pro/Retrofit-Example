package com.example.retrofitexample.screen.detail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitexample.R;
import com.example.retrofitexample.data.model.Item;

public class DetailFragment extends Fragment {
    public static final String KEY_ITEM = "KEY_ITEM";
    private static final String ID = "ID: ";
    private static final String SCORE = "SCORE: ";
    private static final String LOGIN = "LOGIN: ";
    private Item mItem;
    private TextView mTextId;
    private TextView mTextUser;
    private TextView mTextScore;
    private ImageView mImageAvartar;

    public DetailFragment() {
    }

    public static DetailFragment getInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mItem = savedInstanceState.getParcelable(KEY_ITEM);
        } else {
            mItem = getArguments().getParcelable(KEY_ITEM);
        }
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextUser = view.findViewById(R.id.text_login_user);
        mTextScore = view.findViewById(R.id.text_score);
        mTextId = view.findViewById(R.id.text_user_id);
        mImageAvartar = view.findViewById(R.id.image_avartar_detail);
        showInfo();
    }

    private void showInfo() {
        mTextId.setText(String.valueOf(ID + mItem.getId()));
        mTextScore.setText(String.valueOf(SCORE + mItem.getScore()));
        mTextUser.setText(String.valueOf(LOGIN + mItem.getLogin()));
        Glide.with(getContext())
                .load(mItem.getAvatarUrl())
                .error(R.drawable.ic_person_add_black_24dp)
                .circleCrop()
                .into(mImageAvartar);
    }
}
