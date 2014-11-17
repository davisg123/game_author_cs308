package engine;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import engine.conditions.*;
import engine.render.SpriteRenderer;
import engine.sprite.*;

/**
 * 
 * @author Davis
 *
 */

public class GameManager {
    private List<Condition> myGameConditions;
    private List<Sprite> myGameSprites;
    private SpriteRenderer mySpriteRenderer;
    private Group myRootGroup;
    private Timeline myAnimation;
    private Stage myStage;
    private static final double DEFAULT_SPEED = 60.0;
    
    
    public GameManager (List<Condition> myGameConditions, List<Sprite> myGameSprites, Group myRootGroup) {
        super();
        this.myGameConditions = myGameConditions;
        this.myGameSprites = myGameSprites;
        this.myRootGroup = myRootGroup;
        addFramesToGroup();
        setGameSpeed(DEFAULT_SPEED,true);
    }
    
    private void addFramesToGroup(){
        for (Sprite s : myGameSprites){
            //myRootGroup.getChildren().add(s.getNode());
        }
    }
    
    /**
    *
    * change the game speed
    *
    * @param speed
    *            speed of the simulation
    * @param play
    *            whether the animation should play after the speed change
    */
   public void setGameSpeed(double speed, boolean play) {
       // set game loop
       KeyFrame frame = new KeyFrame(Duration.millis(1000 / speed), oneFrame);
       if (myAnimation == null) {
           myAnimation = new Timeline();
       }
       myAnimation.stop();
       myAnimation.setCycleCount(Animation.INDEFINITE);
       myAnimation.getKeyFrames().clear();
       myAnimation.getKeyFrames().add(frame);
       if (play) {
           myAnimation.play();
       }
   }
   
   /**
    * Function to do each game frame
    */
   private EventHandler<ActionEvent> oneFrame = new EventHandler<ActionEvent>() {
       @Override
       public void handle(ActionEvent evt) {
           processFrame();
       }
   };

    /**
     * run updates on every sprite and every condition
     */
    public void processFrame(){
        //System.out.println("frame");
    }
}
