package com.dongnao.alvin.wraprecyclerview.horizontal;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dongnao.alvin.wraprecyclerview.R;
import com.dongnao.alvin.wraprecyclerview.normal.NormalRecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {
    List<String> data = new ArrayList<>();
    ItemClickListener mItemClickListener;

    Context context;

    public MyAdapter(Context context) {
        for (int i = 0; i < 19; i++) {
            data.add("i:" + i);
        }

        this.context = context;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Myholder myholder = new Myholder(LayoutInflater.from(context).inflate(R.layout.item_normal_vertical, parent, false));
        myholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v);
                }
            }
        });
        return myholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        Log.i(NormalRecyclerViewActivity.TAG, "position:" + position + ", holder.tv:"+holder.tv);
        holder.tv.setText(data.get(position));
        if (position % 2 == 0) {
            holder.tv.setBackgroundColor(Color.BLACK);
        } else {
            holder.tv.setBackgroundColor(Color.WHITE);
        }
        // 注意set tag 提供给点击事件使用
        holder.itemView.setTag(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View v);
    }

    public static class Myholder extends RecyclerView.ViewHolder {
        private TextView tv;

        public Myholder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}