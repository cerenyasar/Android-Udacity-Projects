package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by maron on 8.07.2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context context;


    public CategoryAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricalFragment();
        } else if (position == 1) {
            return new ShopFragment();
        } else if (position == 2) {
            return new RestaurantsFragment();
        } else {
            return new HotelsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        String tabTitles[] = new String[] { context.getString(R.string.historical) ,context.getString(R.string.shop),
                context.getString(R.string.restaurants),context.getString(R.string.hotels)};
        return tabTitles[position];
    }
}
