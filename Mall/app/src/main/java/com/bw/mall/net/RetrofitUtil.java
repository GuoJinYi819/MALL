package com.bw.mall.net;

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.Logger;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/27 14:52
 * @Description: 用途：网络工具类
 */
public class RetrofitUtil {
    //单例模式
    private static RetrofitUtil instance;
    private final OkHttpClient okhttp;
    private final String baseUrl = "http://mobile.bwstudent.com/small/";
    private final Retrofit retrofit;

    private RetrofitUtil(){
        //初始化日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NotNull String s) {
                if (!TextUtils.isEmpty(s)) {
                    if (s.startsWith("{")||s.startsWith("[")) {
                        Logger.json(s);
                    }else{
                        Logger.d(s);
                    }
                }
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //初始化 okhttp
        okhttp = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        //初始化 retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okhttp)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static RetrofitUtil getInstance(){
        if (instance == null) {
            synchronized (RetrofitUtil.class){
                if (instance == null) {
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }

    //定义接口
    public ApiService createService(){
        //动态代理模式创建
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }


}
