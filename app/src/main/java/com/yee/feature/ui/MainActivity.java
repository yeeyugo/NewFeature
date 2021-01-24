package com.yee.feature.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.yee.feature.R;
import com.yee.feature.recycler.MultiAdapter;
import com.yee.feature.ui.activity.RecyclerActivity;
import com.yee.feature.ui.adapter.MainActivityAdapter;
import com.yee.feature.ui.bean.MainBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/23 21:22
 * Description:
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<MainBean> data = new ArrayList<>();
        data.add(new MainBean(0, null));
        List<String> list = new ArrayList<>();
        list.add("Androidx:RecyclerView");
        list.add("Androidx:viewBinding");
        list.add("Androidx:dataBinding");
        list.add("Androidx:Lifecycle");
        list.add("Androidx:LiveData");
        list.add("Androidx:ViewModel");
        list.add("Androidx:MVVM");
        for (int i = 0; i < list.size(); i++) {
            data.add(new MainBean(1, list.get(i)));
        }
        data.add(new MainBean(10, null));

        List<Class> classes = new ArrayList<>();
        classes.add(RecyclerActivity.class);

        MainActivityAdapter adapter = new MainActivityAdapter(data);

        RecyclerView rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false));
        rvMain.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        rvMain.setItemAnimator(new DefaultItemAnimator());
        rvMain.setAdapter(adapter);

        adapter.setRecyclerClickListener(new MultiAdapter.RecyclerClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i(TAG, "click: " + position);
                startActivity(new Intent(MainActivity.this, classes.get(position - 1)));
            }

            @Override
            public void onItemLongClick(int position) {
                Log.i(TAG, "long click: " + position);
            }
        });
    }
}