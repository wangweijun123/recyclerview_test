package com.dongnao.alvin.wraprecyclerview.normal;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongnao.alvin.wraprecyclerview.R;

import java.util.ArrayList;
import java.util.List;

class MyViewTypeAdapter extends RecyclerView.Adapter<MyViewTypeAdapter.Myholder> {
    List<String> data = new ArrayList<>();
    ItemClickListener mItemClickListener;

    Context context;

    public static final int VIEW_TYPE_TEXT = 1;
    public static final int VIEW_TYPE_IMAGE = 2;

    MyViewTypeAdapter(Context context) {
        for (int i = 0; i < 40; i++) {
            data.add("i:" + i);
        }
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? VIEW_TYPE_TEXT : VIEW_TYPE_IMAGE;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Myholder myholder = null;
        switch (viewType) {
            case VIEW_TYPE_TEXT:
                myholder = new MyholderText(LayoutInflater.from(context).
                        inflate(R.layout.item_normal, parent, false));
                myholder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mItemClickListener != null) {
                            mItemClickListener.onItemClick(v);
                        }
                    }
                });
                break;
            case VIEW_TYPE_IMAGE:
                myholder = new MyholderImage(LayoutInflater.from(context).
                        inflate(R.layout.item_normal_image, parent, false));
                myholder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mItemClickListener != null) {
                            mItemClickListener.onItemClick(v);
                        }
                    }
                });
                break;
        }
        return myholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        int viewType = getItemViewType(position);
        Log.i(NormalRecyclerViewActivity.TAG, "position:" + position + ", viewType:" + viewType);
        switch (viewType) {
            case VIEW_TYPE_TEXT:
                MyholderText myholderText = (MyholderText) holder;
                myholderText.tv.setText(data.get(position));
                // 注意set tag 提供给点击事件使用
                holder.itemView.setTag(data.get(position));
                break;
            case VIEW_TYPE_IMAGE:
                MyholderImage myholderImage = (MyholderImage) holder;
                myholderImage.tv.setText(data.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }


    interface ItemClickListener {
        void onItemClick(View v);
    }

    static class Myholder extends RecyclerView.ViewHolder {
        public Myholder(View itemView) {
            super(itemView);
        }
    }

    static class MyholderText extends Myholder {
        private TextView tv;

        public MyholderText(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    static class MyholderImage extends Myholder {
        private ImageView iv;
        private TextView tv;

        public MyholderImage(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}