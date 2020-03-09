package com.bw.mall.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.mall.R;

import java.util.ArrayList;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/7 18:46
 * @Description: 用途：完成特定功能
 */
public class MyAdapter extends BaseAdapter {
    private  ArrayList<String> list = new ArrayList<>(  );
    int [] arr = {R.mipmap.account_informat11,R.mipmap.account_circle11,R.mipmap.zj,R.mipmap.qb,R.mipmap.dd};
    private Context context;
    public MyAdapter(ArrayList<String> list,Context context) {
        this.list.addAll( list );
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //优化
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context,R.layout.item_my,null);
            holder.iv = convertView.findViewById( R.id.ivPic );
            holder.tv = convertView.findViewById( R.id.tvTxt );
            convertView.setTag( holder );
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        String text = list.get( position );
        holder.tv.setText( text );
        holder.iv.setImageResource( arr[position] );
        return convertView;
    }

    class ViewHolder{
        private ImageView iv;
        private TextView tv;
    }
}
