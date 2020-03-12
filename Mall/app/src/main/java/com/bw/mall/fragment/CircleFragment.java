package com.bw.mall.fragment;

import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Toast;

import com.bw.mall.App;
import com.bw.mall.R;
import com.bw.mall.base.NBaseFragment;
import com.bw.mall.bean.CircleListBean;
import com.bw.mall.mvp.circlelist.CirclePresenterImpl;
import com.bw.mall.mvp.circlelist.ICircleContract;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.header.FunGameBattleCityHeader;
import com.scwang.smartrefresh.header.FunGameHitBlockHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.internal.http2.Header;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 16:15
 * @Description: 用途：2
 */
public class CircleFragment extends NBaseFragment<CirclePresenterImpl> implements ICircleContract.ICircleView {
    @BindView(R.id.recyclerCircle)
    RecyclerView recyclerCircle;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_circle;
    }

    @Override
    protected void initView(View view) {
        unbind = ButterKnife.bind( this, view );

        //设置头部刷新样式    全屏水滴
        refreshLayout.setRefreshHeader(new DeliveryHeader( App.context ) );
        //设置底部加载样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(App.context).setSpinnerStyle( SpinnerStyle.Scale));

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getContext() );
        linearLayoutManager.setOrientation( RecyclerView.VERTICAL );
        recyclerCircle.setLayoutManager( linearLayoutManager );

    }

    @Override
    protected void initListener() {
        //设置下拉刷新
        refreshLayout.setOnRefreshListener( new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText( getContext(), "1", Toast.LENGTH_SHORT ).show();
                refreshLayout.finishRefresh( true );
            }
        } );
        //设置上拉加载
        refreshLayout.setOnLoadMoreListener( new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                Toast.makeText( getContext(), "0", Toast.LENGTH_SHORT ).show();
                refreshLayout.finishLoadMore( true );
            }
        } );

    }

    @Override
    protected void initData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put( "page","1" );
        hashMap.put("count","5");
        presenter.getCircleList( hashMap );
    }

    @Override
    protected CirclePresenterImpl initPresenter() {
        return new CirclePresenterImpl();
    }

    @Override
    public void onSuccess(CircleListBean bean) {
        if (bean != null) {
            List<CircleListBean.ResultBean> result = bean.getResult();
            if (result != null) {

            }
        }

    }

    @Override
    public void onFailed(String error) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
    }
}
