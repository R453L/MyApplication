package com.example.bms.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsAdapter extends FragmentPagerAdapter {
    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HiFragment();
            case 1:
                return  new HelloFragment();
            case 2:
                return new HolaFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
