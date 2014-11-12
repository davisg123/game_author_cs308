package engine.sprite;

import engine.sprite.components.*;
import java.util.List;
import javafx.scene.Node;


/**
* 
* @author ArihantJain
*/k
*
*This class initiates a list of components which are characteristics of the sprite. 
*/
public class Sprite {
   private State myState;
   private Layout myLayout;
   private PhysicsBody myPhysicsBody;
   private Node myRenderedNode;
   
   /**
    * 
    */
   public Sprite (State state, Layout layout, PhysicsBody physicsBody) {
       myState = state;
       myLayout = layout;
       myPhysicsBody = physicsBody;
   }
   
   public Layout getLayout(){
       return myLayout;
   }
   
   public Node getNode(){
       return myRenderedNode;
   }
   
   public void setNode(Node n){
       myRenderedNode = n;
   }
    
   /**
    * This method updates the component in the Sprite. 
    */
   public void update(){
        
   }
    
    
    
}