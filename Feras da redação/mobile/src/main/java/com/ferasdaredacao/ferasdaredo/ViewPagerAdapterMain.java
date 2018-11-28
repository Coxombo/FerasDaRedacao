package com.ferasdaredacao.ferasdaredo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapterMain extends FragmentPagerAdapter {
    private final List<Fragment> listFragments = new ArrayList<>();

    public ViewPagerAdapterMain(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return listFragments.get(i);
    }

    @Override
    public int getCount() {
        return 0;
    }

    public void AddFragment(Fragment fragment){
        listFragments.add(fragment);
    }
}
