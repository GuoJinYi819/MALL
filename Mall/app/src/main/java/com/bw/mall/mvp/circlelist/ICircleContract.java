package com.bw.mall.mvp.circlelist;

import com.bw.mall.base.IBaseView;
import com.bw.mall.bean.CircleListBean;

import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/12 13:37
 * @Description: 用途：完成特定功能
 */
public interface ICircleContract {
    interface ICircleView extends IBaseView{
        void onSuccess(CircleListBean bean);
        void onFailed(String error);
    }
    interface ICircleModule{
        void getCircleList(Map<String,String> param,ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(CircleListBean bean);
            void onFailed(String error);
        }
    }
    interface ICirclePresenter{
        void getCircleList(Map<String,String> param);
    }
}
