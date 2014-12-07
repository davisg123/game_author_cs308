package engine.tests;

import java.io.IOException;
import java.util.ArrayList;
import data.DataManager;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.TranslateXType;
import engine.actions.TranslateYType;
import engine.conditions.BoundaryConditionY;
import engine.conditions.ButtonCondition;
import engine.conditions.ButtonConditionManager;
import engine.conditions.TypeCollisionCondition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import engine.physics.CollisionConstant;
import engine.physics.Velocity;
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
        GameObjectsCollection myFloorObjects = new GameObjectsCollection();
        GameObjectsCollection myBallObjects = new GameObjectsCollection();
        //create the floor
        GameObject floorRight = new GameObject(null,"floor",
                                   200, 200, 20, 200, 0, "floor_right");
        floorRight.setIdentifier(new Identifier("floor","a"));
        //ugh, why do we have to set this explicitly?
        PhysicsBody floorRightBody = new PhysicsBody(20,200);
        floorRightBody.setVelocity(new Velocity(0,-40));
        floorRightBody.addScalar((new CollisionConstant(1.0)));
        floorRight.setPhysicsBody(floorRightBody);
        
        
        GameObject floorLeft = new GameObject(null,"floor",
                                               -50, 200, 20, 200, 0, "floor_left");
        floorLeft.setIdentifier(new Identifier("floor","b"));
        PhysicsBody floorLeftBody = new PhysicsBody(20,200);
        floorLeftBody.setVelocity(new Velocity(0,-40));
        floorLeftBody.addScalar((new CollisionConstant(1.0)));
        floorLeft.setPhysicsBody(floorLeftBody);
        //floorBody.setAcceleration(new Acceleration(0.0,-77.0));
        myFloorObjects.add(floorRight);
        myFloorObjects.add(floorLeft);
        
        //create a ball
        GameObject ball = new GameObject(null,"ball",150,50,30,30,0,"ball_object");
        ball.setIdentifier(new Identifier("ball","a"));
        PhysicsBody ballBody = new PhysicsBody(30,30);
        ballBody.setVelocity(new Velocity(0,10));
        ball.setPhysicsBody(ballBody);
        myBallObjects.add(ball);
        
        //create alt ball
        GameObject ball2 = new GameObject(null,"ball",250,50,30,30,0,"ball_object");
        ball2.setIdentifier(new Identifier("ball","b"));
        PhysicsBody ballBody2 = new PhysicsBody(30,30);
        ballBody2.setVelocity(new Velocity(0,10));
        ball2.setPhysicsBody(ballBody2);
        myBallObjects.add(ball2);
        
        /******
         * conditions
         ******/
        ConditionsCollection myConditions = new ConditionsCollection();
        Action aAct = new TranslateXType("ball",-2.0);
        Action dAct = new TranslateXType("ball",2.0);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(aAct);
        ArrayList<KeyCode> kclA = new ArrayList<KeyCode>();
        kclA.add(KeyCode.A);
        ButtonCondition aCon = new ButtonCondition(actionList,kclA);
        aCon.setIdentifier(new Identifier("button_cond","a"));
        ArrayList<Action> dActList = new ArrayList<Action>();
        dActList.add(dAct);
        ArrayList<KeyCode> kclD = new ArrayList<KeyCode>();
        kclD.add(KeyCode.D);
        ButtonCondition dCon = new ButtonCondition(dActList,kclD);
        dCon.setIdentifier(new Identifier("button_cond","d"));
        myConditions.add(aCon);
        myConditions.add(dCon);
        
        //collision stuff
        TypeCollisionCondition ballAndPlatformCollision = new TypeCollisionCondition(null,"ball","floor");
        ballAndPlatformCollision.setIdentifier(new Identifier("collision_cond","a"));
        myConditions.add(ballAndPlatformCollision);
        
        Action boundaryRightAction = new TranslateYType("floor",350);
        Action boundaryLeftAction = new TranslateYType("foor",350);
        ArrayList<Action> boundaryActionList = new ArrayList<Action>();
        boundaryActionList.add(boundaryLeftAction);
        boundaryActionList.add(boundaryRightAction);
        BoundaryConditionY boundaryCondition = new BoundaryConditionY(boundaryActionList,myFloorObjects.getIdentifierList(),-50,false);
        boundaryCondition.setIdentifier(new Identifier("bound_cond","a"));
        myConditions.add(boundaryCondition);
        
        /*
         //uncomment for play pause stuff
        Action pauseAct = new FrameRateAction(0.0);
        ArrayList<Action> pauseActList = new ArrayList<Action>();
        pauseActList.add(pauseAct);
        ButtonCondition pCon = new ButtonCondition(pauseActList,KeyCode.P);
        dCon.setIdentifier(new Identifier("button_cond","p"));
        Action playAct = new FrameRateAction(60.0);
        ArrayList<Action> playListAct = new ArrayList<Action>();
        playListAct.add(playAct);
        ButtonCondition uCon = new ButtonCondition(playListAct,KeyCode.U);
        dCon.setIdentifier(new Identifier("button_cond","u"));
        myConditions.add(pCon);
        myConditions.add(uCon);
        */
        
        GameObjectsCollection allGameObjects = new GameObjectsCollection();
        allGameObjects.addAll(myBallObjects);
        allGameObjects.addAll(myFloorObjects);

        /*******
         * levels
         *******/
        LevelsCollection myLevels = new LevelsCollection();
        Level level0 = new Level(allGameObjects.getIdentifierList(),myConditions.getIdentifierList(),true);
        myLevels.add(level0);
        
        /*
         * uncomment for saving game
         */
        
        GameData data = new GameData(myLevels,myConditions,allGameObjects);
        DataManager manager = new DataManager();
        try {
            manager.writeGameFile(data, "fd_final.json");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        /*******
         * game
         ******/
        myGameManager = new GameManager(myConditions,allGameObjects,myLevels,group);
        myGameManager.initialize();
    }

    
}
