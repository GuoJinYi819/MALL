package com.bw.mall.fragment.list;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bw.mall.R;
import com.bw.mall.base.BaseFragment;
import com.bw.mall.base.BasePresenter;

import java.util.HashMap;

import androidx.recyclerview.widget.RecyclerView;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/4 14:30
 * @Description: 用途：完成特定功能
 */
public class DisplayPageFragment extends BaseFragment {

    private RecyclerView recyclerDisplay;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_display;
    }

    @Override
    protected void initView(View view) {
        recyclerDisplay = view.findViewById(R.id.recyclerDisplay);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //请求数据
        HashMap<String, String> hashMap = new HashMap<>();
        Bundle arguments = getArguments();
        int staus = arguments.getInt("status");
        hashMap.put("status",String.valueOf(staus));
        hashMap.put("page","1");
        hashMap.put("count","15");


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
}
