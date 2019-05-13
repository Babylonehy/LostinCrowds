package com.example.lostincrowds.UI;

public class Item {
    public int color;
    public double percentage;
    public double locationX;
    public double locationY;

    public Item ( int color , double percentage , double locationX , double locationY ) {
        this.color = color;
        this.percentage = percentage;
        this.locationX = locationX;
        this.locationY = locationY;

    }

    public double getLocationX () {
        return locationX;
    }

    public void setLocationX ( double x ) {
        locationX = x;
    }

    public double getLocationY () {
        return locationY;
    }

    public void setLocationY ( double x ) {
        locationY = x;
    }

    public double getPercentage () {
        return percentage;
    }

    public void setPercentage ( double x ) {
        percentage = x;
    }

    public int getColor () {
        return color;
    }

    public void setColor ( int x ) {
        color = x;
    }
}
