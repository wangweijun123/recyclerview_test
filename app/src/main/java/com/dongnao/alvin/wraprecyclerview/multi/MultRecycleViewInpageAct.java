package com.dongnao.alvin.wraprecyclerview.multi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dongnao.alvin.wraprecyclerview.R;

public class MultRecycleViewInpageAct extends AppCompatActivity {
    public static final String TAG = "wangweijun";
    RecyclerView verticalRecyclerview;
    RecyclerView horizontalRecyclerview;
    RecyclerView verticalRecyclerview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult_recycler_view);

        initVerticalRecycle();
        inithorizontalRecyclerview();
        initVerticalRecycle2();
    }

    private void initVerticalRecycle() {
        verticalRecyclerview = (RecyclerView) findViewById(R.id.verticalRecyclerview);
        verticalRecyclerview.setLayoutManager(
                LayoutManagerHelper.getLinearLayoutManager(getApplicationContext(), false));

        MyAdapter myAdapter  = new MyAdapter(getApplicationContext(), 20, MyAdapter.VERTICAT);
        myAdapter.setItemClickListener(new MyAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                Log.i(TAG, "getTag:" + (String)(v.getTag()));
            }
        });
        verticalRecyclerview.setAdapter(myAdapter);
        verticalRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Log.i(TAG, "onScrollStateChanged newState:" + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.i(TAG, "dx:" + dx+", dy:"+dy);

            }
        });
    }

    private void inithorizontalRecyclerview() {
        horizontalRecyclerview = (RecyclerView) findViewById(R.id.horizontalRecyclerview);
        // 横向
        horizontalRecyclerview.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//        horizontalRecyclerview.setLayoutManager(new GridLayoutManager(
//                getApplicationContext(), 3, LinearLayoutManager.HORIZONTAL,false));

//        verticalRecyclerview.setLayoutManager(new GridLayoutManager(
//                getApplicationContext(), 2));
        // 添加分割线  注意这里的context
//        DividerItemDecoration dividerItemDecoration =
//                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        verticalRecyclerview.addItemDecoration(dividerItemDecoration);

        MyAdapter myAdapter  = new MyAdapter(getApplicationContext(), 10, MyAdapter.HORIZONTAL);
        myAdapter.setItemClickListener(new MyAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                Log.i(TAG, "getTag:" + (String)(v.getTag()));
            }
        });
        horizontalRecyclerview.setAdapter(myAdapter);
        horizontalRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Log.i(TAG, "onScrollStateChanged newState:" + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.i(TAG, "dx:" + dx+", dy:"+dy);

            }
        });
    }

    private void initVerticalRecycle2() {
        verticalRecyclerview2 = (RecyclerView) findViewById(R.id.verticalRecyclerview2);
        //  纵向
        verticalRecyclerview2.setLayoutManager(LayoutManagerHelper.getLinearLayoutManager(getApplicationContext(), false));

        MyAdapter2 myAdapter  = new MyAdapter2(getApplicationContext(), 15, MyAdapter.HORIZONTAL);
        myAdapter.setItemClickListener(new MyAdapter2.ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                Log.i(TAG, "getTag:" + (String)(v.getTag()));
            }
        });
        verticalRecyclerview2.setAdapter(myAdapter);
        verticalRecyclerview2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Log.i(TAG, "onScrollStateChanged newState:" + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.i(TAG, "dx:" + dx+", dy:"+dy);

            }
        });
    }
}
