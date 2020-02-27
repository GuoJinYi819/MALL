package com.bw.mall.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 16:08
 * @Description: 用途：完成特定功能
 */
public abstract class BaseFragment<p extends BasePresenter> extends Fragment {
    protected p presenter;
    protected View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = initLayoutId();
        view = View.inflate(getContext(), layoutId, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        initView(view);
        initListener();
        initData();
    }

    //初始化布局
    protected abstract int initLayoutId();
    //初始化控件
    protected abstract void initView(View view);
    //初始化监听
    protected abstract void initListener();
    //初始化数据
    protected abstract void initData();
    //初始化presenter层
    protected abstract p initPresenter();

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}