package com.dongnao.alvin.wraprecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dongnao.alvin.wraprecyclerview.normal.NormalRecyclerViewActivity;
import com.dongnao.alvin.wraprecyclerview.normal.RecyclerViewTypeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testNormalRecyclerView(View view) {
        startActivity(new Intent(getApplicationContext(), NormalRecyclerViewActivity.class));
    }

    public void testMultitypeView(View view) {
        startActivity(new Intent(getApplicationContext(), RecyclerViewTypeActivity.class));
    }


}
