package com.bw.mall.mvp.orderlist;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.base.OrderListByBean;

import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/4 21:29
 * @Description: 用途：完成特定功能
 */
public class OrderListPresenterImpl extends BasePresenter<IOrderListContract.OrderView> implements IOrderListContract.OrderPresenter {
    private OrderListModuleImpl module;
    @Override
    protected void initModule() {
        module = new OrderListModuleImpl();
    }

    @Override
    public void getOrderList(Map<String, String> param) {
        module.getOrderList(param, new IOrderListContract.OrderModule.ModuleCallBack() {
            @Override
            public void onSuccess(OrderListByBean byBean) {
                baseView.onSuccess(byBean);
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed(error);
            }
        });
    }
}
