/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: MyAdapter.java@author: jack@date: 18/05/19 12:52 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.lostincrowds.Network.KvPair;

import java.util.ArrayList;

/**
 * The type My adapter.
 *
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: Xiang Li
 * @Date: $date$ $time$
 */
public class MyAdapter extends ArrayAdapter<KvPair> {

    /**
     * Instantiates a new My adapter.
     *
     * @param context  the context
     * @param layoutId the layout id
     * @param list     the list
     */
    public MyAdapter(Context context, int layoutId, ArrayList<KvPair> list) {
        super(context, layoutId, list);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        KvPair item = getItem(position);
        BoardItem boardItem = new BoardItem(getContext());
        boardItem.update(item.getKey().toString(), Integer.valueOf(item.getValue().toString()));
        return boardItem;
    }
}
