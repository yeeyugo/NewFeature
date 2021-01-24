package com.yee.feature.recycler;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/23 22:36
 * Description:
 */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerVH>{
    //ItemType布局类型
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVER = 7;
    public static final int TYPE_EIGHT = 8;
    public static final int TYPE_NINE = 9;
    public static final int TYPE_FOOTER = 10;

    protected List<T> mData;
    private RecyclerClickListener recyclerClickListener;

    public RecyclerAdapter(List<T> data) {
        mData = data;
    }

    @Override
    public abstract int getItemViewType(int position);

    @NonNull
    @Override
    public abstract RecyclerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull RecyclerVH holder, int position) {
        bindData(holder, mData.get(position), position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerClickListener.onItemClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                recyclerClickListener.onItemLongClick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //Item点击事件
    public interface RecyclerClickListener{
        void onItemClick(int position);
        void onItemLongClick(int position);
    }
    public void setRecyclerClickListener(RecyclerClickListener recyclerClickListener) {
        this.recyclerClickListener = recyclerClickListener;
    }

    //抽象方法
    public abstract void bindData(RecyclerVH holder, T data, int position);
}
