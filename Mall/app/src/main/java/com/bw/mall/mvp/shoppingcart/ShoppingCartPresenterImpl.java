package com.bw.mall.mvp.shoppingcart;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.ShoppingCartBean;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/9 20:27
 * @Description: 用途：完成特定功能
 */
public class ShoppingCartPresenterImpl extends BasePresenter<IShoppingCartContract.IShoppingCartView> implements IShoppingCartContract.IShoppingCartPresenter {
    private ShoppingCartModuleImpl module;
    @Override
    protected void initModule() {
        module = new ShoppingCartModuleImpl();
    }

    @Override
    public void getShoppingCart() {
        module.getShoppingCart( new IShoppingCartContract.IShoppingCartModule.ModuleCallBack() {
            @Override
            public void onSuccess(ShoppingCartBean bean) {
                baseView.onSuccess( bean );
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed( error );
            }
        } );
    }
}
