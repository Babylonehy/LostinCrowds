/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: HandlePuzzle.java@author: jack@date: 5/21/19 2:10 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import com.example.lostincrowds.Crowds;
import com.example.lostincrowds.UI.MyImageView;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class HandlePuzzle {
    ArrayList<MyImageView> myImageViews=new ArrayList<>();
    Crowds crowds=new Crowds();
    public HandlePuzzle(ArrayList<MyImageView> puzzle){
        this.myImageViews=puzzle;
    }

    public void setMyImageViews(ArrayList<MyImageView> myImageViews) {
        this.myImageViews = myImageViews;
    }
    public void sethandle(){
        for (int i = 0; i <myImageViews.size() ; i++) {
            MyImageView myImageView=myImageViews.get(i);
            if (myImageView.getPercentage()==100){
                crowds.addInfector(myImageView.getViewId());
            }else{
                crowds.addPerson(myImageView.getViewId());
            }

        }

    }
}
