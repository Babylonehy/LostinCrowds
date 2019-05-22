/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: HandlePuzzle.java@author: jack@date: 5/21/19 2:10 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import com.example.lostincrowds.Crowds;
import com.example.lostincrowds.UI.MyImageView;

import java.util.ArrayList;

/**
 * The type Handle puzzle.
 */
public class HandlePuzzle {
    /**
     * The My image views.
     */
    ArrayList<MyImageView> myImageViews = new ArrayList<>();
    /**
     * The Crowds.
     */
    Crowds crowds = new Crowds();

    /**
     * Instantiates a new Handle puzzle.
     *
     * @param puzzle the puzzle
     */
    public HandlePuzzle(ArrayList<MyImageView> puzzle) {
        this.myImageViews = puzzle;
    }

    /**
     * Sets my image views.
     *
     * @param myImageViews the my image views
     */
    public void setMyImageViews(ArrayList<MyImageView> myImageViews) {
        this.myImageViews = myImageViews;
    }

    /**
     * Sets .
     */
    public void sethandle() {
        for (int i = 0; i < myImageViews.size(); i++) {
            MyImageView myImageView = myImageViews.get(i);
            if (myImageView.getPercentage() == 100) {
                crowds.addInfector(myImageView.getViewId());
            } else {
                crowds.addPerson(myImageView.getViewId());
            }

        }

    }
}
