package com.bw.mall.mvp.homepage.commodity;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.CommodiListBean;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/2 21:14
 * @Description: 用途：完成特定功能
 */
public class CommodityListPresenterImpl extends BasePresenter<ICommodityListContract.ICommodityView> implements ICommodityListContract.ICommodityPresenter {
    private CommodityListModuleImpl module;
    @Override
    protected void initModule() {
        module = new CommodityListModuleImpl();
    }

    @Override
    public void getCommodityData() {
        module.getCommodityData(new ICommodityListContract.ICommodityModule.ModuleCallBack() {
            @Override
            public void onSuccess(CommodiListBean bean) {
                baseView.onSuccess(bean);
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed(error);
            }
        });
    }
}
