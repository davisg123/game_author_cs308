package engine.sprite;

import engine.sprite.components.*;
import java.util.List;


/**
* 
* @author ArihantJain
*
*
*This class initiates a list of components which are characteristics of the sprite. 
*/
public class Sprite {
   private State myState;
   private Layout myLayout;
   private PhysicsBody myPhysicsBody;
   
   /**
    * 
    */
   public Sprite (State state, Layout layout, PhysicsBody physicsBody) {
       myState = state;
       myLayout = layout;
       myPhysicsBody = physicsBody;
   }
    
   /**
    * This method updates the component in the Sprite. 
    */
   public void update(){
        
   }
    
    
    
}