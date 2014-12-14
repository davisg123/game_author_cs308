package engine.tests;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.DeleteTypeAction;
import engine.actions.FixedCollisionTypeAction;
import engine.actions.TranslateXRandomType;
import engine.actions.TranslateYType;
import engine.actions.XVelocityIDAction;
import engine.actions.YImpulseIDAction;
import engine.conditions.BoundaryConditionX;
import engine.conditions.BoundaryConditionY;
import engine.conditions.ButtonConditionManager;
import engine.conditions.ButtonPressCondition;
import engine.conditions.TimeCondition;
import engine.conditions.TypeCollisionCondition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import engine.physics.CollisionConstant;
import engine.physics.Gravity;
import engine.physics.GravityConstant;
import engine.physics.Velocity;

public class FallDownEngineTestFull extends Application {

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
    	
    	/*
    	 * 
    	 * 
    	 *  GAME OBJECT DECLARATION
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 */

    	/*****
         * create a sprite and put it in a collection
         *****/
        GameObjectsCollection myFloorObjects = new GameObjectsCollection();
        GameObjectsCollection myBallObjects = new GameObjectsCollection();
        // FLOOR OBJECTS
        GameObject floorRight = new GameObject(null,"floor.png",
                                   200, 200, 20, 400, 0, "floor_right");
        floorRight.setIdentifier(new Identifier("floor","a"));
        PhysicsBody floorRightBody = new PhysicsBody(20,220);
        floorRightBody.addScalar((new CollisionConstant(1.0)));
        floorRightBody.setVelocity(new Velocity(0.0, -200.0));
        floorRight.setPhysicsBody(floorRightBody);
        GameObject floorLeft = new GameObject(null,"floor.png", -50, 200, 20, 400, 0, "floor_left");
        floorLeft.setIdentifier(new Identifier("floor","b"));
        PhysicsBody floorLeftBody = new PhysicsBody(20,220);
        floorLeftBody.addScalar((new CollisionConstant(1.0)));
        floorLeftBody.setVelocity(new Velocity(0.0, -200.0));
        floorLeft.setPhysicsBody(floorLeftBody);
        //floorBody.setAcceleration(new Acceleration(0.0,-77.0));
        myFloorObjects.add(floorRight);
        myFloorObjects.add(floorLeft);
        
        //create a ball
        GameObject ball = new GameObject(null,"ball.png",50,150,30,30,0,"ball_object");
        ball.setIdentifier(new Identifier("ball","a"));
        PhysicsBody ballBody = new PhysicsBody(37,37);
        ballBody.addForce(new Gravity(0,1.0));
        ballBody.addScalar(new GravityConstant(45.0));
        ball.setPhysicsBody(ballBody);
        myBallObjects.add(ball);        

        /*
         * 
         * 
         * CONDITION DECLARATION
         * 
         * 
         * 
         */

        ConditionsCollection myConditions = new ConditionsCollection();
        ArrayList <Identifier> temp=new ArrayList();
        temp.add(ball.getIdentifier());
        ArrayList<Identifier> ballIdList = new ArrayList<Identifier>();
        ballIdList.add(ball.getIdentifier());

        ArrayList<Action> ballVelActionList = new ArrayList<Action>();
        Action xVelAction=new XVelocityIDAction(temp, 0.0);
        ballVelActionList.add(xVelAction);
        
        TimeCondition myConstantVelocity = new TimeCondition(ballVelActionList,1.0,true);
        myConstantVelocity.setIdentifier(new Identifier("time_cond","a"));
        myConditions.add(myConstantVelocity);
        
        Action aAct = new XVelocityIDAction(temp, -150.0);
        Action dAct = new XVelocityIDAction(temp , 150.0);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(aAct);
        ArrayList<KeyCode> kclA = new ArrayList<KeyCode>();
        kclA.add(KeyCode.A);
        ButtonPressCondition aCon = new ButtonPressCondition(actionList,kclA, 1.0, true);
        aCon.setIdentifier(new Identifier("button_cond","a"));
        ArrayList<Action> dActList = new ArrayList<Action>();
        dActList.add(dAct);
        ArrayList<Action> testList = new ArrayList<Action>();
        
