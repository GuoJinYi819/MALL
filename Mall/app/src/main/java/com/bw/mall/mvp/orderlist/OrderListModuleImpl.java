package com.bw.mall.mvp.orderlist;

import com.bw.mall.base.OrderListByBean;
import com.bw.mall.net.ApiService;
import com.bw.mall.net.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/4 15:07
 * @Description: 用途：完成特定功能
 */
public class OrderListModuleImpl implements IOrderListContract.OrderModule {
    @Override
    public void getOrderList(Map<String, String> param, ModuleCallBack moduleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.createService();
        Observable<OrderListByBean> orderList = apiService.getOrderList(param);
        orderList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderListByBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderListByBean value) {
                        moduleCallBack.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        moduleCallBack.onFailed(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
