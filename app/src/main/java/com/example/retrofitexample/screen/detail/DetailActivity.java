package com.example.retrofitexample.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.retrofitexample.R;
import com.example.retrofitexample.data.model.Item;

public class DetailActivity extends AppCompatActivity {

    public static Intent getIntent(Context context, Item item){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(DetailFragment.KEY_ITEM, item);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setupFragment();
    }

    private void setupFragment() {
        FragmentManager manager = getSupportFragmentManager();
        DetailFragment detailFragment = (DetailFragment) manager.findFragmentById(R.id.frame_detail);
        if(detailFragment == null) {
            detailFragment = DetailFragment.getInstance();
        }
        Bundle savedInstanceState = new Bundle();
        savedInstanceState.putParcelable(DetailFragment.KEY_ITEM, getIntent().getParcelableExtra(DetailFragment.KEY_ITEM));
        detailFragment.setArguments(savedInstanceState);
        replaceFragment(manager, detailFragment, R.id.frame_detail);
    }

    private void replaceFragment(FragmentManager supportFragmentManager, Fragment fragment,
                                 int frame_fragment_main) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(frame_fragment_main, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
