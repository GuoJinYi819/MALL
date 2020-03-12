package com.bw.mall.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.mall.R;
import com.bw.mall.bean.CircleListBean;
import com.bw.mall.net.GlideUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/12 20:48
 * @Description: 用途：完成特定功能
 */
public class CircleListAdapter extends RecyclerView.Adapter<CircleListAdapter.MyViewHolder> {
    private List<CircleListBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public CircleListAdapter(List<CircleListBean.ResultBean> result, Context context) {
        this.list.addAll( result );
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        for (int i = 0; i < list.size(); i++) {
            CircleListBean.ResultBean resultBean = list.get( i );
            String image = resultBean.getImage();
            if (image.contains( "," )) {
                String[] split = image.split( "," );
                int length = split.length;
                if (length == 2) {
                    view = LayoutInflater.from( context ).inflate( R.layout.item_circlelist_img2, parent, false );
                    break;
                } else if (length == 3) {
                    view = LayoutInflater.from( context ).inflate( R.layout.item_circlelist_img3, parent, false );
                    break;
                }
            } else if(TextUtils.isEmpty( image)){
                view = LayoutInflater.from( context ).inflate( R.layout.item_circlelist_img0, parent, false );
                break;
            }else {
                view = LayoutInflater.from( context ).inflate( R.layout.item_circlelist_img1, parent, false );
                break;
            }
        }
        MyViewHolder myViewHolder = new MyViewHolder( view );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CircleListBean.ResultBean resultBean = list.get( position );

        init(holder,resultBean);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHeadPic;
        private TextView tvNickName;
        private TextView tvCreateTime;
        private TextView tvContent;
        private ImageView ivImage1;
        private ImageView ivImage2;
        private ImageView ivImage3;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            ivHeadPic = itemView.findViewById( R.id.ivHeadPic );
            tvNickName = itemView.findViewById( R.id.tvNickName );
            tvCreateTime = itemView.findViewById( R.id.tvCreateTime );
            tvContent = itemView.findViewById( R.id.tvContent );
            ivImage1 = itemView.findViewById( R.id.ivImage1 );
            ivImage2 = itemView.findViewById( R.id.ivImage2 );
            ivImage3 = itemView.findViewById( R.id.ivImage3 );
        }
    }
    private void init( MyViewHolder holder,CircleListBean.ResultBean resultBean) {
        String image = resultBean.getImage();
        if (image.contains( "," )) {
            String[] split = image.split( "," );
            int length = split.length;
            if (length == 2) {
                String headPic = resultBean.getHeadPic();
                GlideUtil instance = GlideUtil.getInstance();
                instance.setImg( headPic,holder.ivHeadPic );

                String nickName = resultBean.getNickName();
                holder.tvNickName.setText( nickName );

                long createTime = resultBean.getCreateTime();

                String time = stampToDate( String.valueOf( createTime ) );
                holder.tvCreateTime.setText( time );


                String content = resultBean.getContent();
                holder.tvContent.setText( content );

                instance.setFilletImg( split[0],holder.ivImage1 );
                instance.setFilletImg( split[1],holder.ivImage2 );
            } else if (length == 3) {
                String headPic = resultBean.getHeadPic();
                GlideUtil instance = GlideUtil.getInstance();
                instance.setImg( headPic,holder.ivHeadPic );

                String nickName = resultBean.getNickName();
                holder.tvNickName.setText( nickName );

                long createTime = resultBean.getCreateTime();

                String time = stampToDate( String.valueOf( createTime ) );
                holder.tvCreateTime.setText( time );


                String content = resultBean.getContent();
                holder.tvContent.setText( content );

                instance.setFilletImg( split[0],holder.ivImage1 );
                instance.setFilletImg( split[1],holder.ivImage2 );
                instance.setFilletImg( split[2],holder.ivImage3 );
            }
        } else if(TextUtils.isEmpty( image)){
            String headPic = resultBean.getHeadPic();
            GlideUtil instance = GlideUtil.getInstance();
            instance.setImg( headPic,holder.ivHeadPic );

            String nickName = resultBean.getNickName();
            holder.tvNickName.setText( nickName );

            long createTime = resultBean.getCreateTime();
            String time = stampToDate( String.valueOf( createTime ) );
            holder.tvCreateTime.setText( time );

            String content = resultBean.getContent();
            holder.tvContent.setText( content );
        }else {
            String headPic = resultBean.getHeadPic();
            GlideUtil instance = GlideUtil.getInstance();
            instance.setImg( headPic,holder.ivHeadPic );

            String nickName = resultBean.getNickName();
            holder.tvNickName.setText( nickName );

            long createTime = resultBean.getCreateTime();

            String time = stampToDate( String.valueOf( createTime ) );
            holder.tvCreateTime.setText( time );

            String image1 = resultBean.getImage();
            instance.setImg( image1,holder.ivImage1 );

            String content = resultBean.getContent();
            holder.tvContent.setText( content );


        }

    }

    public String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt =new Long(s);
        Date date =new Date(lt);
        res = simpleDateFormat.format(date);
        return res;

    }

    public List<CircleListBean.ResultBean> getList() {
        return list;
    }
}
