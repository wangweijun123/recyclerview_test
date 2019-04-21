package com.dongnao.alvin.wraprecyclerview.multi;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

public class LayoutManagerHelper {

    public static LinearLayoutManager getLinearLayoutManager(Context context, final boolean canScrollVertically) {
        return new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return canScrollVertically;// 最重要的是这里
            }
        };
    }

    public static LinearLayoutManager getLinearLayoutManager(Context context, @RecyclerView.Orientation int orientation,
                                                             final  boolean canScrollVertically, final boolean canScrollHorizontal) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return canScrollVertically;
            }

            @Override
            public boolean canScrollHorizontally() {
                return canScrollHorizontal;
            }
        };
        linearLayoutManager.setOrientation(orientation);
        return linearLayoutManager;
    }

    public static GridLayoutManager getGridLayoutManager(Context context, int spanCount, final boolean canScrollVertically) {
        return new GridLayoutManager(context, spanCount) {
            @Override
            public boolean canScrollVertically() {
                return canScrollVertically;
            }
        };
    }

    public static void setRecyclerViewUpdate(RecyclerView recyclerView) {
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }
}
