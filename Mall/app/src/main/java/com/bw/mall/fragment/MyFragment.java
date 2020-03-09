package com.bw.mall.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bw.mall.R;
import com.bw.mall.adapter.MyAdapter;
import com.bw.mall.base.BaseFragment;
import com.bw.mall.base.BasePresenter;
import com.bw.mall.net.SpUtil;

import java.security.PublicKey;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 16:15
 * @Description: 用途：2
 */
public class MyFragment extends BaseFragment {
    @BindView(R.id.ivHeadPic1)
    ImageView ivHeadPic1;
    @BindView(R.id.ivHeadPic2)
    ImageView ivHeadPic2;
    @BindView(R.id.tvNickName)
    TextView tvNickName;
    @BindView(R.id.listView)
    ListView listView;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View view) {
        unbind = ButterKnife.bind( this, view );
        //获取数据
        SpUtil instance = SpUtil.getInstance();
        String pic = instance.getCachData( SpUtil.SP_HEADPIC );
        String name = instance.getCachData( SpUtil.SP_NICKNAME );
        Glide.with( this )
                .load( pic )
                .into( ivHeadPic1 );
        Glide.with( this )
                .load( pic )
                .apply( RequestOptions.bitmapTransform( new CircleCrop() ) )
                .into( ivHeadPic2 );

        tvNickName.setText( name );

        //模拟数据
        ArrayList<String> list = new ArrayList<>();
        list.add( "个人资料" );
        list.add( "我的圈子" );
        list.add( "我的足迹" );
        list.add( "我的钱包" );
        list.add( "我的收货地址" );

        MyAdapter myAdapter = new MyAdapter( list, getContext() );
        listView.setAdapter( myAdapter );


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
