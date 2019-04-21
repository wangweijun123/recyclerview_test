package com.dongnao.alvin.wraprecyclerview.multi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * 创建日期：2018/9/21 0021 on 14:49
 * <p>
 * 描述: SwipeRefreshLayout 嵌套左右滑动的出现问题
 * 这个可以解决部分问题，严格来说还需要修改，暂且使用
 * <p>
 * 作者:yeagle
 */
public class MGSwipeRefreshLayout extends SwipeRefreshLayout {
    private float mPrevX;
    private int mTouchSlop;

    public MGSwipeRefreshLayout(@NonNull Context context) {
        super(context);
    }

    public MGSwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPrevX = MotionEvent.obtain(event).getX();
                break;

            case MotionEvent.ACTION_MOVE:
                final float eventX = event.getX();
                //获取水平移动距离
                float xDiff = Math.abs(eventX - mPrevX);
                //当水平移动距离大于滑动操作的最小距离的时候就认为进行了横向滑动
                //不进行事件拦截,并将这个事件交给子View处理
                if (xDiff > mTouchSlop) {
                    return false;
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.onInterceptTouchEvent(event);
    }
}
