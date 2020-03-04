package com.bw.mall.fragment.list;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.mall.R;
import com.bw.mall.adapter.OrderListAdapter;
import com.bw.mall.base.BaseFragment;
import com.bw.mall.base.BasePresenter;
import com.bw.mall.base.OrderListByBean;
import com.bw.mall.mvp.orderlist.IOrderListContract;
import com.bw.mall.mvp.orderlist.OrderListPresenterImpl;

import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/4 14:30
 * @Description: 用途：完成特定功能
 */
public class DisplayPageFragment extends BaseFragment<OrderListPresenterImpl,BasePresenter,BasePresenter> implements IOrderListContract.OrderView {

    private RecyclerView recyclerDisplay;
    private int staus;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_display;
    }

    @Override
    protected void initView(View view) {
        recyclerDisplay = view.findViewById(R.id.recyclerDisplay);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerDisplay.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //请求数据
        HashMap<String, String> hashMap = new HashMap<>();
        Bundle arguments = getArguments();
        staus = arguments.getInt("status");
        hashMap.put("status",String.valueOf(staus));
        hashMap.put("page","1");
        hashMap.put("count","15");
        presenter1.getOrderList(hashMap);

    }

    @Override
    protected OrderListPresenterImpl initPresenter1() {
        return new OrderListPresenterImpl();
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
    public void onSuccess(OrderListByBean bean) {
        //请求数据
        List<OrderListByBean.OrderListBean> orderList = bean.getOrderList();
        OrderListAdapter orderListAdapter = new OrderListAdapter(orderList, staus, getContext());
        recyclerDisplay.setAdapter(orderListAdapter);

    }

    @Override
    public void onFailed(String error) {

    }
}
