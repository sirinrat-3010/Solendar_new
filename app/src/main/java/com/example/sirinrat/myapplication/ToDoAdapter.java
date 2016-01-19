package com.example.sirinrat.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ToDoAdapter extends BaseAdapter {

    //Explicit
    private Context objContext;
    private String[] dateStrings, todoStrings;

    public ToDoAdapter(Context objContext, String[] dateStrings, String[] todoStrings) {
        this.objContext = objContext;
        this.dateStrings = dateStrings;
        this.todoStrings = todoStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return dateStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.activity_to_do_adapter, viewGroup, false);

        TextView dateTextView = (TextView) objView1.findViewById(R.id.textView12);
        dateTextView.setText(dateStrings[i]);

        TextView todoTextView = (TextView) objView1.findViewById(R.id.textView13);
        todoTextView.setText(todoStrings[i]);

        return objView1;
    }
}   // Main Class
