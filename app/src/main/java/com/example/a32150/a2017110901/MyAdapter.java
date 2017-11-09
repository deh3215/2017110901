package com.example.a32150.a2017110901;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by 32150 on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter {

    Context context;
    public String str[];
    public boolean chk[];

    public MyAdapter(Context context, String[] str)  {
        this.context = context;
        this.str = str;
        chk = new boolean[str.length];
    }

    @Override
    public int getCount() {
        return str.length;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
//        Method-1
//        TextView tv=new TextView(context);
//        tv.setTextSize(32);
//        tv.setText("Hi Micky"+i);
//        tv.setTextColor(Color.BLUE);
//        tv.setBackgroundColor(Color.CYAN);
//        return tv;

//      Method-2  自訂Layout
        Log.d("GetView", "Position="+i);

        ViewHolder holder;
        LayoutInflater inflator = LayoutInflater.from(context);
        if(view == null)    {
            view = inflator.inflate(R.layout.myitem, null);//解出Layout 解壓器,消耗資源
            holder = new ViewHolder();
            holder.btn = (Button)view.findViewById(R.id.button);
            holder.tv = (TextView)view.findViewById(R.id.textView);
            holder.chk = (CheckBox)view.findViewById(R.id.checkBox);
            view.setTag(holder);//要加,不然listview滑動會當掉
        }   else    {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv.setTextSize(48);
        holder.tv.setText(str[i]);

        holder.btn.setText(str[i]);
        holder.btn.setTextSize(48);

        final String msg=str[i];

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });

        holder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
             chk[i]=b;
           }
       });
        holder.chk.setChecked(chk[i]);

//========以上resoure會經由回收機制,重複被使用,所以view的元件沒被更新的話,原本元件的狀態會被保留住,除非更新=======


        return view;
    }

    static class ViewHolder
    {
        TextView tv;
        Button btn;
        CheckBox chk;
    }


}
