package com.bw.mall.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bw.mall.R;
import com.bw.mall.adapter.ShoppingCartAdapter;
import com.bw.mall.base.BaseFragment;
import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.EventBean;
import com.bw.mall.bean.ShoppingCartBean;
import com.bw.mall.mvp.shoppingcart.IShoppingCartContract;
import com.bw.mall.mvp.shoppingcart.ShoppingCartPresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 16:15
 * @Description: 用途：2
 */
public class ShoppingFragment extends BaseFragment<ShoppingCartPresenterImpl, BasePresenter, BasePresenter> implements IShoppingCartContract.IShoppingCartView {
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.tvMoney)
    TextView tvMoney;
    @BindView(R.id.btnMoney)
    Button btnMoney;
    private Unbinder unbind;
    private ShoppingCartAdapter adapter;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected void initView(View view) {
        //ButterKnife
        unbind = ButterKnife.bind( this, view );
        boolean registered = EventBus.getDefault().isRegistered( this );
        if (!registered) {
            EventBus.getDefault().register( this );
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(EventBean bean){
        //接收消息
        //判空
        if (bean != null) {
            List<ShoppingCartBean.ResultBean> result = bean.getResult();
            //算钱
            accounts( result );
        }
    }

    @Override
    protected void initListener() {
        //状态改变监听
        checkBox.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //判空
                if (adapter != null) {
                    List<ShoppingCartBean.ResultBean> result = adapter.getResult();
                    for (int i = 0; i < result.size(); i++) {
                        ShoppingCartBean.ResultBean resultBean = result.get( i );
                        //设置改变状态  外层与当前全选按钮一致
                        resultBean.setChecked( isChecked );
                        List<ShoppingCartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
                        for (int j = 0; j < shoppingCartList.size(); j++) {
                            ShoppingCartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( j );
                            //设置改变状态  内层层与当前全选按钮一致
                            shoppingCartListBean.setChecked( isChecked );
                        }
                    }
                    //刷新适配器
                    adapter.notifyDataSetChanged();
                    accounts( result );
                }
            }
        } );
    }

    @Override
    protected void initData() {
        presenter1.getShoppingCart();
    }

    @Override
    protected ShoppingCartPresenterImpl initPresenter1() {
        return new ShoppingCartPresenterImpl();
    }

    @Override
    protected BasePresenter initPresenter2() {
        return null;
    }

    @Override
    protected BasePresenter initPresenter3() {
        return null;
    }

    @Override
    public void onSuccess(ShoppingCartBean bean) {
        //判空
        if (bean != null) {
            List<ShoppingCartBean.ResultBean> result = bean.getResult();
            //再判空
            if (result != null) {
                adapter = new ShoppingCartAdapter( result, getContext() );
                expandableListView.setAdapter( adapter );
                //设置默认 二级条目展开
                int groupCount = adapter.getGroupCount();
                for (int i = 0; i < groupCount; i++) {
                    expandableListView.expandGroup( i );
                }
            }
        }


    }

    @Override
    public void onFailed(String error) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
        EventBus.getDefault().unregister( this );
    }

    //算账方法
    private void accounts(List<ShoppingCartBean.ResultBean> result) {
        int sum = 0;
        double money = 0d;
        for (int i = 0; i < result.size(); i++) {
            ShoppingCartBean.ResultBean resultBean = result.get( i );
            List<ShoppingCartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                ShoppingCartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( j );
                //获取CheckBox状态
                boolean isChecked = shoppingCartListBean.getIsChecked();
                //根据选中的来累加金额
                if (isChecked) {
                    sum++;
                    int price = shoppingCartListBean.getPrice();
                    money += price;
                }
            }
        }
        //显示UI
        tvMoney.setText( "合计"+money);
        btnMoney.setText( "去付款("+sum+")" );
    }

}
