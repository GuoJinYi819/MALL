package com.bw.mall.mvp.login;

import com.bw.mall.bean.LoginBean;
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
 * @version 创建时间：2020/2/27 19:08
 * @Description: 用途：完成特定功能
 */
public class LoginModuleImpl implements ILoginContract.LoginModuleLayer {
    @Override
    public void loginUser(Map<String, String> param, LoginModuleCallBack loginModuleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.createService();
        Observable<LoginBean> observable = apiService.loginUser(param);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean value) {
                        loginModuleCallBack.loginModuleSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        loginModuleCallBack.loginModuleFail(message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
