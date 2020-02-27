package com.bw.mall.mvp.login;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.LoginBean;

import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/27 19:14
 * @Description: 用途：完成特定功能
 */
public class LoginPresenterImpl extends BasePresenter<ILoginContract.LoginViewLayer> implements ILoginContract.LoginPresenterLayer {
    private LoginModuleImpl module;
    @Override
    protected void initModule() {
            module = new LoginModuleImpl();
    }

    @Override
    public void loginUser(Map<String, String> param) {
        module.loginUser(param, new ILoginContract.LoginModuleLayer.LoginModuleCallBack() {
            @Override
            public void loginModuleSuccess(LoginBean bean) {
                baseView.loginViewSuccess(bean);
            }

            @Override
            public void loginModuleFail(String error) {
                baseView.loginViewFail(error);
            }
        });
    }
}
