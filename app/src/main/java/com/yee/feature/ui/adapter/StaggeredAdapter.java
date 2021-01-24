package com.yee.feature.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.yee.feature.R;
import com.yee.feature.recycler.MultiAdapter;
import com.yee.feature.recycler.BaseVH;
import com.yee.feature.ui.bean.StaggeredBean;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/25 6:54
 * Description:
 */
public class StaggeredAdapter extends MultiAdapter<StaggeredBean> {
    public static final String TAG = "StaggerAdapter";

    public StaggeredAdapter(List<StaggeredBean> data) {
        super(data);
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = mData.get(position).getViewType();
        switch (viewType) {
            case 0:
                return TYPE_HEADER;
            case 10:
                return TYPE_FOOTER;
            default:
                return TYPE_ONE;
        }
    }

    @NonNull
    @Override
    public BaseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header,
                        parent, false);
                break;
            case TYPE_FOOTER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer,
                        parent, false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staggered,
                        parent, false);
        }
        return new BaseVH(view);
    }

    @Override
    public void bindData(BaseVH holder, StaggeredBean data, int position) {
        int viewType = data.getViewType();
        switch (viewType) {
            case TYPE_HEADER:
            case TYPE_FOOTER:
                break;
            default:
                holder.setImageRes(R.id.iv_staggered, data.getImageId())
                        .addOnLongClickListener(R.id.iv_staggered, new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Log.i(TAG, "image long click");
                                return true;
                            }
                        });
        }
    }
}
