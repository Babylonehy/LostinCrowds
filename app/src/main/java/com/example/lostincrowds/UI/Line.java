package com.example.lostincrowds.UI;

/**
 * The type Line.
 */
public class Line {
    /**
     * The Start x.
     */
    public double startX;
    /**
     * The Start y.
     */
    public double startY;
    /**
     * The End x.
     */
    public double endX;
    /**
     * The End y.
     */
    public double endY;
    /**
     * The Cut.
     */
    public boolean cut;

    /**
     * Instantiates a new Line.
     *
     * @param startX the start x
     * @param startY the start y
     * @param endX   the end x
     * @param endY   the end y
     * @param cut    the cut
     */
    public Line(double startX, double startY, double endX, double endY, boolean cut) {
        this.startX = startX;
        this.startY = startY;

        this.endX = endX;
        this.endY = endY;
        this.cut = cut;
    }

    /**
     * Is cut boolean.
     *
     * @return the boolean
     */
    public boolean isCut() {
        return cut;
    }

    /**
     * Sets cut.
     *
     * @param cut the cut
     */
    public void setCut(boolean cut) {
        this.cut = cut;
    }

    /**
     * Gets end x.
     *
     * @return the end x
     */
    public double getEndX() {
        return endX;
    }

    /**
     * Sets end x.
     *
     * @param endX the end x
     */
    public void setEndX(double endX) {
        this.endX = endX;
    }

    /**
     * Gets end y.
     *
     * @return the end y
     */
    public double getEndY() {
        return endY;
    }

    /**
     * Sets end y.
     *
     * @param endY the end y
     */
    public void setEndY(double endY) {
        this.endY = endY;
    }

    /**
     * Gets start x.
     *
     * @return the start x
     */
    public double getStartX() {
        return startX;
    }

    /**
     * Sets start x.
     *
     * @param startX the start x
     */
    public void setStartX(double startX) {
        this.startX = startX;
    }

    /**
     * Gets start y.
     *
     * @return the start y
     */
    public double getStartY() {
        return startY;
    }

    /**
     * Sets start y.
     *
     * @param startY the start y
     */
    public void setStartY(double startY) {
        this.startY = startY;
    }
}
