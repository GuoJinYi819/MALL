package com.bw.mall.mvp.homepage.commodity;

import com.bw.mall.base.IBaseView;
import com.bw.mall.bean.CommodiListBean;
import com.stx.xhb.xbanner.XBanner;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/2 20:58
 * @Description: 用途：完成特定功能
 */
public interface ICommodityListContract {
    interface ICommodityView extends IBaseView {
        void onSuccess(CommodiListBean bean);
        void onFailed(String error);
    }
    interface ICommodityModule{
        void getCommodityData(ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(CommodiListBean bean);
            void onFailed(String error);
        }
    }
    interface ICommodityPresenter{
        void getCommodityData();
    }
}
