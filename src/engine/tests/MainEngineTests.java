package engine.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.geometry.Point2D;
import engine.GameManager;
import engine.sprite.Sprite;
import engine.sprite.components.Layout;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainEngineTests extends Application {
    
    private Timeline myAnimation;
    private GameManager myGameManager;
    private static double DEFAULT_SPEED = 60.0;
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start (Stage arg0) throws Exception {
        createSprite();
        setGameSpeed(DEFAULT_SPEED,true);
    }
    
    public void createSprite(){
        javafx.geometry.Point2D location = new Point2D(50,50);
        Layout spriteLayout = new Layout(location,50.0,50.0);
        Sprite sprite = new Sprite(null,spriteLayout,null);
        List<Sprite> mySpriteList = new ArrayList<Sprite>();
        mySpriteList.add(sprite);
        myGameManager = new GameManager(null,mySpriteList);
        
        
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
           myGameManager.processFrame();
       }
   };
}
