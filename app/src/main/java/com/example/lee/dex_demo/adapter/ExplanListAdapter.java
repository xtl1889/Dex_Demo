package com.example.lee.dex_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.lee.dex_demo.R;
import com.example.lee.dex_demo.modle.ExplanModle;

import java.util.List;

/**
 * Created by lianbinbo on 2016/12/6 16:03.
 */
public class ExplanListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<ExplanModle> mExplanModleList;

    public ExplanListAdapter(Context mContext, List<ExplanModle> mExplanModleList) {
        this.mContext = mContext;
        this.mExplanModleList = mExplanModleList;
    }


    /*获取组的个数*/
    @Override
    public int getGroupCount() {
        return mExplanModleList.size();
    }

    /*获取指定组中  子元素的个数*/
    @Override
    public int getChildrenCount(int groupPosition) {
        return mExplanModleList.get(groupPosition).getItemModleList().size();
    }

    /*获取指定组中是数据*/
    @Override
    public Object getGroup(int groupPosition) {
        return mExplanModleList.get(groupPosition);
    }

    /*获取指定组  子元素的数据*/
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mExplanModleList.get(groupPosition).getItemModleList().get(childPosition);
    }

    /*指定组的id*/
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /*指定组中  子元素的id*/
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /*组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们*/
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /*指定 组的视图对象*/
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
       GroupHolder groupHolder;
        if (convertView==null){
            groupHolder=new GroupHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.explan_group,null);
            groupHolder.tv= (TextView) convertView.findViewById(R.id.tv_group);
            convertView.setTag(groupHolder);
        }else {
            groupHolder= (GroupHolder) convertView.getTag();
        }
        groupHolder.tv.setText(mExplanModleList.get(groupPosition).getItem());
        return convertView;
    }

    /*指定 组中子元素的视图对象*/
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder;
        if (convertView==null){
            childHolder=new ChildHolder();
            convertView=LayoutInflater.from(mContext).inflate(R.layout.explan_child,null);
            childHolder.tv1= (TextView) convertView.findViewById(R.id.tv_childName);
            childHolder.tv2= (TextView) convertView.findViewById(R.id.tv_childWord);
            convertView.setTag(childHolder);
        }else {
            childHolder= (ChildHolder) convertView.getTag();
        }
        childHolder.tv1.setText(mExplanModleList.get(groupPosition).
                getItemModleList().get(childPosition).getName());
        childHolder.tv2.setText(mExplanModleList.get(groupPosition).
                getItemModleList().get(childPosition).getWord());
        return convertView;
    }

    /*是否选中指定位置上的子元素*/
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder{
        TextView tv;
    }
    class ChildHolder{
        TextView tv1;
        TextView tv2;
    }
}
