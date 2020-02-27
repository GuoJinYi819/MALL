package com.bw.mall;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.mall.base.BaseActivity;
import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.RegisterBean;
import com.bw.mall.mvp.register.IRegisterContract;
import com.bw.mall.mvp.register.RegisterPresenterImpl;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterActivity extends BaseActivity<RegisterPresenterImpl> implements IRegisterContract.RegisterViewLayer {

    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_code)
    EditText editCode;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.ib_eye1)
    ImageButton ibEye1;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        //绑定 butterkinfe
        unbind = ButterKnife.bind(this);

    }
    //点击事件
    @OnClick({R.id.tv_code, R.id.ib_eye1, R.id.tv_register, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_code:

                break;
            case R.id.ib_eye1:
                //显示
                editPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
            case R.id.tv_register:
                finish();
                break;
            case R.id.btn_register:
                //注册
                String phone = editPhone.getText().toString().trim();
                String pwd = editPwd.getText().toString().trim();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("phone",phone);
                hashMap.put("pwd",pwd);
                presenter.registerUser(hashMap);
                break;
        }
        ibEye1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //文本显示
                editPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                //返回 false 执行点击事件
                return false;
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected RegisterPresenterImpl initPresenter() {
        return new RegisterPresenterImpl();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        if (unbind != null) {
            unbind.unbind();
        }
    }

    @Override
    public void registerViewSuccess(RegisterBean bean) {
        String message = bean.getMessage();
        if (message.contains("该手机号已注册，不能重复注册")) {
            editPhone.setText("");
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        }else if(message.contains("手机号格式错误")){
            editPhone.setText("");
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        }else if(message.contains("密码不符合规范")){
            editPwd.setText("");
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();

        }else if(message.contains("注册成功")){
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
            String phone = editPhone.getText().toString().trim();
            String pwd = editPwd.getText().toString().trim();
            Intent intent = new Intent();
            intent.putExtra("phone",phone);
            intent.putExtra("pwd",pwd);
            setResult(200,intent);
            finish();
            //注册成功
        }
    }

    @Override
    public void registerViewFail(String error) {
        Toast.makeText(this, "异常 ！！一定是手机坏了", Toast.LENGTH_SHORT).show();
    }
}
