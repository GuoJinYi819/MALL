package com.bw.mall.mvp.shoppingcart;

import com.bw.mall.bean.ShoppingCartBean;
import com.bw.mall.net.ApiService;
import com.bw.mall.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/9 20:26
 * @Description: 用途：完成特定功能
 */
public class ShoppingCartModuleImpl implements IShoppingCartContract.IShoppingCartModule {
    @Override
    public void getShoppingCart(ModuleCallBack moduleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.createService();
        Observable<ShoppingCartBean> observable = apiService.getShoppingCart();
        observable.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<ShoppingCartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShoppingCartBean value) {
                        moduleCallBack.onSuccess( value );
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        moduleCallBack.onFailed( message );
                    }

                    @Override
                    public void onComplete() {

                    }
                } );
    }
}
