package com.example.a32150.a2017110901;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listview);

        MyAdapter adapter = new MyAdapter(MainActivity.this);
        lv.setAdapter(adapter);
    }
}
