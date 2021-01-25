package com.yee.feature.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.scwang.smart.refresh.footer.BallPulseFooter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.BezierRadarHeader;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yee.feature.R;
import com.yee.feature.recycler.MultiAdapter;
import com.yee.feature.ui.adapter.SmartRefreshAdapter;
import com.yee.feature.ui.bean.FruitBean;
import com.yee.feature.ui.bean.RefreshBean;

import java.util.ArrayList;
import java.util.List;

public class SmartRefreshActivity extends AppCompatActivity {
    public static final String TAG = "SmartRefreshActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh);

        int[] images = {
                R.drawable.fruit01,
                R.drawable.fruit02,
                R.drawable.fruit03,
                R.drawable.fruit04,
                R.drawable.fruit05,
                R.drawable.fruit06,
                R.drawable.fruit07,
                R.drawable.fruit08,
                R.drawable.fruit09,
                R.drawable.fruit10,
                R.drawable.fruit11,
                R.drawable.fruit12,
                R.drawable.fruit13
        };

        List<RefreshBean> data = new ArrayList<>();
        data.add(new RefreshBean(0, R.drawable.header1, null));
        for (int i = 0; i < images.length; i++) {
            data.add(new RefreshBean(1, 0,
                    new FruitBean(images[i], "fruit" + (i + 1),
                            "This is the " + (i + 1) + "type fruit.")));
        }
        SmartRefreshAdapter adapter = new SmartRefreshAdapter(data);

        RecyclerView rvRefresh = findViewById(R.id.rv_refresh);
        rvRefresh.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false));
        rvRefresh.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        rvRefresh.setItemAnimator(new DefaultItemAnimator());
        rvRefresh.setAdapter(adapter);

        SmartRefreshLayout refreshLayout = findViewById(R.id.sf_refresh);
        refreshLayout.setRefreshHeader(new BezierRadarHeader(this));
        refreshLayout.setRefreshFooter(new BallPulseFooter(this));
//        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
//        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }
        });

        adapter.setRecyclerClickListener(new MultiAdapter.RecyclerClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i(TAG, "click:" + position);
            }

            @Override
            public void onItemLongClick(int position) {
                Log.i(TAG, "long click:" + position);
            }
        });
    }
}