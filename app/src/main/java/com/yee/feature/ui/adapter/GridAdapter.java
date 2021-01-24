package com.yee.feature.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.yee.feature.R;
import com.yee.feature.recycler.MultiAdapter;
import com.yee.feature.recycler.BaseVH;
import com.yee.feature.ui.bean.GridBean;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/24 19:41
 * Description:
 */
public class GridAdapter extends MultiAdapter<GridBean> {
    public static final String TAG = "GridAdapter";
    public GridAdapter(List<GridBean> data) {
        super(data);
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = mData.get(position).getViewType();
        if (viewType == 0) {
            return TYPE_HEADER;
        } else if (viewType == 10) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ONE;
        }
    }

    @NonNull
    @Override
    public BaseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header,
                    parent, false);
        } else if (viewType == TYPE_FOOTER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer,
                    parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,
                    parent, false);
        }
        return new BaseVH(view);
    }

    @Override
    public void bindData(BaseVH holder, GridBean data, int position) {
        if (data.getViewType() == TYPE_HEADER) {
            holder.addOnClickListener(R.id.iv_grid, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "header click");
                }
            });
        } else if (data.getViewType() == TYPE_FOOTER) {
            holder.addOnLongClickListener(R.id.tv_footer, new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Log.i(TAG, "footer long click");
                    return true;
                }
            });
        } else {
            holder.setImageRes(R.id.iv_grid, data.getImageId())
                    .addOnClickListener(R.id.iv_grid, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i(TAG, "item inner image click");
                        }
                    });
        }
    }
}
