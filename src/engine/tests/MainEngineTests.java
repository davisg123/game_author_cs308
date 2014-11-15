package engine.tests;

import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainEngineTests extends Application {

    private GameManager myGameManager;
    private Stage myStage;
    private Group myRootGroup;
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start (Stage arg0) throws Exception {
        myStage = arg0;
        myStage.setTitle("");

        myRootGroup = new Group();

        Scene myScene = new Scene(myRootGroup,300,300);
        myStage.setScene(myScene);
        myStage.show();
        createSprite();
    }
    
    public void createSprite(){
        javafx.geometry.Point2D location = new Point2D(50,50);
        //Layout spriteLayout = new Layout(location,50.0,50.0);
        //Sprite sprite = new Sprite(null,spriteLayout,null);
        List<Sprite> mySpriteList = new ArrayList<Sprite>();
        //mySpriteList.add(sprite);
        myGameManager = new GameManager(null,mySpriteList,myRootGroup);
    }
    
}
