package com.bw.mall.mvp.homepage.xbanner;

import com.bw.mall.base.IBaseView;
import com.bw.mall.bean.XBannerBean;
import com.stx.xhb.xbanner.XBanner;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/2 20:58
 * @Description: 用途：完成特定功能
 */
public interface IBannerContract {
    interface IBannerView extends IBaseView {
        void onSuccess(XBannerBean banner);
        void onFailed(String error);
    }
    interface IBannerModule{
        void getBannerData(ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(XBannerBean banner);
            void onFailed(String error);
        }
    }
    interface IBannerPresenter{
        void getBannerData();
    }
}
