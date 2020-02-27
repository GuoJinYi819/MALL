package com.bw.mall.net;

import com.bw.mall.bean.LoginBean;
import com.bw.mall.bean.RegisterBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/27 19:03
 * @Description: 用途：完成特定功能
 */
public interface ApiService {

    //post请求 登入
    @POST("user/v1/login")
    Observable<LoginBean> loginUser(@QueryMap Map<String, String> param);

    //注册
    @POST("user/v1/register")
    Observable<RegisterBean> registerUser(@QueryMap Map<String,String> param);

}
