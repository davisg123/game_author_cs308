package engine.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import data.DataManager;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.DeleteTypeAction;
import engine.actions.FixedCollisionTypeAction;
import engine.actions.ImpulseAction;
import engine.actions.MakeNewObjectFromLocationAction;
import engine.actions.MakeNewObjectFromObjectAction;
import engine.actions.TranslateXType;
import engine.actions.TranslateYType;
import engine.actions.XVelocityIDAction;
import engine.actions.YImpulseIDAction;
import engine.actions.YVelocityIDAction;
import engine.conditions.BoundaryConditionX;
import engine.conditions.BoundaryConditionY;
import engine.conditions.ButtonPressCondition;
import engine.conditions.ButtonConditionManager;
import engine.conditions.TimeCondition;
import engine.conditions.TypeCollisionCondition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.Component;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import engine.physics.CollisionConstant;
import engine.physics.Force;
import engine.physics.Gravity;
import engine.physics.GravityConstant;
import engine.physics.Vector;
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
        GameObjectsCollection myLabels = new GameObjectsCollection();
        
//        //create Labels for High scores, names, text etc
        GameObject labelText = new GameObject(null, "", 0,0,300,300,0,"label_Text");
        labelText.setIdentifier(new Identifier("LabelText","asdf"));
        labelText.setLabel("THIS IS A LABEL, DO WHAT YOU WANT");
       myLabels.add(labelText);
        
        //create the floor
        GameObject floorRight = new GameObject(null,"floor.png",
                                   200, 200, 20, 200, 0, "floor_right");
        floorRight.setIdentifier(new Identifier("floor","a"));
        //ugh, why do we have to set this explicitly?
        PhysicsBody floorRightBody = new PhysicsBody(20,200);
        floorRightBody.addScalar((new CollisionConstant(1.0)));
        floorRight.setPhysicsBody(floorRightBody);
        GameObject floorLeft = new GameObject(null,"floor.png",
                                               -50, 200, 20, 200, 0, "floor_left");
        floorLeft.setIdentifier(new Identifier("floor","b"));
        PhysicsBody floorLeftBody = new PhysicsBody(20,210);
        floorLeftBody.addScalar((new CollisionConstant(1.0)));
        floorLeft.setPhysicsBody(floorLeftBody);
        //floorBody.setAcceleration(new Acceleration(0.0,-77.0));
        myFloorObjects.add(floorRight);
        myFloorObjects.add(floorLeft);
        
        //create a ball
        GameObject ball = new GameObject(null,"ball.png",50,150,30,30,0,"ball_object");
        ball.setIdentifier(new Identifier("ball","a"));
        PhysicsBody ballBody = new PhysicsBody(37,37);
        ballBody.addForce(new Gravity(0,1.0));
        ballBody.addScalar(new GravityConstant(30.0));
        ball.setPhysicsBody(ballBody);
        myBallObjects.add(ball);
        
        //create a fireball
        GameObject fireball = new GameObject(null, "ball.png", 50,50, 10, 10, 0, "ball_object");
        fireball.setIdentifier(new Identifier("fireball", "template"));
        PhysicsBody fireballBody = new PhysicsBody(10, 10);
        fireball.setPhysicsBody(fireballBody);
        

        /******
         * conditions
         ******/

        ConditionsCollection myConditions = new ConditionsCollection();
        ArrayList <Identifier> temp=new ArrayList();
        temp.add(ball.getIdentifier());
        ArrayList<Identifier> ballIdList = new ArrayList<Identifier>();
        ballIdList.add(ball.getIdentifier());

        TranslateYType yVelAction = new TranslateYType("ball",1.0);
        Action fireballMove = new TranslateXType("fireball", 2.0);
        ArrayList<Action> yVelActionList = new ArrayList<Action>();
        yVelActionList.add(yVelAction);
        yVelActionList.add(fireballMove);

        //Action yVelAction = new YVelocityIDAction(temp,0.0);
        Action xVelAction=new XVelocityIDAction(temp, 0.0);
        //yVelActionList.add(yVelAction);
        yVelActionList.add(xVelAction);

        TimeCondition myConstantVelocity = new TimeCondition(yVelActionList,1.0,true);
        myConstantVelocity.setIdentifier(new Identifier("time_cond","a"));
        myConditions.add(myConstantVelocity);
        
       
        Action aAct = new XVelocityIDAction(temp, -100.0);
        //Action aAct = new MakeNewObjectFromLocationAction("ball",200.0,200.0);
        Action dAct = new XVelocityIDAction(temp ,100.0);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(aAct);
        ArrayList<KeyCode> kclA = new ArrayList<KeyCode>();
        kclA.add(KeyCode.A);
        ButtonPressCondition aCon = new ButtonPressCondition(actionList,kclA, 1.0, true);
        aCon.setIdentifier(new Identifier("button_cond","a"));
        ArrayList<Action> dActList = new ArrayList<Action>();
        dActList.add(dAct);
        ArrayList<Action> testList = new ArrayList<Action>(); 
        Action ballAct = new MakeNewObjectFromObjectAction("fireball", ball.getIdentifier());
        testList.add(ballAct);
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
        System.out.println(1);
        
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
        
        Action boundaryRightAction = new TranslateYType("floor",350.0);
        Action boundaryLeftAction = new TranslateYType("floor",350.0);
        ArrayList<Action> boundaryActionList = new ArrayList<Action>();
        boundaryActionList.add(boundaryLeftAction);
        boundaryActionList.add(boundaryRightAction);
        BoundaryConditionY boundaryCondition = new BoundaryConditionY(boundaryActionList,myFloorObjects.getIdentifierList(),-50.0,false);
        boundaryCondition.setIdentifier(new Identifier("bound_cond","a"));
        myConditions.add(boundaryCondition);
        
        Action boundaryScrollActionBall = new TranslateXType("ball",-1.0);
        Action boundaryScrollActionFloor = new TranslateXType("floor",-1.0);
        ArrayList<Action> scrollActionList = new ArrayList<Action>();
        scrollActionList.add(boundaryScrollActionBall);
        scrollActionList.add(boundaryScrollActionFloor);
        BoundaryConditionX boundaryConditionScroll = new BoundaryConditionX(scrollActionList,myBallObjects.getIdentifierList(),200.0,true);
        boundaryConditionScroll.setIdentifier(new Identifier("bound_scroll","a"));
        myConditions.add(boundaryConditionScroll);

        
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
        allGameObjects.add(fireball);
        allGameObjects.addAll(myLabels);


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
