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

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
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
        OrderListByBean.OrderListBean.DetailListBean detailListBean = detailList.get(0);
        String commodityName = detailListBean.getCommodityName();
        holder.tvCommodityName.setText(commodityName);
        int commodityPrice = detailListBean.getCommodityPrice();
        holder.tvCommodityPrice.setText("￥"+commodityPrice);
        String orderId = orderListBean.getOrderId();
        holder.tvOrderId.setText("订单号 "+orderId);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivCommodityPic;
        private TextView tvOrderId,tvCommodityName,tvCommodityPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCommodityPic = itemView.findViewById(R.id.ivCommodityPic);
            tvOrderId = itemView.findViewById(R.id.tvOrderId);
            tvCommodityName = itemView.findViewById(R.id.tvCommodityName);
            tvCommodityPrice = itemView.findViewById(R.id.tvCommodityPrice);
        }
    }
}
