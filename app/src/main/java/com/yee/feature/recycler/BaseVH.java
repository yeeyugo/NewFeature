package com.yee.feature.recycler;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by: Bean
 * Create on: 2021/1/23 22:28
 * Description:
 */
public class BaseVH extends RecyclerView.ViewHolder{
    private SparseArray<View> mViews;

    public BaseVH(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    public <T extends View> T getView(int id){
        View v = mViews.get(id);
        if(v == null){
            v = itemView.findViewById(id);
            mViews.put(id, v);
        }
        return (T)v;
    }

    //通用方法
    public BaseVH setText(int id, String value){
        TextView view = getView(id);
        view.setText(value);
        return this;
    }

    public BaseVH setImageRes(int viewId, int resId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    public BaseVH addOnClickListener(int viewId, View.OnClickListener onClickListener){
        View view = getView(viewId);
        view.setOnClickListener(onClickListener);
        return this;
    }

    public BaseVH addOnLongClickListener(int viewId, View.OnLongClickListener onLongClickListener){
        View view = getView(viewId);
        view.setOnLongClickListener(onLongClickListener);
        return this;
    }
}
