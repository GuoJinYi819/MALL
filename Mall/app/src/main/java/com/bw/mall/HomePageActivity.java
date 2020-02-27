package com.bw.mall;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bw.mall.adapter.MyPageFragmentAdapter;
import com.bw.mall.base.BaseActivity;
import com.bw.mall.base.BasePresenter;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomePageActivity extends BaseActivity {

    @BindView(R.id.homeVp)
    ViewPager homeVp;
    @BindView(R.id.imgHome)
    ImageView imgHome;
    @BindView(R.id.imgUfo)
    ImageView imgUfo;
    @BindView(R.id.imgShopping)
    ImageView imgShopping;
    @BindView(R.id.imgList)
    ImageView imgList;
    @BindView(R.id.imgMy)
    ImageView imgMy;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_home_page;
    }

    @Override
    protected void initView() {
        unbind = ButterKnife.bind(this);
        //初始界面
        imgHome.setImageResource(R.mipmap.common_tab_btn_home_s_xhdi);
        homeVp.setCurrentItem(0);
    }
    //点击事件
    @OnClick({R.id.imgHome, R.id.imgUfo, R.id.imgShopping, R.id.imgList, R.id.imgMy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgHome:
                imgHome.setImageResource(R.mipmap.common_tab_btn_home_s_xhdi);
                imgUfo.setImageResource(R.mipmap.common_tab_circle_n);
                imgList.setImageResource(R.mipmap.common_tab_list_n_xhdpi);
                imgMy.setImageResource(R.mipmap.common_tab_my_n_xhdpi);

                homeVp.setCurrentItem(0);
                break;
            case R.id.imgUfo:
                imgUfo.setImageResource(R.mipmap.common_tab_btn_circle_s_xhdpi);
                imgHome.setImageResource(R.mipmap.common_tab_home_xhdpi);
                imgList.setImageResource(R.mipmap.common_tab_list_n_xhdpi);
                imgMy.setImageResource(R.mipmap.common_tab_my_n_xhdpi);

                homeVp.setCurrentItem(1);

                break;
            case R.id.imgShopping:
                imgHome.setImageResource(R.mipmap.common_tab_home_xhdpi);
                imgUfo.setImageResource(R.mipmap.common_tab_circle_n);
                imgList.setImageResource(R.mipmap.common_tab_list_n_xhdpi);
                imgMy.setImageResource(R.mipmap.common_tab_my_n_xhdpi);

                homeVp.setCurrentItem(2);
                break;
            case R.id.imgList:
                imgHome.setImageResource(R.mipmap.common_tab_home_xhdpi);
                imgUfo.setImageResource(R.mipmap.common_tab_circle_n);
                imgList.setImageResource(R.mipmap.common_tab_btn_list_s_xhdpi);
                imgMy.setImageResource(R.mipmap.common_tab_my_n_xhdpi);

                homeVp.setCurrentItem(3);
                break;
            case R.id.imgMy:
                imgHome.setImageResource(R.mipmap.common_tab_home_xhdpi);
                imgUfo.setImageResource(R.mipmap.common_tab_circle_n);
                imgList.setImageResource(R.mipmap.common_tab_list_n_xhdpi);
                imgMy.setImageResource(R.mipmap.common_tab_btn_my_s_xhdpi);

                homeVp.setCurrentItem(4);
                break;
        }
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //适配器
        MyPageFragmentAdapter adapter = new MyPageFragmentAdapter(getSupportFragmentManager());
        homeVp.setAdapter(adapter);

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑 防止内存泄露
        if (unbind != null) {
            unbind.unbind();
        }
    }
}
