package com.yee.feature.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.yee.feature.R;
import com.yee.feature.recycler.BaseVH;
import com.yee.feature.recycler.MultiAdapter;
import com.yee.feature.ui.bean.FruitBean;
import com.yee.feature.ui.bean.RefreshBean;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/26 6:04
 * Description:
 */
public class SmartRefreshAdapter extends MultiAdapter<RefreshBean> {
    public static final String TAG = "SmartRefreshAdapter";

    public SmartRefreshAdapter(List<RefreshBean> data) {
        super(data);
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = mData.get(position).getViewType();
        switch (viewType) {
            case 0:
                return TYPE_HEADER;
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
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal,
                        parent, false);
        }
        return new BaseVH(view);
    }

    @Override
    public void bindData(BaseVH holder, RefreshBean data, int position) {
        int viewType = data.getViewType();
        switch (viewType) {
            case TYPE_HEADER:
                holder.setImageRes(R.id.iv_grid, data.getHeaderImageId())
                        .addOnClickListener(R.id.iv_grid, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i(TAG, "inner click header image");
                            }
                        });
                break;
            default:
                FruitBean fruit = data.getFruit();
                holder.setImageRes(R.id.iv_image, fruit.getImageId())
                        .setText(R.id.tv_title, fruit.getTitle())
                        .setText(R.id.tv_content, fruit.getContent())
                        .addOnLongClickListener(R.id.iv_image, new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Log.i(TAG, "inner long click item image");
                                return true;
                            }
                        });
        }
    }
}
