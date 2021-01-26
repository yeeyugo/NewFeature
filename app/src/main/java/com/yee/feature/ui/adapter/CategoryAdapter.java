package com.yee.feature.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.yee.feature.recycler.BaseVH;
import com.yee.feature.recycler.MultiAdapter;
import com.yee.feature.ui.bean.CategoryBean;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/26 7:54
 * Description:
 */
public class CategoryAdapter extends MultiAdapter<CategoryBean> {
    public CategoryAdapter(List<CategoryBean> data) {
        super(data);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @NonNull
    @Override
    public BaseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void bindData(BaseVH holder, CategoryBean data, int position) {

    }
}
