package com.bw.mall.mvp.register;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.RegisterBean;

import java.io.IOException;
import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/27 20:36
 * @Description: 用途：完成特定功能
 */
public class RegisterPresenterImpl extends BasePresenter<IRegisterContract.RegisterViewLayer> implements IRegisterContract.RegisterPresenterLayer {
    private RegisterModuleImpl module;
    @Override
    protected void initModule() {
        module = new RegisterModuleImpl();
    }

    @Override
    public void registerUser(Map<String, String> param) {
        module.registerUser(param, new IRegisterContract.RegisterModuleLayer.RegisterModuleCallBack() {
            @Override
            public void registerModuleSuccess(RegisterBean bean) {
                baseView.registerViewSuccess(bean);
            }

            @Override
            public void registerModuleFail(String error) {
                baseView.registerViewFail(error);
            }
        });
    }
}
