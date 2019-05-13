package com.example.lostincrowds.UI;

import java.util.List;

public class Line {
    public double startX;
    public double startY;
    public double endX;
    public double endY;
    public boolean cut;

    public Line ( double startX , double startY , double endX , double endY , boolean cut ) {
        this.startX = startX;
        this.startY = startY;

        this.endX = endX;
        this.endY = endY;
        this.cut = cut;
    }

    public void setCut ( boolean cut ) {
        this.cut = cut;
    }

    public boolean isCut () {
        return cut;
    }

    public double getEndX () {
        return endX;
    }

    public double getEndY () {
        return endY;
    }

    public double getStartX () {
        return startX;
    }

    public double getStartY () {
        return startY;
    }

    public void setEndX ( double endX ) {
        this.endX = endX;
    }

    public void setEndY ( double endY ) {
        this.endY = endY;
    }

    public void setStartX ( double startX ) {
        this.startX = startX;
    }

    public void setStartY ( double startY ) {
        this.startY = startY;
    }
}