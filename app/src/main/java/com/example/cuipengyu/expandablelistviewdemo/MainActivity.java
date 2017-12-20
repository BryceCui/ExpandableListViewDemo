package com.example.cuipengyu.expandablelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {
    public String[] groupStrings = {"小学", "初中", "高中", "大学"};
    public String[][] childStrings = {
            {"小学一年级", "小学二年级", "小学三年级", "小学四年级", "小学五年级"},
            {"初一", "初二", "初三", "初四"},
            {"高一", "高二", "高三"},
            {"大一", "大二", "大三", "大四"}
    };
    private ExpandableListView mExpandableListView;
    private ExpandableAdapter mExpandableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandableListView = findViewById(R.id.eListView);
        mExpandableAdapter = new ExpandableAdapter(this, groupStrings, childStrings);
        mExpandableListView.setAdapter(mExpandableAdapter);
//        mExpandableListView.setChildIndicator(null);  去除默认指示图标
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override

            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.e("sss", parent.toString() + "p");
                Log.e("sss", groupPosition + "g");
                Log.e("sss", childPosition + "c");
                Log.e("sss", id + "d");

                return false;
            }
        });

        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.e("sss1", groupPosition + "g");
                Log.e("sss1", id + "d");

                return false;
            }
        });
     

    }
}
