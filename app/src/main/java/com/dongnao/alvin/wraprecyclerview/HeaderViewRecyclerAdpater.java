package com.dongnao.alvin.wraprecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by LK on 2017/6/15.
 * 动脑学院 版权所有
 */

public class HeaderViewRecyclerAdpater extends RecyclerView.Adapter{
    private ArrayList<View> mHeaderViewInfos = new ArrayList<>();
    private ArrayList<View> mFooterViewInfos = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;

    public HeaderViewRecyclerAdpater(ArrayList<View> headerViewInfos, ArrayList<View> footerViewInfos, RecyclerView.Adapter adapter) {
        mAdapter = adapter;
        if (mHeaderViewInfos == null) {
            mHeaderViewInfos = new ArrayList<>();
        } else {
            mHeaderViewInfos = headerViewInfos;
        }
        if (mFooterViewInfos == null) {
            mFooterViewInfos = new ArrayList<>();
        } else {
            mFooterViewInfos = footerViewInfos;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Headerview
        if (viewType == RecyclerView.INVALID_TYPE) {
            return new HeaderViewHolder(mHeaderViewInfos.get(0));
        } else if (viewType == RecyclerView.INVALID_TYPE - 1) { // FooterView
            return new HeaderViewHolder(mFooterViewInfos.get(0));
        }
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == RecyclerView.INVALID_TYPE) {
            return ;
        } else if (viewType == RecyclerView.INVALID_TYPE - 1) {
            return ;
        } else {
            mAdapter.onBindViewHolder(holder, position - mHeaderViewInfos.size());
        }

    }

    @Override
    public int getItemViewType(int position) {
        int numHeaders = mHeaderViewInfos.size();
        if (numHeaders > position) {
            return RecyclerView.INVALID_TYPE;
        }
        final int adjPosition = position - numHeaders;
        int adapterCOunt = 0;
        if (mAdapter != null) {
            adapterCOunt = mAdapter.getItemCount();
            if (adapterCOunt > adjPosition) {
                return mAdapter.getItemViewType(adjPosition);
            }
        }

        return RecyclerView.INVALID_TYPE - 1;
    }

    @Override
    public int getItemCount() {
        return mAdapter != null ? mAdapter.getItemCount() + mFooterViewInfos.size() + mHeaderViewInfos.size() :
                mFooterViewInfos.size() + mHeaderViewInfos.size() ;
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }
    private static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View view) {
            super(view);
        }
    }
}
