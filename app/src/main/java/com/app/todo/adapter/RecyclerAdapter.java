package com.app.todo.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.todo.R;
import com.app.todo.ui.ItemDetailsActivity;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements View.OnClickListener {
    Context context;
    AppCompatTextView textView;
    List<String> data;
    public RecyclerAdapter(Context context,List<String> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_todoitems,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);

        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView=(AppCompatTextView)itemView.findViewById(R.id.mytextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(), ItemDetailsActivity.class);

                    Bundle bundle=new Bundle();
                    bundle.putString("text",textView.getText().toString());
                    intent.putExtra("name",bundle);
                    itemView.getContext().startActivity(intent);
                    //Toast.makeText(itemView.getContext(),""+textView.getText().toString(), Toast.LENGTH_SHORT).show();
                    //AppCompatActivity activity= (AppCompatActivity) itemView.getContext();


                }
            });
        }
    }
}
