package com.example.lostincrowds.UI;

public class Item {
    public int color;
    public double percentage;
    public double locationX;
    public double locationY;

    public Item(int color, double percentage,double locationX, double locationY){
        this.color=color;
        this.percentage=percentage;
        this.locationX=locationX;
        this.locationY=locationY;

    }

    public void setLocationX(double x){
        locationX = x;
    }
    public void setLocationY(double x){
        locationY = x;
    }
    public void setPercentage(double x){percentage=x;}
    public void  setColor(int x){color=x;}

    public double getLocationX() {
        return locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getColor() {
        return color;
    }
}
