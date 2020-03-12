package com.bw.mall.mvp.circlelist;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.CircleListBean;

import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/12 14:04
 * @Description: 用途：完成特定功能
 */
public class CirclePresenterImpl extends BasePresenter<ICircleContract.ICircleView> implements ICircleContract.ICirclePresenter {
    private CircleModuleImpl module;
    @Override
    protected void initModule() {
        module = new CircleModuleImpl();
    }

    @Override
    public void getCircleList(Map<String, String> param) {
        module.getCircleList( param, new ICircleContract.ICircleModule.ModuleCallBack() {
            @Override
            public void onSuccess(CircleListBean bean) {
                baseView.onSuccess( bean );
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed( error );
            }
        } );
    }
}
