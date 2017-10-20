package com.example.lee.dex_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.lee.dex_demo.adapter.ExplanListAdapter;
import com.example.lee.dex_demo.modle.ExplanItemModle;
import com.example.lee.dex_demo.modle.ExplanModle;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<ExplanModle> mExplanModleList;
    private ExplanListAdapter mExplanListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setData();
        initView();
    }

    // 分支测试提交11111
    private void setData() {
        mExplanModleList=new ArrayList<>();
        ExplanModle explanModle;
        for (int i = 0; i < 4; i++) {
            List<ExplanItemModle> itemList=new ArrayList<>();
            explanModle=new ExplanModle();
            explanModle.setItem("Item--"+i);
            explanModle.setItemModleList(itemList);
            ExplanItemModle itemModle;
            for (int n = 0; n < i+1; n++) {
                itemModle=new ExplanItemModle();
                itemModle.setName(i+"--"+n+"--child");
                itemModle.setWord("Teemo");
                itemList.add(itemModle);
            }
            mExplanModleList.add(explanModle);
        }
    }
    //分支测试提交22222222222222

    // master 分支测试提交
    private void initView() {
        expandableListView= (ExpandableListView) findViewById(R.id.explanList);
        mExplanListAdapter=new ExplanListAdapter(this,mExplanModleList);
        expandableListView.setAdapter(mExplanListAdapter);
    }
}
