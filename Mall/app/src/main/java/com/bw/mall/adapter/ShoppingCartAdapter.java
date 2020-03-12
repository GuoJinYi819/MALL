package com.bw.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.mall.R;
import com.bw.mall.bean.EventBean;
import com.bw.mall.bean.ShoppingCartBean;
import com.bw.mall.customview.MyCounterView;
import com.bw.mall.net.GlideUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/9 20:31
 * @Description: 用途：完成特定功能
 */
public class ShoppingCartAdapter extends BaseExpandableListAdapter {
    //展示数据
    private List<ShoppingCartBean.ResultBean> result = new ArrayList<>();
    //上下文
    private Context context;

    //构造传参
    public ShoppingCartAdapter(List<ShoppingCartBean.ResultBean> result, Context context) {
        this.result.addAll( result );
        this.context = context;
    }

    //外层个数
    @Override
    public int getGroupCount() {
        return result.size();
    }

    //内层个数
    @Override
    public int getChildrenCount(int groupPosition) {
        //获取内层个数
        ShoppingCartBean.ResultBean resultBean = result.get( groupPosition );
        List<ShoppingCartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        return shoppingCartList.size();
    }

    //获取组对象
    @Override
    public Object getGroup(int groupPosition) {
        ShoppingCartBean.ResultBean resultBean = result.get( groupPosition );
        return resultBean;
    }

    //获取子对象
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ShoppingCartBean.ResultBean resultBean = result.get( groupPosition );
        List<ShoppingCartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        ShoppingCartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( childPosition );
        return shoppingCartListBean;
    }

    //获取组id       类似于辅助方法
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获取子组id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition + childPosition;
    }

    //没整明白
    @Override
    public boolean hasStableIds() {
        return true;
    }

    //创建外层视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        MyGroupViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new MyGroupViewHolder();
            //获取视图
            convertView = LayoutInflater.from( context ).inflate( R.layout.item_shopping_group, parent, false );
            //初始化控件
            viewHolder.checkBoxGroup = convertView.findViewById( R.id.checkBoxGroup );
            viewHolder.btnCategoryName = convertView.findViewById( R.id.btnCategoryName );
            //设置标签
            convertView.setTag( viewHolder );
        } else {
            //取出标签
            viewHolder = (MyGroupViewHolder) convertView.getTag();
        }
        //设置数据
        ShoppingCartBean.ResultBean resultBean = result.get( groupPosition );
        String categoryName = resultBean.getCategoryName();
        viewHolder.btnCategoryName.setText( categoryName );

        boolean isChecked = resultBean.getIsChecked();
        //设置当前checkbox状态
        viewHolder.checkBoxGroup.setChecked( isChecked );


        //组选
        viewHolder.checkBoxGroup.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                resultBean.setChecked( isChecked );
                List<ShoppingCartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
                for (int i = 0; i < shoppingCartList.size(); i++) {
                    ShoppingCartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( i );
                    shoppingCartListBean.setChecked( isChecked );
                }
                //内部刷新适配器
                EventBean eventBean = new EventBean();
                //传递当前外层集合
                eventBean.setResult( result );
                //发送Eventbus
                EventBus.getDefault().postSticky( eventBean );

                notifyDataSetChanged();


            }
        } );


        //返回视图
        return convertView;
    }

    //优化
    class MyGroupViewHolder {
        private CheckBox checkBoxGroup;
        private Button btnCategoryName;
    }


    //创建内层视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        MyChildViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new MyChildViewHolder();
            convertView = LayoutInflater.from( context ).inflate( R.layout.item_shopping_child, parent, false );
            viewHolder.ivPic = convertView.findViewById( R.id.ivPic );
            viewHolder.tvCommodityName = convertView.findViewById( R.id.tvCommodityName );
            viewHolder.tvPrice = convertView.findViewById( R.id.tvPrice );
            viewHolder.checkBoxChild = convertView.findViewById( R.id.checkBoxChild);
            viewHolder.mycounterView = convertView.findViewById( R.id.mycounterView);
            convertView.setTag( viewHolder );
        }else {
            viewHolder = (MyChildViewHolder) convertView.getTag();
        }
        ShoppingCartBean.ResultBean resultBean = result.get( groupPosition );
        List<ShoppingCartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        ShoppingCartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( childPosition );
        //获取商品名
        String commodityName = shoppingCartListBean.getCommodityName();
        //设置商品名
        viewHolder.tvCommodityName.setText( commodityName );

        String pic = shoppingCartListBean.getPic();
        //Glide框架请求图片
        GlideUtil instance = GlideUtil.getInstance();
        instance.setImg( pic,viewHolder.ivPic );
        int price = shoppingCartListBean.getPrice();
        //设置价格
        viewHolder.tvPrice.setText( "￥"+price );

        boolean isChecked = shoppingCartListBean.getIsChecked();
        //设置当前checkbox状态
        viewHolder.checkBoxChild.setChecked( isChecked );

        viewHolder.checkBoxChild.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                shoppingCartListBean.setChecked( isChecked );

                EventBean eventBean = new EventBean();
                //传递当前外层集合
                eventBean.setResult( result );
                //发送Eventbus
                EventBus.getDefault().postSticky( eventBean );
                notifyDataSetChanged();
            }
        } );

        //获取当前商品数量
        int count = shoppingCartListBean.getCount();
        viewHolder.mycounterView.tvNumber.setText( String.valueOf( count ) );

        viewHolder.mycounterView.setOnNumberListener( new MyCounterView.OnNumberListener() {
            @Override
            public void onNumber(int num) {
                //设置上当前数量
                shoppingCartListBean.setCount( num );  //这里埋一颗炸弹
                //传递当前外层集合
                EventBean eventBean = new EventBean();
                eventBean.setResult( result );
                //发送Eventbus
                EventBus.getDefault().postSticky( eventBean );

            }
        } );


        return convertView;
    }

    class MyChildViewHolder {
        private ImageView ivPic;
        private TextView tvCommodityName;
        private TextView tvPrice;
        private CheckBox checkBoxChild;
        private MyCounterView mycounterView;
    }

    //可选择
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public List<ShoppingCartBean.ResultBean> getResult() {
        return result;
    }


}
