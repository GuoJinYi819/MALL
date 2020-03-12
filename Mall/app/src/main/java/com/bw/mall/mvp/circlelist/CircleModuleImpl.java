package com.bw.mall.mvp.circlelist;

import com.bw.mall.bean.CircleListBean;
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
 * @version 创建时间：2020/3/12 13:42
 * @Description: 用途：完成特定功能
 */
public class CircleModuleImpl implements ICircleContract.ICircleModule {
    @Override
    public void getCircleList(Map<String, String> param, ModuleCallBack moduleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.createService();
        Observable<CircleListBean> observable = apiService.getCircleList( param );
        observable.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<CircleListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CircleListBean value) {
                        moduleCallBack.onSuccess( value );
                    }

                    @Override
                    public void onError(Throwable e) {
                        moduleCallBack.onFailed( e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                } );
    }
}
