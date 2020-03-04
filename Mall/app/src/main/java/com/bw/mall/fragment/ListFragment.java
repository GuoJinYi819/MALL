package com.bw.mall.fragment;

import android.view.View;

import com.bw.mall.R;
import com.bw.mall.adapter.ListFragmentAdapter;
import com.bw.mall.base.BaseFragment;
import com.bw.mall.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 16:08
 * @Description: 用途：完成特定功能
 */
public class ListFragment extends BaseFragment {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView(View view) {
        unbind = ButterKnife.bind(this, view);
        //联动
        viewPager.setAdapter(new ListFragmentAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter initPresenter1() {
        return null;
    }

    @Override
    protected BasePresenter initPresenter2() {
        return null;
    }

    @Override
    protected BasePresenter initPresenter3() {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
    }
}
