package com.bw.mall.mvp.shoppingcart;

import com.bw.mall.base.IBaseView;
import com.bw.mall.bean.ShoppingCartBean;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/9 20:22
 * @Description: 用途：完成特定功能
 */
public interface IShoppingCartContract {
    interface IShoppingCartView extends IBaseView{
        void onSuccess(ShoppingCartBean bean);
        void onFailed(String error);
    }
    interface IShoppingCartModule{
        void getShoppingCart(ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(ShoppingCartBean bean);
            void onFailed(String error);
        }
    }
    interface IShoppingCartPresenter{
        void getShoppingCart();
    }
}
