package engine.sprite;

import engine.sprite.components.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;




/**
* 
* @author Arihant Jain
* @author Will Chang
*
*
*This class initiates a list of components which are characteristics of the sprite. 
*/
public class Sprite {
   protected List<SpriteComponent> myComponents; 
   
   //We have to have a default. 
   protected Point2D myPosition;
   
   /**
    * 
    */
   public Sprite () {
	   //TODO Temporary Fix for Location
	   this(new ArrayList<SpriteComponent>(), new Point2D.Double());
   }
   public Sprite (List<SpriteComponent> components, Point2D position) {
       myComponents = components;
       myPosition = position;
   }
   
   
   //TODO turn into iterator
   public List<SpriteComponent> getComponents(){
       return myComponents;
   }
   
   
   //temporarily deprecatedd
//   public void setNode(Node n){
//       myRenderedNode = n;
//   }
//    
   
   
	//TODO Check deprecation in the future for X and Y since we implemented Points...
	/**
	 * Sets X-Coordinate of Object
	 * 
	 * @param x - New X coordinate of Object
	 */
	public void setPosX (double xCoord) {
		myPosition.setLocation(xCoord, myPosition.getY());
	}

	/**
	 * Sets Y- Coordinate of Object
	 * 
	 * @param y - New Y coordinate of Object
	 */
	public void setPosY (double yCoord) {
		myPosition.setLocation(myPosition.getX(), yCoord);
	}


		/**
		 * Sets Location of object
		 * 
		 * @param point - new Location Point
		 */
		public void setPos (Point2D point){
			myPosition.setLocation(point);
		}

   
   
   /**
    * This method updates the component in the Sprite. 
    */
   public void update(){
        
   }
    
    
    
}