        ArrayList<KeyCode> kclN = new ArrayList<KeyCode>();
        kclN.add(KeyCode.N);
        ButtonPressCondition nCon = new ButtonPressCondition(testList, kclN, 5.0, true);
        nCon.setIdentifier(new Identifier("button_cond", "n"));
        ArrayList<KeyCode> kclD = new ArrayList<KeyCode>();
        kclD.add(KeyCode.D);
        ButtonPressCondition dCon = new ButtonPressCondition(dActList,kclD,1.0, true);
        dCon.setIdentifier(new Identifier("button_cond","d")); 
        Action delete = new DeleteTypeAction("floor");
        ArrayList<Action> actions = new ArrayList<Action>();
        actions.add(delete);
        ArrayList<KeyCode> kclH = new ArrayList<KeyCode>();
        kclH.add(KeyCode.H);
        ButtonPressCondition hCon = new ButtonPressCondition(actions, kclH, 1.0, true);
        hCon.setIdentifier(new Identifier("button_cond", "h"));
        myConditions.add(aCon);
        myConditions.add(dCon);
        myConditions.add(nCon);
        myConditions.add(hCon);
        
        ArrayList<Action> wActList = new ArrayList<Action>();
        List<Identifier> wActListId = myBallObjects.getIdentifierList();
        wActList.add(new YImpulseIDAction(wActListId,-200.0));
        ArrayList<KeyCode> kclW = new ArrayList<KeyCode>();
        kclW.add(KeyCode.W);
        ButtonPressCondition wCon = new ButtonPressCondition(wActList,kclW,100.0, true);
        wCon.setIdentifier(new Identifier("button_cond","w"));
        myConditions.add(wCon);
        
        //collision stuff
        ArrayList<Action> ConditionActionList = new ArrayList<Action>();
        FixedCollisionTypeAction collisionAction = new FixedCollisionTypeAction("ball","floor",0.0);
        ConditionActionList.add(collisionAction);
        TypeCollisionCondition ballAndPlatformCollision = new TypeCollisionCondition(ConditionActionList,"ball","floor");
        ballAndPlatformCollision.setIdentifier(new Identifier("collision_cond","a"));
        myConditions.add(ballAndPlatformCollision);
        
        ArrayList<Action> boundaryTopActionList = new ArrayList<Action>();
        Action shiftDown = new TranslateYType("floor", 300.0);
        Action shiftX = new TranslateXRandomType("floor", -100.0, 100.0);
        boundaryTopActionList.add(shiftDown);
        boundaryTopActionList.add(shiftX);
        
        BoundaryConditionY boundaryConditionTop = new BoundaryConditionY(boundaryTopActionList, myFloorObjects.getIdentifierList(), 0.0, false);
        boundaryConditionTop.setIdentifier(new Identifier("bound_cond", "bound_top"));
        myConditions.add(boundaryConditionTop);

        ArrayList<Action> stopBallLeftList = new ArrayList<Action>();
        Action stopBallLeftAction = new XVelocityIDAction(temp, 10.0);
        stopBallLeftList.add(stopBallLeftAction);
        
        ArrayList<Action> stopBallRightList = new ArrayList<Action>();
        Action stopBallRightAction = new XVelocityIDAction(temp, -10.0);
        stopBallRightList.add(stopBallRightAction);
        
        BoundaryConditionX boundaryConditionLeft = new BoundaryConditionX(stopBallLeftList, myBallObjects.getIdentifierList(), 0.0, false);
        boundaryConditionLeft.setIdentifier(new Identifier("bound_cond", "bound_left"));
        myConditions.add(boundaryConditionLeft);

		BoundaryConditionX boundaryConditionRight = new BoundaryConditionX(stopBallRightList, myBallObjects.getIdentifierList(), 270.0, true);
		boundaryConditionRight.setIdentifier(new Identifier("bound_cond", "bound_right"));
        myConditions.add(boundaryConditionRight);
        
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
        Level mainLevel = new Level(allGameObjects.getIdentifierList(),myConditions.getIdentifierList(),true);
        myLevels.add(mainLevel);
        
        /*
         * uncomment for saving game
         */
        /*
        GameData data = new GameData(myLevels,myConditions,allGameObjects);
        DataManager manager = new DataManager();
        try {
            manager.writeGameFile(data, "fd_final.json", Paths.get(".").toString()+"/src/data/games/fd_final/");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
        
        /*******
         * game
         ******/
        myGameManager = new GameManager(myConditions,allGameObjects,myLevels,group,Paths.get(".").toString()+"/src/data/games/fd_final");
        myGameManager.initialize();
    }

}
