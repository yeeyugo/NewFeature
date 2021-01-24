package com.yee.feature.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.yee.feature.R;
import com.yee.feature.recycler.RecyclerAdapter;
import com.yee.feature.recycler.RecyclerGridDivider;
import com.yee.feature.ui.adapter.GridAdapter;
import com.yee.feature.ui.bean.GridBean;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    public static final String TAG = "GridActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);

        List<GridBean> data = new ArrayList<>();
//        data.add(new GridBean(0, R.drawable.header1));
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.yangmi1);
        images.add(R.drawable.yangmi2);
        images.add(R.drawable.yangmi3);
        images.add(R.drawable.yangmi4);
        images.add(R.drawable.yangmi5);
        images.add(R.drawable.yangmi6);
        images.add(R.drawable.yangmi7);
        images.add(R.drawable.yangmi8);
        images.add(R.drawable.yangmi9);
        images.add(R.drawable.yangmi10);
        images.add(R.drawable.yangmi11);
        images.add(R.drawable.yangmi12);
        images.add(R.drawable.yangmi13);
        images.add(R.drawable.yangmi14);
        images.add(R.drawable.yangmi15);
        images.add(R.drawable.yangmi16);
        images.add(R.drawable.yangmi17);
        images.add(R.drawable.yangmi18);
        images.add(R.drawable.yangmi19);
        images.add(R.drawable.yangmi20);
        for (int i = 0; i < images.size(); i++) {
            data.add(new GridBean(1, images.get(i)));
        }
//        data.add(new GridBean(10, 0));

        RecyclerView rvGrid = findViewById(R.id.rv_wrapper);
        rvGrid.setLayoutManager(new GridLayoutManager(this, 2,
                RecyclerView.VERTICAL, false));
        rvGrid.addItemDecoration(new RecyclerGridDivider(this));
        rvGrid.setItemAnimator(new DefaultItemAnimator());

        GridAdapter adapter = new GridAdapter(data);
        rvGrid.setAdapter(adapter);

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