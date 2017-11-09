package com.example.a32150.a2017110901;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by 32150 on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter {

    Context context;

    public MyAdapter(Context context)  {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
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
//        Method-1
//        TextView tv=new TextView(context);
//        tv.setTextSize(32);
//        tv.setText("Hi Micky"+i);
//        tv.setTextColor(Color.BLUE);
//        tv.setBackgroundColor(Color.CYAN);
//        return tv;

        //Method-2  自訂Layout
        LayoutInflater inflator = LayoutInflater.from(context);
        View v=inflator.inflate(R.layout.myitem, null);//Layout 解壓器
        TextView tv = (TextView)v.findViewById(R.id.textView);
        tv.setTextSize(32);
        tv.setText("Hi Micky"+i);



        return tv;
    }
}
