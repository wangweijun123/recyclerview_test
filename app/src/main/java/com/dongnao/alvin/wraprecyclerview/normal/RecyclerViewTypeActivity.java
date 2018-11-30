package com.dongnao.alvin.wraprecyclerview.normal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dongnao.alvin.wraprecyclerview.R;

public class RecyclerViewTypeActivity extends AppCompatActivity {
    public static final String TAG = "wangweijun";
    RecyclerView recyclerview;
    MyViewTypeAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_recycler_view);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        //  纵向
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        myAdapter  = new MyViewTypeAdapter(getApplicationContext());
        myAdapter.setItemClickListener(new MyViewTypeAdapter.ItemClickListener() {
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
