package com.bw.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.mall.R;
import com.bw.mall.bean.CommodityByKeyBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/3 21:46
 * @Description: 用途：完成特定功能
 */
public class HomeKeyWordAdapter extends RecyclerView.Adapter<HomeKeyWordAdapter.MyViewHolder> {
    private List<CommodityByKeyBean.ResultBean> result = new ArrayList<>();
    private Context context;

    public HomeKeyWordAdapter(List<CommodityByKeyBean.ResultBean> result, Context context) {
        this.result.addAll(result);
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_keyword_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CommodityByKeyBean.ResultBean resultBean = result.get(position);
        String commodityName = resultBean.getCommodityName();
        holder.keyName.setText(commodityName);
        int price = resultBean.getPrice();
        holder.tvPrice.setText("￥"+price);
        int saleNum = resultBean.getSaleNum();
        holder.tvNum.setText("已售"+saleNum+"件");
        String masterPic = resultBean.getMasterPic();
        Glide.with(context).load(masterPic)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(holder.ivKey);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivKey;
        private TextView keyName,tvPrice,tvNum;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivKey=itemView.findViewById(R.id.ivkey);
            keyName=itemView.findViewById(R.id.keyName);
            tvPrice=itemView.findViewById(R.id.keyPrice);
            tvNum=itemView.findViewById(R.id.tvNum);
        }
    }
}
