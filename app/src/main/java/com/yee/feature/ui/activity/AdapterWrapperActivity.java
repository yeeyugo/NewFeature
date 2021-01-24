package com.yee.feature.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.yee.feature.R;
import com.yee.feature.recycler.RecyclerAdapter;
import com.yee.feature.ui.adapter.HeaderAdapter;
import com.yee.feature.ui.bean.FruitBean;
import com.yee.feature.ui.bean.HeaderBean;

import java.util.ArrayList;
import java.util.List;

public class AdapterWrapperActivity extends AppCompatActivity {
    public static final String TAG = "AdapterWrapperActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_wrapper);

        List<HeaderBean> data = new ArrayList<>();
        data.add(new HeaderBean(0, null));
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.fruit01);
        list.add(R.drawable.fruit02);
        list.add(R.drawable.fruit03);
        list.add(R.drawable.fruit04);
        list.add(R.drawable.fruit05);
        list.add(R.drawable.fruit06);
        list.add(R.drawable.fruit07);
        list.add(R.drawable.fruit08);
        list.add(R.drawable.fruit09);
        list.add(R.drawable.fruit10);
        list.add(R.drawable.fruit11);
        list.add(R.drawable.fruit12);
        list.add(R.drawable.fruit13);
        for (int i = 0; i < list.size(); i++) {
            data.add(new HeaderBean(1, new FruitBean(list.get(i),
                    "Fruit" + (i + 1), "这是第" + (i + 1) + "种水果！")));
        }
        data.add(new HeaderBean(10, null));
        HeaderAdapter adapter = new HeaderAdapter(data);

        RecyclerView rvWrapper = findViewById(R.id.rv_wrapper);
        rvWrapper.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false));
        rvWrapper.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        rvWrapper.setItemAnimator(new DefaultItemAnimator());
        rvWrapper.setAdapter(adapter);

        adapter.setRecyclerClickListener(new RecyclerAdapter.RecyclerClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i(TAG, "item click:" + position);
            }

            @Override
            public void onItemLongClick(int position) {
                Log.i(TAG, "item long click:" + position);
            }
        });
    }
}