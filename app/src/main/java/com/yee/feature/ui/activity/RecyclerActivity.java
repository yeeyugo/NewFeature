package com.yee.feature.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.yee.feature.R;
import com.yee.feature.recycler.QuickAdapter;
import com.yee.feature.ui.adapter.RecyclerActivityAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    public static final String TAG = "RecyclerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        List<String> data = new ArrayList<>();
        data.add("装饰者模式添加header/footer");
        data.add("网格模式");
        data.add("瀑布流");
        data.add("结合SmartRefreshLayout");
        data.add("Grid分组展示");
        data.add("可展开的多级列表");
        data.add("添加emptyView");
        data.add("侧滑删除及拖拽");
        data.add("自定义ItemDecoration");
        data.add("多ItemType支持");
        data.add("在MVVM中绑定数据");
        data.add("自定义Animator");
        List<Class> list = new ArrayList<>();
        list.add(HeaderActivity.class);
        list.add(GridActivity.class);
        list.add(StaggeredActivity.class);
        list.add(SmartRefreshActivity.class);
        list.add(CategoryActivity.class);

        RecyclerActivityAdapter adapter = new RecyclerActivityAdapter(data);

        RecyclerView rvQuick = findViewById(R.id.rv_quick);
        rvQuick.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false));
        rvQuick.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        rvQuick.setItemAnimator(new DefaultItemAnimator());
        rvQuick.setAdapter(adapter);

        adapter.setRecyclerClickListener(new QuickAdapter.RecyclerClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i(TAG, "click: " + position);
                startActivity(new Intent(RecyclerActivity.this, list.get(position)));
            }

            @Override
            public void onItemLongClick(int position) {
                Log.i(TAG, "long click: " + position);
            }
        });
    }
}