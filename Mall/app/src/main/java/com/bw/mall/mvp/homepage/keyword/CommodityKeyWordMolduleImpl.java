package com.bw.mall.mvp.homepage.keyword;

import com.bw.mall.bean.CommodityByKeyBean;
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
 * @version 创建时间：2020/3/3 20:34
 * @Description: 用途：完成特定功能
 */
public class CommodityKeyWordMolduleImpl implements ICommodityKeyWordContract.ICommodityKeyWordModule{
    @Override
    public void getCommodityKeyWordData(Map<String,String> param,ModuleCallBack moduleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.createService();
        Observable<CommodityByKeyBean> observable = apiService.getCommodityByKeyWord(param);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommodityByKeyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommodityByKeyBean value) {
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
