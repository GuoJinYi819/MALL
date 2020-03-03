package com.bw.mall.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.mall.R;
import com.bw.mall.adapter.HomeNewsAdapter;
import com.bw.mall.base.BaseFragment;
import com.bw.mall.bean.CommodiListBean;
import com.bw.mall.bean.XBannerBean;
import com.bw.mall.mvp.homepage.commodity.CommodityListPresenterImpl;
import com.bw.mall.mvp.homepage.commodity.ICommodityListContract;
import com.bw.mall.mvp.homepage.xbanner.BannerPresenterImpl;
import com.bw.mall.mvp.homepage.xbanner.IBannerContract;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
public class HomeFragment extends BaseFragment<BannerPresenterImpl, CommodityListPresenterImpl> implements IBannerContract.IBannerView, ICommodityListContract.ICommodityView {

    private static final String TAG = "HomeFragment";
    @BindView(R.id.xbHome)
    XBanner xbHome;
    @BindView(R.id.homeNews)
    RecyclerView homeNews;
    @BindView(R.id.tvNews)
    TextView tvNews;
    private Unbinder unbinder;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        //绑定 butterknife
        unbinder = ButterKnife.bind(this, view);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        homeNews.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        presenter1.getBannerData();
        presenter2.getCommodityData();
    }

    @Override
    protected BannerPresenterImpl initPresenter1() {
        return new BannerPresenterImpl();
    }

    @Override
    protected CommodityListPresenterImpl initPresenter2() {
        return new CommodityListPresenterImpl();
    }

    //xbanner回调
    @Override
    public void onSuccess(XBannerBean banner) {
        List<XBannerBean.ResultBean> result = banner.getResult();
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            XBannerBean.ResultBean resultBean = result.get(i);
            String imageUrl = resultBean.getImageUrl();
            stringList.add(imageUrl);
        }
        //设置banner数据
        xbHome.setData(stringList);
        xbHome.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getContext())
                        .load(stringList.get(position))
                        .into((ImageView) view);
            }
        });
        xbHome.setmAutoPlayAble(true);
    }

    //commdoty回调
    @Override
    public void onSuccess(CommodiListBean bean) {
        CommodiListBean.ResultBean result = bean.getResult();
        CommodiListBean.ResultBean.RxxpBean rxxp = result.getRxxp();
        tvNews.setText(rxxp.getName());
        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(rxxp, getContext());
        homeNews.setAdapter(homeNewsAdapter);
    }

    @Override
    public void onFailed(String error) {


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

}
