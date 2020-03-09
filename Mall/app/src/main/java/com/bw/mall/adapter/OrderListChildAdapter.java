package com.bw.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
 * @version 创建时间：2020/3/5 20:59
 * @Description: 用途：完成特定功能
 */
public class OrderListChildAdapter extends RecyclerView.Adapter<OrderListChildAdapter.MyViewHolder> {
    private List<OrderListByBean.OrderListBean.DetailListBean> detailList = new ArrayList<>();
    private Context context;
    private OrderListByBean.OrderListBean orderListBean;

    public OrderListChildAdapter(List<OrderListByBean.OrderListBean.DetailListBean> detailList, Context context, OrderListByBean.OrderListBean orderListBean) {
        this.detailList.addAll( detailList );
        this.context = context;
        this.orderListBean = orderListBean;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item_orderlist_child, parent, false );
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OrderListByBean.OrderListBean.DetailListBean detailListBean = detailList.get( position );
        String commodityName = detailListBean.getCommodityName();
        holder.tvCommodityName.setText( commodityName );
        int commodityPrice = detailListBean.getCommodityPrice();
        holder.tvCommodityPrice.setText( "￥ "+commodityPrice );
        String commodityPic = detailListBean.getCommodityPic();
        String[] split = commodityPic.split( "," );
        Glide.with( context ).load( split[0] )
                .into( holder.ivCommodityPic );

        int orderStatus = orderListBean.getOrderStatus();
        switch (orderStatus){
            case 2:
                holder.tvMoneny.setVisibility( View.GONE );
                break;
            case 3:
                holder.tvMoneny.setText( "2020-0305" );
                break;
            case 9:
                holder.tvMoneny.setText( "2020-0305" );
                break;
            default:
                holder.tvMoneny.setText( "共"+detailList.size()+"件,共计"+detailListBean.getCommodityPrice()+"元" );
                break;
        }


    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCommodityPic;
        private TextView tvCommodityName;
        private TextView tvCommodityPrice;
        private TextView tvMoneny;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            ivCommodityPic = itemView.findViewById( R.id.ivCommodityPic );
            tvCommodityName = itemView.findViewById( R.id.tvCommodityName );
            tvCommodityPrice = itemView.findViewById( R.id.tvCommodityPrice );
            tvMoneny = itemView.findViewById( R.id.tvMoney );
        }
    }
}
