package com.bw.mall.mvp.login;

import com.bw.mall.bean.LoginBean;

import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/27 14:51
 * @Description: 用途：登入功能
 */
public interface ILoginContract {
    //view 层
    public interface LoginViewLayer{
        //成功
        void loginViewSuccess(LoginBean bean);
        //失败
        void loginViewFail(String error);
    }
    //module层
    public interface LoginModuleLayer{
        void loginUser(Map<String, String> param, LoginModuleCallBack loginModuleCallBack);
        interface LoginModuleCallBack{
            void loginModuleSuccess(LoginBean bean);
            void loginModuleFail(String error);
        }
    }
    //presenter层
    public interface LoginPresenterLayer{
        void loginUser(Map<String, String> param);
    }
}
