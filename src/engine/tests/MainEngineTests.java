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
import engine.physics.CollisionConstant;
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
        GameObjectsCollection myGameObjects = new GameObjectsCollection();
        //create the floor
        GameObject floor = new GameObject(null,"floor",
                                   75, 200, 20, 200, 0, "floor_object");
        //ugh, why do we have to set this explicitly?
        PhysicsBody floorBody = new PhysicsBody(20,200);
        floorBody.setVelocity(new Velocity(0,-23));
        floorBody.addScalar((new CollisionConstant(1.0)));
        //floorBody.setAcceleration(new Acceleration(0.0,-77.0));
        floor.setPhysicsBody(floorBody);
        myGameObjects.add(floor);
        //create a ball
        GameObject ball = new GameObject(null,"ball",150,50,30,30,0,"ball_object");
        PhysicsBody ballBody = new PhysicsBody(30,30);
        ballBody.setVelocity(new Velocity(12,20));
        ball.setPhysicsBody(ballBody);
        myGameObjects.add(ball);
        
        /******
         * conditions
         ******/
        ConditionsCollection myConditions = new ConditionsCollection();
        Action aAct = new TranslateX(floor,-2.0);
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
