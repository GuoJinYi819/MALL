package com.bw.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.mall.R;
import com.bw.mall.bean.CommodiListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/2 21:47
 * @Description: 用途：完成特定功能
 */
public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.MyViewHolder> {
    private  CommodiListBean.ResultBean.RxxpBean rxxp;
    private Context context;

    public HomeNewsAdapter( CommodiListBean.ResultBean.RxxpBean rxxp, Context context) {
        this.rxxp = rxxp;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        List<CommodiListBean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxp.getCommodityList();
        CommodiListBean.ResultBean.RxxpBean.CommodityListBean commodityListBean = commodityList.get(position);
        String commodityName = commodityListBean.getCommodityName();
        holder.tvName.setText(commodityName);
        int price = commodityListBean.getPrice();
        holder.tvPrice.setText("￥"+price+".00");
        String masterPic = commodityListBean.getMasterPic();
        Glide.with(context).load(masterPic)
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        int size = rxxp.getCommodityList().size();
        return size;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView tvName,tvPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.ivNews);
            tvName = itemView.findViewById(R.id.newsName);
            tvPrice = itemView.findViewById(R.id.newsPrice);
        }
    }
}
