package com.bw.mall.adapter;

import android.os.Bundle;

import com.bw.mall.fragment.list.DisplayPageFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/4 14:25
 * @Description: 用途：完成特定功能
 */
public class ListFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>();
    private String[] arr= {"全部订单","待付款","待收货","待评价","已完成"};

    public ListFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        for (int i = 0; i < 5; i++) {
            DisplayPageFragment displayPageFragment = new DisplayPageFragment();
            Bundle bundle = new Bundle();
            if (i==4){
                bundle.putInt("status",9);
                displayPageFragment.setArguments(bundle);
                list.add(displayPageFragment);
            }else{
                bundle.putInt("status",i);
                displayPageFragment.setArguments(bundle);
                list.add(displayPageFragment);
            }
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }
}
