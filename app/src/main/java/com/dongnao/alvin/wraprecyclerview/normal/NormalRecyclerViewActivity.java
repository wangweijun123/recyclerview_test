package com.dongnao.alvin.wraprecyclerview.normal;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dongnao.alvin.wraprecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class NormalRecyclerViewActivity extends AppCompatActivity {
    public static final String TAG = "wangweijun";
    RecyclerView recyclerview;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_recycler_view);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        //  纵向
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        // 横向
//        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerview.setLayoutManager(new GridLayoutManager(
//                getApplicationContext(), 3, LinearLayoutManager.VERTICAL,false));

//        recyclerview.setLayoutManager(new GridLayoutManager(
//                getApplicationContext(), 2));
        // 添加分割线  注意这里的context
//        DividerItemDecoration dividerItemDecoration =
//                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerview.addItemDecoration(dividerItemDecoration);

        myAdapter  = new MyAdapter(getApplicationContext());
        myAdapter.setItemClickListener(new MyAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                Log.i(TAG, "getTag:" + (String)(v.getTag()));
            }
        });
        recyclerview.setAdapter(myAdapter);
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
