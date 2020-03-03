package com.bw.mall.mvp.homepage.keyword;

import com.bw.mall.base.IBaseView;
import com.bw.mall.bean.CommodiListBean;
import com.bw.mall.bean.CommodityByKeyBean;

import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/2 20:58
 * @Description: 用途：完成特定功能
 */
public interface ICommodityKeyWordContract {
    interface ICommodityKeyWordView extends IBaseView {
        void onSuccess(CommodityByKeyBean bean);
        void onFailed(String error);
    }
    interface ICommodityKeyWordModule{
        void getCommodityKeyWordData(Map<String,String> param, ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(CommodityByKeyBean bean);
            void onFailed(String error);
        }
    }
    interface ICommodityKeyWordPresenter{
        void getCommodityData(Map<String,String> param);
    }
}
