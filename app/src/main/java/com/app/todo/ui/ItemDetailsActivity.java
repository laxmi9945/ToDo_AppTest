package com.app.todo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.app.todo.R;

/**
 * Created by bridgeit on 31/3/17.
 */

public class ItemDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todoitemsdetails);
        AppCompatTextView textView=(AppCompatTextView)findViewById(R.id.resulttextView);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("name");

        if(bundle!=null)
        {

            String data =(String) bundle.get("text");
            textView.setText(data);
        }
    }
}
