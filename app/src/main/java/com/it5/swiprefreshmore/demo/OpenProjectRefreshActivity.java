package com.it5.swiprefreshmore.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.it5.swiprefreshmore.R;

/**
 * Created by IT5 on 2016/11/18.
 */

public class OpenProjectRefreshActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,new OpenProjectTabPagerFragment())
                .commit();
    }
}
