package com.app.todo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.app.todo.R;
import com.app.todo.adapter.RecyclerAdapter;
import com.app.todo.baseclass.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgeit on 25/3/17.
 */

public class TodoItemsActivity extends BaseActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    boolean isView=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_recycler);
        initView();

        List<String> data = new ArrayList<>();

            data.add("WelCome to BridgeLabz ");
            data.add("Android was intended to be very customizable. And we welcome innovations.");
            data.add("Grab an iPhone, sit next to another iOS user and compare your home screens. Oh wait, they look exactly the same! That’s not the story with Android. ");
            data.add("hi ");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,data);
        recyclerView.setAdapter(recyclerAdapter);

    }
    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.myrecyclerView);
        setClicklistener();
    }

    @Override
    public void setClicklistener() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.changeview:
                if(!isView){
                    recyclerView.setLayoutManager(new GridLayoutManager(this,2));

                    isView = true;
                }
                else{
                    recyclerView.setLayoutManager(new GridLayoutManager(this,1));

                    isView = false;
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
