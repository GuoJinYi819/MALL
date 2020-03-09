package com.bw.mall.net;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.mall.App;

import retrofit2.http.POST;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/9 21:42
 * @Description: 用途：完成特定功能
 */
public class GlideUtil {
    //单例
    private static GlideUtil instance;
    private GlideUtil(){

    }
    public static GlideUtil getInstance(){
        if (instance == null) {
            synchronized (GlideUtil.class){
                instance = new GlideUtil();
            }
        }
        return instance;
    }
    //放图片
    public void setImg(String path, ImageView iv){
        Glide.with( App.context )
                .load( path)
                .into( iv );
    }
}
