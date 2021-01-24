package com.yee.feature.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.yee.feature.R;
import com.yee.feature.recycler.MultiAdapter;
import com.yee.feature.recycler.BaseVH;
import com.yee.feature.ui.bean.FruitBean;
import com.yee.feature.ui.bean.HeaderBean;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/24 14:26
 * Description:
 */
public class HeaderAdapter extends MultiAdapter<HeaderBean> {
    public static final String TAG = "HeaderAdapter";

    public HeaderAdapter(List<HeaderBean> data) {
        super(data);
    }

    @Override
    public int getItemViewType(int position) {
        HeaderBean headerBean = mData.get(position);
        if (headerBean.getItemType() == 0) {
            return TYPE_HEADER;
        } else if (headerBean.getItemType() == 10) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal,
                    parent, false);
        }
        if (view == null) {
            return null;
        }
        return new BaseVH(view);
    }

    @Override
    public void bindData(BaseVH holder, HeaderBean data, int position) {
        if (data == null) {
            return;
        }

        int viewType = getItemViewType(position);
        FruitBean fruit = data.getFruit();

        if (viewType == TYPE_HEADER) {
            holder.addOnClickListener(R.id.iv_grid, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "header was clicked! position=" + position);
                    holder.setImageRes(R.id.iv_grid, R.drawable.fruit01);
                }
            }).addOnLongClickListener(R.id.iv_grid, new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    holder.setImageRes(R.id.iv_grid, R.drawable.header1);
                    return true;
                }
            });
        } else if (viewType == TYPE_FOOTER) {
            holder.addOnLongClickListener(R.id.tv_footer, new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Log.i(TAG, "footer was long clicked!");
                    return true;
                }
            });
        } else {
            holder.setImageRes(R.id.iv_image, fruit.getImageId())
                    .addOnClickListener(R.id.iv_image, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i(TAG, "click image");
                        }
                    })
                    .setText(R.id.tv_title, fruit.getTitle())
                    .setText(R.id.tv_content, fruit.getContent());
        }
    }
}
