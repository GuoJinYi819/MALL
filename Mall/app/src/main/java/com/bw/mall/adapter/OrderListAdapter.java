package com.bw.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.mall.R;
import com.bw.mall.base.OrderListByBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/4 21:35
 * @Description: 用途：完成特定功能
 */
public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {
    private List<OrderListByBean.OrderListBean> orderList = new ArrayList<>();
    private int status = 0;
    private Context context;

    public OrderListAdapter(List<OrderListByBean.OrderListBean> orderList, int status, Context context) {
        this.orderList.addAll(orderList);
        this.status = status;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_orderlist0, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OrderListByBean.OrderListBean orderListBean = orderList.get(position);
        List<OrderListByBean.OrderListBean.DetailListBean> detailList = orderListBean.getDetailList();

        disPlay( holder,orderListBean );
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( context );
        linearLayoutManager.setOrientation( LinearLayoutManager.VERTICAL );
        holder.recyclerChild.setLayoutManager( linearLayoutManager );

        OrderListChildAdapter orderListChildAdapter = new OrderListChildAdapter( detailList, context ,orderListBean);
        holder.recyclerChild.setAdapter( orderListChildAdapter );

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvOrderId,tvTime,tvExpressCompName,tvOrderIdd;
        private RecyclerView recyclerChild;
        private RelativeLayout relativeLayout,relativeLayout1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOrderId = itemView.findViewById(R.id.tvOrderId);
            recyclerChild = itemView.findViewById(R.id.recyclerChild);
            tvTime = itemView.findViewById( R.id.tvTime );
            relativeLayout = itemView.findViewById( R.id.relativeLayout );
            relativeLayout1 = itemView.findViewById( R.id.relativeLayout1 );
            tvExpressCompName = itemView.findViewById( R.id.tvExpressCompName ); //快递
            tvOrderIdd = itemView.findViewById( R.id.tvOrderIdd ); //快递单号
        }
    }

    //根据status 切换状态
    private void disPlay(MyViewHolder holder, OrderListByBean.OrderListBean orderListBean){
        int orderStatus = orderListBean.getOrderStatus();
        switch (orderStatus){
            case 0:{
                String orderId = orderListBean.getOrderId();
                holder.tvOrderId.setText("订单号 "+orderId);
                long orderTime = orderListBean.getOrderTime();
                String time = stampToDate( String.valueOf( orderTime ) );
                holder.tvTime.setText( time );

                holder.relativeLayout.setVisibility( View.GONE );
                break;}
            case 1:{
                String orderId = orderListBean.getOrderId();
                holder.tvOrderId.setText("订单号 "+orderId);
                long orderTime = orderListBean.getOrderTime();
                String time = stampToDate( String.valueOf( orderTime ) );
                holder.tvTime.setText( time );

                holder.relativeLayout.setVisibility( View.GONE );
                break;}
            case 2:{
                String orderId = orderListBean.getOrderId();
                holder.tvOrderId.setText("订单号 "+orderId);
                long orderTime = orderListBean.getOrderTime();
                String time = stampToDate( String.valueOf( orderTime ) );
                holder.tvTime.setText( time );
                String expressCompName = orderListBean.getExpressCompName();
                holder.tvExpressCompName.setText( "派件公司  "+expressCompName );
                String orderId1 = orderListBean.getOrderId();
                holder.tvOrderIdd.setText( "快递单号  "+orderId1 );
                holder.relativeLayout1.setVisibility( View.GONE );
                holder.relativeLayout.setVisibility( View.VISIBLE );
                break;}
            case 3:
                String orderId = orderListBean.getOrderId();
                holder.tvOrderId.setText("订单号 "+orderId);
                long orderTime = orderListBean.getOrderTime();

                String time = stampToDate( String.valueOf( orderTime ) );
                holder.tvTime.setText( "···" );
                holder.relativeLayout1.setVisibility( View.GONE );
                holder.relativeLayout.setVisibility( View.GONE );
                break;
            case 9:
                holder.tvTime.setText( "···" );
                holder.relativeLayout1.setVisibility( View.GONE );
                holder.relativeLayout.setVisibility( View.GONE );
                break;
        }


    }



    //事件戳 转时间
    public String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

}
