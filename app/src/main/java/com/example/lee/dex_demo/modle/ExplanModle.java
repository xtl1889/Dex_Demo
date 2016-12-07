package com.example.lee.dex_demo.modle;

import java.util.List;

/**
 * Created by lianbinbo on 2016/12/6 16:08.
 */
public class ExplanModle {
    private String item;
    private List<ExplanItemModle> itemModleList;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public List<ExplanItemModle> getItemModleList() {
        return itemModleList;
    }

    public void setItemModleList(List<ExplanItemModle> itemModleList) {
        this.itemModleList = itemModleList;
    }

}
