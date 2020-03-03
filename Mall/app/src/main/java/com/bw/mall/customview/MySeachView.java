package com.bw.mall.customview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.mall.R;

import androidx.annotation.Nullable;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/3 14:50
 * @Description: 用途：搜索框
 */
public class MySeachView extends LinearLayout {
    private OnSeachListener onSeachListener;
    public EditText etSeach;

    public MySeachView(Context context) {
        super(context);
        init(context);
    }

    public void setOnSeachListener(OnSeachListener onSeachListener) {
        this.onSeachListener = onSeachListener;
    }

    public MySeachView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MySeachView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    //初始化
    private void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.view_myseach, this, true);
        ImageView ivSeach = view.findViewById(R.id.ivSeach);
        etSeach = view.findViewById(R.id.etSeach);
        ImageView btSeach = view.findViewById(R.id.btSeach);

        btSeach.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                etSeach.setHint("请输入要查询的内容");
                etSeach.setBackgroundResource(R.drawable.a);
                etSeach.setVisibility(VISIBLE);
                String content = etSeach.getText().toString().trim();
                onSeachListener.onSeach(content);
            }
        });
    }

    public interface OnSeachListener{
        void onSeach(String content);
    }

}
