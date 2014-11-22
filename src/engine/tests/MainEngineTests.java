package engine.tests;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.LayoutAction;
import engine.actions.TranslateX;
import engine.actions.TranslateY;
import engine.conditions.ButtonConditionManager;
import engine.conditions.Condition;
import engine.conditions.TimeCondition;
import engine.gameObject.GameObject;
import engine.level.Level;
import engine.render.GameObjectRenderer;
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
        createGameObject(myRootGroup);
        
    }
    
    public void createGameObject (Group group) {
        Point2D location = new Point2D.Double(50,50);
        GameObject sprite = new GameObject(null,"slowpoke",
                                   location, 100, 100, 0, "TestGameObject");
        List<GameObject> myGameObjectList = new ArrayList<GameObject>();
        myGameObjectList.add(sprite);
        List<Condition> myConditionList = new ArrayList<Condition>();
        ButtonConditionManager buttonManager = new ButtonConditionManager();
        Action a = new TranslateX(sprite,-2.0);
        Action b = new TranslateX(sprite,2.0);
        Action c = new TranslateY(sprite,2.0);
        Action d = new TranslateY(sprite,-2.0);
        buttonManager.addBinding(KeyCode.A, a);
        buttonManager.addBinding(KeyCode.D, b);
        buttonManager.addBinding(KeyCode.S, c);
        buttonManager.addBinding(KeyCode.W, d);
        buttonManager.beginListeningToScene(myScene);
        ArrayList<Action> condList = new ArrayList<Action>();
        condList.add(c);
        Condition cond = new TimeCondition(condList,myGameObjectList,.5,true);
        myConditionList.add(buttonManager);
        myConditionList.add(cond);
        myGameManager = new GameManager(myConditionList,myGameObjectList,group);
        Level level0 = new Level();
        // Level level0 = new Level(myGameObjectList,null);
        GameObjectRenderer myGameObjectRenderer = new GameObjectRenderer(group);
        myGameObjectRenderer.renderGameObjects(level0);
        myGameManager.initialize();
    }

    
}
