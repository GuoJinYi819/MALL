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
public class HomeMlssAdapter extends RecyclerView.Adapter<HomeMlssAdapter.MyViewHolder> {
    private    CommodiListBean.ResultBean.MlssBean mlss;
    private Context context;

    public HomeMlssAdapter(  CommodiListBean.ResultBean.MlssBean mlss, Context context) {
        this.mlss = mlss;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_msll_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        List<CommodiListBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList = mlss.getCommodityList();
        CommodiListBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = commodityList.get(position);
        String commodityName = commodityListBeanXX.getCommodityName();
        holder.tvName.setText(commodityName);
        int price = commodityListBeanXX.getPrice();
        holder.tvPrice.setText("￥"+price+".00");
        String masterPic = commodityListBeanXX.getMasterPic();
        Glide.with(context).load(masterPic)
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        int size = mlss.getCommodityList().size();
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
