package com.geektech.a1lesson51;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public static final String KEY1 = "key1";
    public static final String KEY2 = "key2";
    public static final String KEY3 = "key3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        changeFragment();
    }

    public void changeFragment(){
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_first,new ChangeFragment());
        transaction.commit();
    }

    public void displayDetails(String title, String subTitle,int image_display) {
        TextFragment textFragment = (TextFragment) fragmentManager.findFragmentById(R.id.second_fragment);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ) {
            textFragment.showText(title,subTitle,image_display);
        }else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(KEY1, title);
            intent.putExtra(KEY2, subTitle);
            intent.putExtra(KEY3, image_display);

            startActivity(intent);
        }
    }
}