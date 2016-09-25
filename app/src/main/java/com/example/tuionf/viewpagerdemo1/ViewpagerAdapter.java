package com.example.tuionf.viewpagerdemo1;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by tuionf on 2016/9/25.
 */

public class ViewpagerAdapter extends PagerAdapter {

    private List<View> mViewsList;

    public ViewpagerAdapter(List<View> viewsList) {
        mViewsList = viewsList;
    }

    @Override
    public int getCount() {
        return mViewsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewsList.get(position));
        return mViewsList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewsList.get(position));
    }
}
