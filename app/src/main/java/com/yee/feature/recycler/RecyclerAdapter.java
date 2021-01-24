package com.yee.feature.recycler;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

/**
 * Create by: Bean
 * Create on: 2021/1/23 22:36
 * Description:
 */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerVH>{
    //ItemType布局类型
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVER = 7;
    public static final int TYPE_EIGHT = 8;
    public static final int TYPE_NINE = 9;
    public static final int TYPE_FOOTER = 10;

    protected List<T> mData;
    private RecyclerClickListener recyclerClickListener;

    public RecyclerAdapter(List<T> data) {
        mData = data;
    }

    @Override
    public abstract int getItemViewType(int position);

    @NonNull
    @Override
    public abstract RecyclerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull RecyclerVH holder, int position) {
        bindData(holder, mData.get(position), position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerClickListener.onItemClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                recyclerClickListener.onItemLongClick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        //RecyclerView在开始观察该适配器时调用
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            //设置每个条目的跨度，如果有头布局，则占一整行，否则按设置的摆放
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    //每个position上的item占据的单元格个数
                    int viewType = getItemViewType(position);
                    switch (viewType) {
                        case TYPE_HEADER:
                        case TYPE_FOOTER:
                            return gridLayoutManager.getSpanCount();
                        default:
                            return 1;
                    }
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerVH holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            if (holder.getLayoutPosition() == 0) {
                StaggeredGridLayoutManager.LayoutParams lp =
                        (StaggeredGridLayoutManager.LayoutParams) layoutParams;
                //如果是瀑布流布局，则头布局占一整行
                lp.setFullSpan(true);
            }
        }
    }

    //Item点击事件
    public interface RecyclerClickListener{
        void onItemClick(int position);
        void onItemLongClick(int position);
    }
    public void setRecyclerClickListener(RecyclerClickListener recyclerClickListener) {
        this.recyclerClickListener = recyclerClickListener;
    }

    //抽象方法
    public abstract void bindData(RecyclerVH holder, T data, int position);
}
