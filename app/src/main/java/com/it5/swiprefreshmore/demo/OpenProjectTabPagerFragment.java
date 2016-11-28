package com.it5.swiprefreshmore.demo;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.it5.swiprefreshmore.R;

/**
 * Created by IT5 on 2016/11/18.
 */

public class OpenProjectTabPagerFragment extends TabPagerFragment{

    public static OpenProjectTabPagerFragment newInstance() {
        return new OpenProjectTabPagerFragment();
    }

    @Override
    public void onBuildTabPager(Builder builder) {
        FragmentEntry.buildTabPager(builder,getActivity());
    }

    private enum FragmentEntry{
        NORMAL(
                R.string.tab_normal,
                OpenProjectNormalFragment.class),
        FLOAT(
                R.string.tab_float,
                OpenProjectFloatFragment.class),
        PINNED(
                R.string.tab_pinned,
                OpenProjectPinnedFragment.class);

        final int titleResource;
        final Class<? extends Fragment> fragmentClass;

        FragmentEntry( int titleResource,Class<? extends Fragment> fragmentClass) {
            this.fragmentClass = fragmentClass;
            this.titleResource = titleResource;
        }

        static void buildTabPager(Builder builder, Context context) {
            for (FragmentEntry e : FragmentEntry.values()) {
                builder.addTab(context.getString(e.titleResource), e.fragmentClass, null);
            }
        }

    }
}
