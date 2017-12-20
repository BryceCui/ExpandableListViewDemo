package com.example.cuipengyu.expandablelistviewdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by mingren on 2017/12/20.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private String[] mGroupStrings;
    private String[][] mChildStrings;
    private Activity mActivity;
    ExpandableAdapter(Activity activity, String[] GroupStrings, String[][] ChildStrings) {
        this.mActivity = activity;
        this.mGroupStrings = GroupStrings;
        this.mChildStrings = ChildStrings;
    }
    //获取分组的个数
    @Override
    public int getGroupCount() {
        return mGroupStrings.length;
    }

    //获取子选项的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildStrings[groupPosition].length;
    }

    //获取分组数据
    @Override
    public Object getGroup(int groupPosition) {
        return mGroupStrings[groupPosition];
    }

    //获取子选项数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChildStrings[groupPosition][childPosition];
    }

    //获取分组的id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获取子选项的ID
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //指示子和组id是否在底层数据的更改之间保持稳定
    @Override
    public boolean hasStableIds() {
        return false;
    }

    //获取显示分组的视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHodler mGroupViewHodler;

        if (convertView == null) {
            mGroupViewHodler = new GroupViewHodler();
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.item_one, null, false);
            mGroupViewHodler.mTextView_one = convertView.findViewById(R.id.one_item);
            convertView.setTag(mGroupViewHodler);
        } else {
            mGroupViewHodler = (GroupViewHodler) convertView.getTag();
        }
        mGroupViewHodler.mTextView_one.setText(mGroupStrings[groupPosition]);
        return convertView;
    }

    //获取显示子选项的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHodler mChildViewHodler;
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.item_two, null, false);
            mChildViewHodler = new ChildViewHodler();
            mChildViewHodler.mTextView_two = convertView.findViewById(R.id.two_item);
            convertView.setTag(mChildViewHodler);
        } else {
            mChildViewHodler = (ChildViewHodler) convertView.getTag();
        }
        mChildViewHodler.mTextView_two.setText(mChildStrings[groupPosition][childPosition]);
        return convertView;
    }

    //指定子选项的元素是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public class GroupViewHodler {
        TextView mTextView_one;


    }

    public class ChildViewHodler {
        TextView mTextView_two;


    }
}
