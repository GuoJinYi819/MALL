package com.bw.mall;

import android.content.Intent;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.mall.base.BaseActivity;
import com.bw.mall.base.BaseFragment;
import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.LoginBean;
import com.bw.mall.mvp.login.ILoginContract;
import com.bw.mall.mvp.login.LoginPresenterImpl;
import com.bw.mall.net.ApiService;
import com.bw.mall.net.RetrofitUtil;
import com.bw.mall.net.SpUtil;

import java.util.HashMap;
import java.util.HashSet;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements ILoginContract.LoginViewLayer {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.ib_eye)
    ImageButton ibEye;
    @BindView(R.id.check_box)
    CheckBox checkBox;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private Unbinder butterknife;
    private int LOGIN = 200;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //绑定 butterknife
        butterknife = ButterKnife.bind(this);
        getCacheUser();

    }
    //点击事件
    @OnClick({R.id.ib_eye,R.id.check_box, R.id.tv_register, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_eye:
                //文本隐藏
                etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
            case R.id.check_box:
                //单选框
                break;
            case R.id.tv_register:
                //进入注册界面
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent,LOGIN);
                break;
            case R.id.btn_login:
                //登入
                String phone = etPhone.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("phone",phone);
                hashMap.put("pwd",pwd);
                presenter.loginUser(hashMap);
                break;
        }
        //小眼睛的长按事件
        ibEye.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //文本显示
                etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                //返回 false 执行点击事件
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == LOGIN){
            if (data != null) {
                String phone = data.getStringExtra("phone");
                String pwd = data.getStringExtra("pwd");
                etPhone.setText(phone);
                etPwd.setText(pwd);
            }
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenterImpl initPresenter() {
        return new LoginPresenterImpl();
    }


    @Override
    public void loginViewSuccess(LoginBean bean) {
        String message = bean.getMessage();
        if (message.contains("登陆失败,手机号或密码错误")) {
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        } else if(message.contains("登录成功")){
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
            //判断 记住密码是否选中
            boolean checked = checkBox.isChecked();

            SpUtil instance = SpUtil.getInstance();
            if (checked) {
                //存储到sp

                String phone = etPhone.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                instance.setCacheData(SpUtil.SP_PHONE,phone);
                instance.setCacheData(SpUtil.SP_PWD,pwd);
                instance.setCacheData(SpUtil.SP_BOOLEAN,checked);
            }else {
                instance.setCacheData(SpUtil.SP_BOOLEAN,checked);
            }
            Intent intent = new Intent(LoginActivity.this,HomePageActivity.class);
            startActivity(intent);
            //销毁当前页面
            finish();
        }
    }

    @Override
    public void loginViewFail(String error) {

    }

    private void getCacheUser(){
        //取出
        SpUtil instance = SpUtil.getInstance();
        boolean b = instance.getCachBoolean(SpUtil.SP_BOOLEAN);
        if (b) {
            String phone = instance.getCachData(SpUtil.SP_PHONE);
            String pwd = instance.getCachData(SpUtil.SP_PWD);
            boolean empty1 = TextUtils.isEmpty(phone);
            boolean empty2 = TextUtils.isEmpty(pwd);
            if(!(empty1||empty2)){
                checkBox.setChecked(true);
                etPhone.setText(phone);
                etPwd.setText(pwd);
            }
        }else{

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑  防止内存泄露
        if (butterknife != null) {
            butterknife.unbind();
        }
    }
}
