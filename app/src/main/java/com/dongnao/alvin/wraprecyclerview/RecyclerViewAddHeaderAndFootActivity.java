package com.dongnao.alvin.wraprecyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAddHeaderAndFootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_header_or_foot);
        WrapRecyclerView recyclerView = (WrapRecyclerView) findViewById(R.id.recycler_view);

        TextView headerView = new TextView(this);
        ViewGroup.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        headerView.setLayoutParams(layoutParams);
        headerView.setText("HeaderView");

        recyclerView.addHeaderView(headerView);
        TextView footerView = new TextView(this);
        layoutParams = new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        footerView.setLayoutParams(layoutParams);
        footerView.setText("FooterView");
        recyclerView.addFooterView(footerView);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i, "Item " + i);
        }
        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
