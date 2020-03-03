package com.bw.mall.mvp.homepage.xbanner;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.XBannerBean;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/2 21:09
 * @Description: 用途：完成特定功能
 */
public class BannerPresenterImpl extends BasePresenter<IBannerContract.IBannerView> implements IBannerContract.IBannerPresenter {
    private BannerModuleImpl module;
    @Override
    protected void initModule() {
        module = new BannerModuleImpl();
    }

    @Override
    public void getBannerData() {
        module.getBannerData(new IBannerContract.IBannerModule.ModuleCallBack() {
            @Override
            public void onSuccess(XBannerBean banner) {
                baseView.onSuccess(banner);
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed(error);
            }
        });
    }
}
