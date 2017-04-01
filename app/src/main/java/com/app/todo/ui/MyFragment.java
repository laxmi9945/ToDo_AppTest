package com.app.todo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.todo.R;

/**
 * Created by bridgeit on 31/3/17.
 */

public class MyFragment extends Fragment {
    String st;
    public MyFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_todoitemsdetails,container,false);

        AppCompatTextView textView=(AppCompatTextView)view.findViewById(R.id.resulttextView);
        textView.setText(st);
        return view;
    }

    public static MyFragment newInstance(String st) {

        Bundle args = new Bundle();
        st=st;
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
