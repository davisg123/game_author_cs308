package engine.tests;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.LayoutAction;
import engine.actions.TransformX;
import engine.actions.TransformY;
import engine.conditions.ButtonConditionManager;
import engine.conditions.Condition;
import engine.level.Level;
import engine.render.SpriteRenderer;
import engine.sprite.Sprite;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainEngineTests extends Application {

    private GameManager myGameManager;
    private Stage myStage;
    private Scene myScene;
    private Group myRootGroup;
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start (Stage arg0) throws Exception {
        myStage = arg0;
        myStage.setTitle("");

        myRootGroup = new Group();

        myScene = new Scene(myRootGroup,300,300);
       /* ImageView view = new ImageView();
       
        Image image = new Image(getClass().getResourceAsStream("resources/images/slowpoke.jpg"));
        view.setImage(image);
        Group asdf = new Group();
        asdf.getChildren().add(view);
        myRootGroup.getChildren().add(asdf);*/
        myStage.setScene(myScene);
        myStage.show();
        createSprite(myRootGroup);
        
    }
    
    public void createSprite (Group group) {
        Point2D location = new Point2D.Double(50,50);
        Sprite sprite = new Sprite(null,"slowpoke",
                                   location, 100, 100, 0, "TestSprite");
        List<Sprite> mySpriteList = new ArrayList<Sprite>();
        mySpriteList.add(sprite);
        List<Condition> myConditionList = new ArrayList<Condition>();
        ButtonConditionManager buttonManager = new ButtonConditionManager();
        Action a = new TransformX(sprite,-2.0);
        Action b = new TransformX(sprite,2.0);
        Action c = new TransformY(sprite,2.0);
        Action d = new TransformY(sprite,-2.0);
        buttonManager.addBinding(KeyCode.A, a);
        buttonManager.addBinding(KeyCode.D, b);
        buttonManager.addBinding(KeyCode.S, c);
        buttonManager.addBinding(KeyCode.W, d);
        buttonManager.beginListeningToScene(myScene);
        myConditionList.add(buttonManager);
        myGameManager = new GameManager(myConditionList,mySpriteList,group);
        Level level0 = new Level(mySpriteList,null);
        SpriteRenderer mySpriteRenderer = new SpriteRenderer(group);
        mySpriteRenderer.renderSprites(level0);
        myGameManager.initialize();
        
    }

    
}
