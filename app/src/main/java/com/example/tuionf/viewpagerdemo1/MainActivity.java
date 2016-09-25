package com.example.tuionf.viewpagerdemo1;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ViewPager mViewPager;
    private List<View> mViews;
    private LinearLayout ll;
    private int currentIndex = 0;

    private static final String TAG = "MainActivity";
    int [] img = new int[]{R.drawable.guaid_0,R.drawable.guaid_1,R.drawable.guaid_2,R.drawable.guaid_3,R.drawable.guaid_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ll = (LinearLayout) findViewById(R.id.ll);

        initData();
        initPoint();
    }

    private void initData(){

        mViews = new ArrayList<View>();

        ViewpagerAdapter vpAdapter = new ViewpagerAdapter(mViews);
        for (int i = 0; i < img.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(img[i]);
            mViews.add(iv);
        }

        mViewPager.setAdapter(vpAdapter);
        mViewPager.setOnPageChangeListener(this);
    }

    private void initPoint(){

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
        for (int i = 0; i < img.length; i++) {
            View v = new View(this);
            v.setBackgroundResource(R.drawable.hey_point);
            if (i != 0){
                params.leftMargin = 20;
            }else {
                v.setBackgroundResource(R.drawable.red_point);
            }
            v.setLayoutParams(params);
            ll.addView(v);
        }


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        
    }

    @Override
    public void onPageSelected(int position) {

        ll.getChildAt(position).setBackgroundResource(R.drawable.red_point);

        ll.getChildAt(currentIndex).setBackgroundResource(R.drawable.hey_point);
        currentIndex = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
