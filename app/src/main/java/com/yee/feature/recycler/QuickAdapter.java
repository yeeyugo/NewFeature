package com.yee.feature.recycler;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/23 21:25
 * Description:
 */
public abstract class QuickAdapter<T> extends RecyclerView.Adapter<QuickAdapter.VH>{
    private List<T> mData;
    private RecyclerClickListener recyclerClickListener;

    public QuickAdapter(List<T> data) {
        mData = data;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return VH.getVH(parent, getLayoutId(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        convert(holder, mData.get(position), position);
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
    public abstract int getLayoutId(int viewType);
    public abstract void convert(VH holder, T data, int position);

    //ViewHolder
    public static class VH extends RecyclerView.ViewHolder{
        private SparseArray<View> mViews;
        private View mConvertView;

        private VH(View v){
            super(v);
            mConvertView = v;
            mViews = new SparseArray<>();
        }

        public static VH getVH(ViewGroup parent, int layoutId){
            View convertView = LayoutInflater.from(parent.getContext())
                    .inflate(layoutId, parent, false);
            return new VH(convertView);
        }

        public <T extends View> T getView(int id){
            View v = mViews.get(id);
            if(v == null){
                v = mConvertView.findViewById(id);
                mViews.put(id, v);
            }
            return (T)v;
        }

        public VH setText(int id, String value){
            TextView view = getView(id);
            view.setText(value);
            return this;
        }

        public VH setImageRes(int viewId, int resId){
            ImageView imageView = getView(viewId);
            imageView.setImageResource(resId);
            return this;
        }

        public VH addOnClickListener(int viewId, View.OnClickListener onClickListener){
            View view = getView(viewId);
            view.setOnClickListener(onClickListener);
            return this;
        }

        public VH addOnLongClickListener(int viewId, View.OnLongClickListener onLongClickListener){
            View view = getView(viewId);
            view.setOnLongClickListener(onLongClickListener);
            return this;
        }
    }
}
