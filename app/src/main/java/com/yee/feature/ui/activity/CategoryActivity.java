package com.yee.feature.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.yee.feature.R;
import com.yee.feature.ui.adapter.CategoryAdapter;
import com.yee.feature.ui.bean.CategoryBean;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        List<CategoryBean> data = new ArrayList<>();
        CategoryAdapter adapter = new CategoryAdapter(data);
        RecyclerView rvCategory = findViewById(R.id.rv_category);

        GridLayoutManager layoutManager = new GridLayoutManager(this,
                3, RecyclerView.VERTICAL, false);
        rvCategory.setLayoutManager(layoutManager);
        rvCategory.setAdapter(adapter);

        //在RecyclerView.setLayoutManager(layoutManager)之后再设置
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //返回每个item占用单位数量（每行spanCount个单位）
                int viewType = adapter.getItemViewType(position);
                if (viewType == adapter.TYPE_HEADER || viewType == adapter.TYPE_FOOTER ||
                        viewType == adapter.TYPE_ONE) {
                    return 3;
                } else {
                    int itemCount = 0;
                    if (itemCount == 1) {
                        return 3;
                    } else if (itemCount == 2) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            }
        });
    }
}