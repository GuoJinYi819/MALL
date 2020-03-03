package com.bw.mall.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.mall.R;
import com.bw.mall.adapter.HomeKeyWordAdapter;
import com.bw.mall.adapter.HomeMlssAdapter;
import com.bw.mall.adapter.HomeNewsAdapter;
import com.bw.mall.adapter.HomePzshAdapter;
import com.bw.mall.base.BaseFragment;
import com.bw.mall.bean.CommodiListBean;
import com.bw.mall.bean.CommodityByKeyBean;
import com.bw.mall.bean.XBannerBean;
import com.bw.mall.customview.MySeachView;
import com.bw.mall.mvp.homepage.commodity.CommodityListPresenterImpl;
import com.bw.mall.mvp.homepage.commodity.ICommodityListContract;
import com.bw.mall.mvp.homepage.keyword.CommodityKeyWordPresenterImpl;
import com.bw.mall.mvp.homepage.keyword.ICommodityKeyWordContract;
import com.bw.mall.mvp.homepage.xbanner.BannerPresenterImpl;
import com.bw.mall.mvp.homepage.xbanner.IBannerContract;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
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
public class HomeFragment extends BaseFragment<BannerPresenterImpl, CommodityListPresenterImpl, CommodityKeyWordPresenterImpl> implements IBannerContract.IBannerView, ICommodityListContract.ICommodityView, ICommodityKeyWordContract.ICommodityKeyWordView {

    private static final String TAG = "HomeFragment";
    @BindView(R.id.xbHome)
    XBanner xbHome;
    @BindView(R.id.homeNews)
    RecyclerView homeNews;
    @BindView(R.id.tvNews)
    TextView tvNews;
    @BindView(R.id.tvmlss)
    TextView tvmlss;
    @BindView(R.id.homeMlss)
    RecyclerView homeMlss;
    @BindView(R.id.tvPzsh)
    TextView tvPzsh;
    @BindView(R.id.homePzsh)
    RecyclerView homePzsh;
    @BindView(R.id.mySeach)
    MySeachView mySeach;
    @BindView(R.id.rvSeachView)
    RecyclerView rvSeachView;
    @BindView(R.id.sollView)
    ScrollView sollView;
    @BindView(R.id.tvAAAA)
    TextView tvAAAA;
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

        LinearLayoutManager l = new LinearLayoutManager(getContext());
        l.setOrientation(RecyclerView.VERTICAL);
        homeMlss.setLayoutManager(l);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        homePzsh.setLayoutManager(gridLayoutManager);

        GridLayoutManager g = new GridLayoutManager(getContext(), 2);
        g.setOrientation(RecyclerView.VERTICAL);
        rvSeachView.setLayoutManager(g);

    }

    @Override
    protected void initListener() {
        //搜索按钮点击事件
        mySeach.setOnSeachListener(new MySeachView.OnSeachListener() {
            @Override
            public void onSeach(String content) {


                boolean empty = TextUtils.isEmpty(content);
                if (!empty) {
                    tvAAAA.setVisibility(View.VISIBLE);
                    rvSeachView.setVisibility(View.VISIBLE);
                    sollView.setVisibility(View.GONE);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("keyword", content);
                    hashMap.put("page", "1");
                    hashMap.put("count", "10");
                    presenter3.getCommodityData(hashMap);
                }else {
                    tvAAAA.setVisibility(View.GONE);
                    rvSeachView.setVisibility(View.GONE);
                    sollView.setVisibility(View.VISIBLE);
                }


            }
        });

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

    @Override
    protected CommodityKeyWordPresenterImpl initPresenter3() {
        return new CommodityKeyWordPresenterImpl();
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

        CommodiListBean.ResultBean.MlssBean mlss = result.getMlss();
        tvmlss.setText(mlss.getName());
        HomeMlssAdapter homeMlssAdapter = new HomeMlssAdapter(mlss, getContext());
        homeMlss.setAdapter(homeMlssAdapter);

        CommodiListBean.ResultBean.PzshBean pzsh = result.getPzsh();
        tvPzsh.setText(pzsh.getName());
        HomePzshAdapter homePzshAdapter = new HomePzshAdapter(pzsh, getContext());
        homePzsh.setAdapter(homePzshAdapter);

    }

    @Override
    public void onSuccess(CommodityByKeyBean bean) {
        //展示数据
        List<CommodityByKeyBean.ResultBean> result = bean.getResult();
        HomeKeyWordAdapter homeKeyWordAdapter = new HomeKeyWordAdapter(result, getContext());
        rvSeachView.setAdapter(homeKeyWordAdapter);
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
