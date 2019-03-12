package com.example.retrofitexample.screen.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.retrofitexample.R;

public class MainActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;

    public static GithubUserViewModel optainViewModel(FragmentActivity fragmentActivity) {
        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory
                .getInstance(fragmentActivity.getApplication());
        GithubUserViewModel viewModel =
                ViewModelProviders.of(fragmentActivity, factory).get(GithubUserViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        setUpFragment();
    }

    private void setUpFragment() {
        ResultFragment resultFragment = (ResultFragment) mFragmentManager
                .findFragmentById(R.id.frame_result);
        UserInputFragment userInputFragment = (UserInputFragment) mFragmentManager
                .findFragmentById(R.id.frame_user_input);
        if (resultFragment == null) {
            resultFragment = ResultFragment.getInstance();
        }
        if (userInputFragment == null) {
            userInputFragment = UserInputFragment.getInstance();
        }
        replaceFragment(mFragmentManager, resultFragment, R.id.frame_result);
        replaceFragment(mFragmentManager, userInputFragment, R.id.frame_user_input);
    }

    private void replaceFragment(FragmentManager supportFragmentManager, Fragment fragment,
                                 int frame_fragment_main) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(frame_fragment_main, fragment)
        .addToBackStack(null);
        transaction.commit();
    }
}
