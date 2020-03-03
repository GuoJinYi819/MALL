package com.bw.mall.mvp.homepage.keyword;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.CommodityByKeyBean;

import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/3 21:04
 * @Description: 用途：完成特定功能
 */
public class CommodityKeyWordPresenterImpl extends BasePresenter<ICommodityKeyWordContract.ICommodityKeyWordView> implements ICommodityKeyWordContract.ICommodityKeyWordPresenter {
    private CommodityKeyWordMolduleImpl moldule;
    @Override
    protected void initModule() {
        moldule = new CommodityKeyWordMolduleImpl();
    }

    @Override
    public void getCommodityData(Map<String, String> param) {
        moldule.getCommodityKeyWordData(param, new ICommodityKeyWordContract.ICommodityKeyWordModule.ModuleCallBack() {
            @Override
            public void onSuccess(CommodityByKeyBean bean) {
                baseView.onSuccess(bean);
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed(error);
            }
        });
    }
}
