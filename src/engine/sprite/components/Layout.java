package engine.sprite.components;

import javafx.geometry.Point2D;

/**
 * 
 * @author ArihantJain
 * 
 * This Class holds Layout Information for Sprite;
 *
 */
public class Layout{
    private Point2D myLocation;
    private double myLocX = myLocation.getX();
    private double myLocY = myLocation.getY();
    private double mySizeHeight;
    private double mySizeWidth;


    public Layout(Point2D point, double height, double width){
        myLocX = point.getX();
        myLocY  = point.getY();;
        mySizeHeight = height;
        mySizeWidth = width;
    }


    /**
     * Sets X-Coordinate of Object
     * 
     * @param x - New X coordinate of Object
     */
    public void setPosX(double x){
        myLocX = x;
    }

    /**
     * Sets Y- Coordinate of Object
     * 
     * @param y - New Y coordinate of Object
     */
    public void setPosY(double y){
        myLocY = y;
    }


    /**
     * Sets Location of object
     * 
     * @param point - new Location Point
     */
    public void setPos(Point2D point){
        myLocation = point;
    }

    /**
     * Sets Height of object
     * 
     * @param h - Height of Object
     */
    public void setSizeHeight(double h){
        mySizeHeight = h;
    }

    /**
     * Sets Width of object
     * 
     * @param w - Width of Object
     */
    public void setSizeWidth(double w){
        mySizeWidth = w;
    }

    /**
     * Return X-Coordinate of Object
     * 
     * @return -  Y coordinate of Object
     */
    public double getPosX(){
        return myLocX;
    }

    /**
     * Return Y-Coordinate of Object
     * 
     * @return - returns Y coordinate of Object
     */
    public double getPosY(double y){
        return myLocY;
    }


    /**
     * Sets Location of object
     * 
     * @param point - new Location Point
     */
    public Point2D getPos(Point2D point){
        return myLocation;
    }

    /**
     * Sets Height of object
     * 
     * @param h - Height of Object
     */
    public double getSizeHeight(int h){
        return mySizeHeight;
    }

    /**
     * Sets Width of object
     * 
     * @param w - Width of Object
     */
    public double getSizeWidth(int w){
        return mySizeWidth;
    }


}