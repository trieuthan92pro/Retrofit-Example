package com.example.retrofitexample.screen.home;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.retrofitexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserInputFragment extends Fragment implements View.OnClickListener {
    private EditText mEditSearchKey;
    private EditText mEditLimit;
    private Button mButtonSearch;
    private GithubUserViewModel mGithubUserViewModel;

    public UserInputFragment() {
    }

    public static UserInputFragment getInstance() {
        return new UserInputFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditLimit = view.findViewById(R.id.edit_limit);
        mEditSearchKey = view.findViewById(R.id.edit_key);
        mButtonSearch = view.findViewById(R.id.button_search);
        mButtonSearch.setOnClickListener(this);
        mGithubUserViewModel = MainActivity.optainViewModel(getActivity());
    }

    @Override
    public void onClick(View v) {
        String key = mEditSearchKey.getText().toString();
        String limit = mEditLimit.getText().toString();
        InputMethodManager inputManager =  (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(mEditLimit.getWindowToken(), 0);
        int number = 0;
        try {
            number = Integer.parseInt(limit);
            mGithubUserViewModel.loadData(key, number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
