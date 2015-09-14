package com.vinoth.dineout.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by vinothkathiravan on 02/09/15.
 */
public class CategoryPager extends FragmentStatePagerAdapter {

    public CategoryPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        DishFragment myFragment = DishFragment.newInstance();
        return myFragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Cusine Name " + (position + 1);
    }
}