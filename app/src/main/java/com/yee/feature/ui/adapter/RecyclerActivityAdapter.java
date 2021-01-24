package com.yee.feature.ui.adapter;

import com.yee.feature.R;
import com.yee.feature.recycler.QuickAdapter;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/23 21:54
 * Description:
 */
public class RecyclerActivityAdapter extends QuickAdapter<String> {
    public RecyclerActivityAdapter(List<String> data) {
        super(data);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_footer;
    }

    @Override
    public void convert(VH holder, String data, int position) {
        holder.setText(R.id.tv_footer, data);
    }
}
