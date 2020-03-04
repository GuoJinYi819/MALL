package com.bw.mall.mvp.orderlist;

import com.bw.mall.base.IBaseView;
import com.bw.mall.base.OrderListByBean;

import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/4 15:05
 * @Description: 用途：完成特定功能
 */
public interface IOrderListContract {
    interface OrderView extends IBaseView{
        void onSuccess(OrderListByBean byBean);
        void onFailed(String error);
    }
    interface OrderModule{
        void getOrderList(Map<String,String> param,ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(OrderListByBean byBean);
            void onFailed(String error);
        }
    }
    interface OrderPresenter{
        void getOrderList(Map<String,String> param);
    }
}
