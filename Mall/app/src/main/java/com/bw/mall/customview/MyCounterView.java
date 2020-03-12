package com.bw.mall.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.mall.R;
import com.bw.mall.adapter.ShoppingCartAdapter;
import com.bw.mall.bean.EventBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;

/**
 * ClassName: MALL
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/10 20:31
 * @Description: 用途：完成特定功能
 */
public class MyCounterView extends LinearLayout {

    public TextView tvNumber;
    private OnNumberListener onNumberListener;

    public void setOnNumberListener(OnNumberListener onNumberListener) {
        this.onNumberListener = onNumberListener;
    }

    public MyCounterView(Context context) {
        super( context );
        init( context );
    }

    public MyCounterView(Context context, @Nullable AttributeSet attrs) {
        super( context, attrs );
        init( context );
    }

    public MyCounterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super( context, attrs, defStyleAttr );
        init( context );

    }


    private void init(Context context){
        View inflate = LayoutInflater.from( context ).inflate( R.layout.view_counter, this, true );
        TextView tvReduce = inflate.findViewById( R.id.tvReduce );
        TextView tvAdd = inflate.findViewById( R.id.tvAdd );
        tvNumber = inflate.findViewById( R.id.btnNumber );

        //减
        tvReduce.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = tvNumber.getText().toString();
                int i = Integer.parseInt( number );
                i--;
                if (i>=1) {
                    if (onNumberListener != null) {
                        //回调
                       int j=i;
                       if(j==1){
                           onNumberListener.onNumber( j );
                       }else {
                           onNumberListener.onNumber( --j );
                       }
                    }
                    tvNumber.setText( i+"" );
                }else {
                    Toast.makeText( context, "最小为1", Toast.LENGTH_SHORT ).show();
                }

            }
        } );
        //加
        tvAdd.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = tvNumber.getText().toString();
                int i = Integer.parseInt( number );

                if (onNumberListener != null) {
                    int j=i;
                    onNumberListener.onNumber( ++j );
                }

                i++;
                tvNumber.setText( i+"" );
            }
        } );

    }
    public interface OnNumberListener{
       void onNumber(int num);
    }
}
