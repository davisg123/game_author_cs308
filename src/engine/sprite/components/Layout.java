package engine.sprite.components;



import java.awt.Point;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;

import javafx.scene.Node;

/**
 * Contains Image of Sprite, its location, will be grouped with Physics body to be rendered.
 * @author ArihantJain
 * 
 * This Class holds a Layout State for Sprite;
 *
 */
public class Layout{
	private Point2D myLocation;
	private double mySizeHeight;
	private double mySizeWidth;
	private Node myRenderedNode;
	//TODO check to see how movement/orientation rendering works
	private Map<String, String> myImagePaths;
	private String myOrientation;

	public Layout (Point2D point, double height, double width, Map<String, String> imagePaths, String orientation){
		myLocation = point;
		mySizeHeight = height;
		mySizeWidth = width;
		myImagePaths = imagePaths;
		myOrientation = orientation;
		//TODO change this into own method...?
		
	}


//	/**
//	 *    
//	 * @return
//	 */
//	public Node getNode(){
//		return myRenderedNode;
//	}

	//TODO Check deprecation in the future for X and Y since we implemented Points...
		/**
		 * Sets X-Coordinate of Object
		 * 
		 * @param x - New X coordinate of Object
		 */
		public void setPosX (double xCoord) {
			myLocation.setLocation(xCoord, myLocation.getY());
		}

		/**
		 * Sets Y- Coordinate of Object
		 * 
		 * @param y - New Y coordinate of Object
		 */
		public void setPosY (double yCoord) {
			myLocation.setLocation(myLocation.getX(), yCoord);
		}


		/**
		 * Sets Location of object
		 * 
		 * @param point - new Location Point
		 */
		public void setPos (Point2D point){
			myLocation.setLocation(point);
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
			return myLocation.getX();
		}

		/**
		 * Return Y-Coordinate of Object
		 * 
		 * @return - returns Y coordinate of Object
		 */
		public double getPosY(){
			return myLocation.getY();
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
		public double getSizeHeight(){
			return mySizeHeight;
		}

		/**
		 * Sets Width of object
		 * 
		 * @param w - Width of Object
		 */
		public double getSizeWidth(){
			return mySizeWidth;
		}


}