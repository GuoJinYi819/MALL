package com.bw.mall.net;

import com.bw.mall.base.OrderListByBean;
import com.bw.mall.bean.CommodiListBean;
import com.bw.mall.bean.CommodityByKeyBean;
import com.bw.mall.bean.LoginBean;
import com.bw.mall.bean.RegisterBean;
import com.bw.mall.bean.ShoppingCartBean;
import com.bw.mall.bean.XBannerBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
    @FormUrlEncoded
    Observable<LoginBean> loginUser(@FieldMap Map<String, String> param);

    //注册
    @POST("user/v1/register")
    @FormUrlEncoded
    Observable<RegisterBean> registerUser(@FieldMap Map<String,String> param);

    //Banner数据
    @GET("commodity/v1/bannerShow")
    Observable<XBannerBean> getXBanner();

    //首页多条目数据
    @GET("commodity/v1/commodityList")
    Observable<CommodiListBean> getCommodityList();

    //根据关键字查询
    @GET("commodity/v1/findCommodityByKeyword")
    Observable<CommodityByKeyBean> getCommodityByKeyWord(@QueryMap Map<String,String> param);


    //根据商品状态查询
    @GET("order/verify/v1/findOrderListByStatus")
    Observable<OrderListByBean> getOrderList(@QueryMap Map<String,String> param);

    //购物车数据
    @GET("order/verify/v1/findShoppingCart")
    Observable<ShoppingCartBean> getShoppingCart();

}
