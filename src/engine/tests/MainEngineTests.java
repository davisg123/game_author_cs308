package engine.tests;

import java.util.ArrayList;

import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.translate.TranslateX;
import engine.conditions.ButtonCondition;
import engine.conditions.ButtonConditionManager;
import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import engine.physics.Acceleration;
import engine.physics.Velocity;
import engine.render.GameObjectRenderer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class MainEngineTests extends Application {
    
    /**
     * @author Davis
     * 
     * the sandbox for engine
     * used to get stuff on the screen and keep engine team morale high
     */

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
        ButtonConditionManager.getInstance().beginListeningToScene(myScene);
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
        /*****
         * create a sprite and put it in a collection
         *****/
        GameObject sprite = new GameObject(null,"floor",
                                   75, 100, 20, 200, 0, "TestGameObject");
        //ugh, why do we have to set this explicitly?
        PhysicsBody body = new PhysicsBody(20,200);
        Velocity vel = new Velocity(5.0,0.0);
        body.setVelocity(vel);
        Acceleration ac=new Acceleration(100.0, 0.0);
        body.setAcceleration(ac);
        System.out.println(body.getAcceleration().getX());
        sprite.setPhysicsBody(body);
        GameObjectsCollection myGameObjects = new GameObjectsCollection();
        myGameObjects.add(sprite);
        /******
         * conditions
         ******/
        ConditionsCollection myConditions = new ConditionsCollection();
        Action aAct = new TranslateX(sprite,-2.0);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(aAct);
        ButtonCondition aCon = new ButtonCondition(actionList,"a_button",KeyCode.A);
        myConditions.add(aCon);
        
        /*******
         * levels
         *******/
        LevelsCollection myLevels = new LevelsCollection();
        Level level0 = new Level(myGameObjects);
        myLevels.add(level0);
        
        /*******
         * game
         ******/
        myGameManager = new GameManager(myConditions,myGameObjects,myLevels,group);
        
        GameObjectRenderer myGameObjectRenderer = new GameObjectRenderer(group);
        myGameObjectRenderer.renderGameObjects(level0);
        myGameManager.initialize();
    }

    
}
