package com.bw.mall.mvp.register;

import com.bw.mall.bean.RegisterBean;

import java.io.IOException;
import java.util.Map;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/27 14:52
 * @Description: 用途：完成特定功能
 */
public interface IRegisterContract {
    //view 层
      interface RegisterViewLayer{
        //成功
        void registerViewSuccess(RegisterBean bean);
        //失败
        void registerViewFail(String error);
    }
    //module层
      interface RegisterModuleLayer{
        void registerUser(Map<String,String> param, RegisterModuleCallBack registerModuleCallBack) throws IOException;
        interface RegisterModuleCallBack{
            void registerModuleSuccess(RegisterBean bean);
            void registerModuleFail(String error);
        }
    }
    //presenter层
      interface RegisterPresenterLayer{
        void registerUser(Map<String,String> param) throws IOException;
    }
}
