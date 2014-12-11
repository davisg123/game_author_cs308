package engine.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import data.DataManager;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.FixedCollisionTypeAction;
import engine.actions.MakeNewObjectFromLocationAction;
import engine.actions.TranslateXType;
import engine.actions.TranslateYType;
import engine.actions.YVelocityIDAction;
import engine.conditions.BoundaryConditionY;
import engine.conditions.ButtonCondition;
import engine.conditions.ButtonConditionManager;
import engine.conditions.TimeCondition;
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
        GameObject floorRight = new GameObject(null,"floor.png",
                                   200, 200, 20, 200, 0, "floor_right");
        floorRight.setIdentifier(new Identifier("floor","a"));
        //ugh, why do we have to set this explicitly?
        PhysicsBody floorRightBody = new PhysicsBody(20,200);
        floorRightBody.setVelocity(new Velocity(0,-40));
        floorRightBody.addScalar((new CollisionConstant(1.0)));
        floorRight.setPhysicsBody(floorRightBody);
        
        GameObject floorLeft = new GameObject(null,"floor.png",
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
        GameObject ball = new GameObject(null,"ball.png",150,50,30,30,0,"ball_object");
        ball.setIdentifier(new Identifier("ball","a"));
        PhysicsBody ballBody = new PhysicsBody(30,30);
        ball.setPhysicsBody(ballBody);
        myBallObjects.add(ball);

        /******
         * conditions
         ******/

        ConditionsCollection myConditions = new ConditionsCollection();
        
        ArrayList<Identifier> ballIdList = new ArrayList<Identifier>();
        ballIdList.add(ball.getIdentifier());
        TranslateYType yVelAction = new TranslateYType("ball",1.0);
        ArrayList<Action> yVelActionList = new ArrayList<Action>();
        yVelActionList.add(yVelAction);
        TimeCondition myConstantVelocity = new TimeCondition(yVelActionList,1.0,true);
        myConstantVelocity.setIdentifier(new Identifier("time_cond","a"));
        myConditions.add(myConstantVelocity);
        
        Action aAct = new TranslateXType("ball",-2.0);
        //Action aAct = new MakeNewObjectFromLocationAction("ball",200.0,200.0);
        Action dAct = new TranslateXType("ball",2.0);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(aAct);
        ArrayList<KeyCode> kclA = new ArrayList<KeyCode>();
        kclA.add(KeyCode.A);
        ButtonCondition aCon = new ButtonCondition(actionList,kclA, 1.0, true);
        aCon.setIdentifier(new Identifier("button_cond","a"));
        ArrayList<Action> dActList = new ArrayList<Action>();
        dActList.add(dAct);
        ArrayList<KeyCode> kclD = new ArrayList<KeyCode>();
        kclD.add(KeyCode.D);
        ButtonCondition dCon = new ButtonCondition(dActList,kclD,1.0, true);
        dCon.setIdentifier(new Identifier("button_cond","d"));
        myConditions.add(aCon);
        myConditions.add(dCon);
        System.out.println(1);
        
        //collision stuff
        ArrayList<Action> ConditionActionList = new ArrayList<Action>();
        FixedCollisionTypeAction collisionAction = new FixedCollisionTypeAction("ball","floor",0.0);
        ConditionActionList.add(collisionAction);
        TypeCollisionCondition ballAndPlatformCollision = new TypeCollisionCondition(ConditionActionList,"ball","floor");
        ballAndPlatformCollision.setIdentifier(new Identifier("collision_cond","a"));
        myConditions.add(ballAndPlatformCollision);
        
        Action boundaryRightAction = new TranslateYType("floor",350.0);
        Action boundaryLeftAction = new TranslateYType("floor",350.0);
        ArrayList<Action> boundaryActionList = new ArrayList<Action>();
        boundaryActionList.add(boundaryLeftAction);
        boundaryActionList.add(boundaryRightAction);
        BoundaryConditionY boundaryCondition = new BoundaryConditionY(boundaryActionList,myFloorObjects.getIdentifierList(),-50.0,false);
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
        level0.setBackgroundMusic("Flappy_Bird_Theme_Song.mp3");
        level0.setBackgroundImage("Personnages-celebres-Troll-face-Troll-face-me-gusta-29215.jpg");
        myLevels.add(level0);
        
        /*
         * uncomment for saving game
         */
        
        GameData data = new GameData(myLevels,myConditions,allGameObjects);
        DataManager manager = new DataManager();
        try {
            manager.writeGameFile(data, "fd_final.json", Paths.get(".").toString()+"/src/data/games/fd_final/");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        /*******
         * game
         ******/
        myGameManager = new GameManager(myConditions,allGameObjects,myLevels,group,Paths.get(".").toString()+"/src/data/games/fd_final");
        myGameManager.initialize();
    }

}
