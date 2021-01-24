package com.yee.feature.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.yee.feature.R;
import com.yee.feature.recycler.RecyclerAdapter;
import com.yee.feature.recycler.RecyclerVH;
import com.yee.feature.ui.bean.MainBean;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/23 22:43
 * Description:
 */
public class MainActivityAdapter extends RecyclerAdapter<MainBean> {
    public static final String TAG = "MainActivityAdapter";

    public MainActivityAdapter(List<MainBean> data) {
        super(data);
    }

    @Override
    public int getItemViewType(int position) {
        int itemType = mData.get(position).getItemType();
        if (itemType == 0) {
            return TYPE_HEADER;
        } else if (itemType == 10) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ONE;
        }
    }

    @NonNull
    @Override
    public RecyclerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header,
                    parent, false);
        } else if (viewType == TYPE_FOOTER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer,
                    parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer,
                    parent, false);
        }
        return new RecyclerVH(view);
    }

    @Override
    public void bindData(RecyclerVH holder, MainBean data, int position) {
        if (data.getItemType() == TYPE_HEADER) {
            holder.addOnClickListener(R.id.iv_grid, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "click header...");
                }
            });
        } else if (data.getItemType() == TYPE_FOOTER) {
            holder.addOnLongClickListener(R.id.tv_footer, new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Log.i(TAG, "long click footer...");
                    return true;
                }
            });
        } else {
            holder.setText(R.id.tv_footer, data.getData());
        }
    }
}
