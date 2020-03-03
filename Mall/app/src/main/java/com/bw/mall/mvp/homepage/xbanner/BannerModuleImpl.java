package com.bw.mall.mvp.homepage.xbanner;

import com.bw.mall.bean.XBannerBean;
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
 * @version 创建时间：2020/3/2 21:03
 * @Description: 用途：完成特定功能
 */
public class BannerModuleImpl implements IBannerContract.IBannerModule {
    @Override
    public void getBannerData(ModuleCallBack moduleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.createService();
        Observable<XBannerBean> observable = apiService.getXBanner();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XBannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XBannerBean value) {
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
