package com.bw.mall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/9 22:39
 * @Description: 用途：完成特定功能
 */
public class EventBean implements Serializable {
   private List<ShoppingCartBean.ResultBean> result;

    public void setResult(List<ShoppingCartBean.ResultBean> result) {
        this.result = result;
    }

    public List<ShoppingCartBean.ResultBean> getResult() {
        return result;
    }
}
