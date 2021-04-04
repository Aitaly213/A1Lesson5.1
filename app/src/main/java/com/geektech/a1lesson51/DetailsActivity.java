package com.geektech.a1lesson51;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import java.sql.ResultSet;

public class DetailsActivity extends AppCompatActivity {
    private String title;
    private String subTitle;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        checkOrientation();
        checkIntent();
        addFragment();
        }

    private void checkOrientation() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ){
            finish();
        }
    }

    private void addFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TextFragment fragment =  TextFragment.newInstance(title,subTitle,image);
        transaction.replace(R.id.details_fragment, fragment);
        transaction.commit();
    }

    private void checkIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(MainActivity.KEY1);
            subTitle = intent.getStringExtra(MainActivity.KEY2);
            image = intent.getIntExtra(MainActivity.KEY3, 0);
        }
    }
}