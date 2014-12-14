package games;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import data.DataManager;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.GeneralCollection;
import authoring.model.collections.LevelsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.DeleteIdAction;
import engine.actions.DeleteTypeAction;
import engine.actions.FixedCollisionTypeAction;
import engine.actions.ImpulseAction;
import engine.actions.MakeNewObjectFromLocationAction;
import engine.actions.MakeNewObjectFromObjectAction;
import engine.actions.MakeNewRandomObjectAction;
import engine.actions.TranslateXType;
import engine.actions.TranslateYType;
import engine.actions.XVelocityIDAction;
import engine.actions.XVelocityTypeAction;
import engine.actions.YImpulseIDAction;
import engine.actions.YVelocityIDAction;
import engine.actions.YVelocityTypeAction;
import engine.conditions.BoundaryConditionX;
import engine.conditions.BoundaryConditionY;
import engine.conditions.ButtonPressCondition;
import engine.conditions.ButtonConditionManager;
import engine.conditions.Condition;
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

public class MarioGameTest extends Application {
  
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

        myScene = new Scene(myRootGroup,400,400);
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
        GameObjectsCollection myPlatformObjects = new GameObjectsCollection();
        GameObjectsCollection myGoombaObjects = new GameObjectsCollection();
        GameObjectsCollection myMarioObjects = new GameObjectsCollection();
        GameObjectsCollection myLabels = new GameObjectsCollection();
        GameObjectsCollection myQuestionBlocksObjects = new GameObjectsCollection();
        GameObjectsCollection myMushroomObjects = new GameObjectsCollection();
        
        //Create button for Splash Screen
        
        
//        //create Labels for High scores, names, text etc
//        GameObject labelText = new GameObject(null, "", 0,0,200,100,0,"label_Text");
//        labelText.setIdentifier(new Identifier("LabelText","asdf"));
//        labelText.setLabel("THIS IS A LABEL, DO WHAT YOU WANT");
//       myLabels.add(labelText);
        
        //create the floor
        
        
        GameObject floor1 = new GameObject(null, "floor3.png", 
                                           1, 347, 8500.0, 800, 0, "FloorBlock1");
        floor1.setIdentifier(new Identifier("FloorBlock","a")); 
        PhysicsBody floor1Body = new PhysicsBody(8500,800);
        floor1Body.addScalar((new CollisionConstant(1.0)));
        floor1.setPhysicsBody(floor1Body);
        myFloorObjects.add(floor1);
        
        GameObject platform1 = new GameObject(null, "BrickBlock_NSMB.png", 
                                            300, 180, 50, 50, 0, "PlatformBlock1");
        platform1.setIdentifier(new Identifier("PlatformBlock","a")); 
        PhysicsBody platform1Body = new PhysicsBody(50,50);
        platform1Body.addScalar((new CollisionConstant(1.0)));
        platform1.setPhysicsBody(platform1Body);
        myPlatformObjects.add(platform1);
        
        GameObject platform2 = new GameObject(null, "BrickBlock_NSMB.png", 
                                              351, 180, 50, 50, 0, "PlatformBlock2");
        platform2.setIdentifier(new Identifier("PlatformBlock","b"));   
        PhysicsBody platform2Body = new PhysicsBody(50,50);
        platform2Body.addScalar((new CollisionConstant(1.0)));
        platform2.setPhysicsBody(platform2Body);
        myPlatformObjects.add(platform2);
        
        
        GameObject platform3 = new GameObject(null, "BrickBlock_NSMB.png", 
                                              402, 180, 50, 50, 0, "PlatformBlock2");
        platform3.setIdentifier(new Identifier("PlatformBlock","c")); 
        PhysicsBody platform3Body = new PhysicsBody(50,50);
        platform3Body.addScalar((new CollisionConstant(1.0)));
        platform3.setPhysicsBody(platform3Body);
        myPlatformObjects.add(platform3);

        GameObject platform4 = new GameObject(null, "BrickBlock_NSMB.png", 
                                              453, 180, 50, 50, 0, "PlatformBlock3");
        platform4.setIdentifier(new Identifier("PlatformBlock","d"));   
        PhysicsBody platform4Body = new PhysicsBody(50,50);
        platform4Body.addScalar((new CollisionConstant(1.0)));
        platform4.setPhysicsBody(platform4Body);
        myPlatformObjects.add(platform4);

        GameObject questionBlock1 = new GameObject(null, "Question Block.gif", 
                                              500, 180, 50, 50, 0, "QuestionBlock1");
        questionBlock1.setIdentifier(new Identifier("QuestionBlock","a"));   
        PhysicsBody questionBlock1Body = new PhysicsBody(50,50);
        questionBlock1Body.addScalar((new CollisionConstant(1.0)));
        questionBlock1.setPhysicsBody(questionBlock1Body);
        myQuestionBlocksObjects.add(questionBlock1);
        
        GameObject mushroom1 = new GameObject(null, "1-Up Mushroom.gif", 
                                                   500, 180, 50, 50, 0, "mushroom");
             mushroom1.setIdentifier(new Identifier("mushroom","template"));   
             PhysicsBody mushroom1Body = new PhysicsBody(50,50);
             mushroom1.setPhysicsBody(mushroom1Body);
             
             
        
        
        
        //create a player
        GameObject mario = new GameObject(null,"Mario.gif",200,50,30,30,0,"mario");
        mario.setIdentifier(new Identifier("mario","a"));
        PhysicsBody marioBody = new PhysicsBody(30,30);
        marioBody.addForce(new Gravity(0,1.0));
        marioBody.addScalar(new GravityConstant(10.0));
        mario.setPhysicsBody(marioBody);
        myMarioObjects.add(mario);
        
        //create a fireball
        GameObject fireball = new GameObject(null, "fireball.gif", 50,50, 10, 10, 0, "fireball");
        fireball.setIdentifier(new Identifier("fireball", "template"));
        PhysicsBody fireballBody = new PhysicsBody(10, 10);
        fireball.setPhysicsBody(fireballBody);
        
        //create enemies
        GameObject goomba = new GameObject(null,"Goomba.gif",200,150,30,30,0,"goomba");
        goomba.setIdentifier(new Identifier("goomba","template"));
        PhysicsBody goombaBody = new PhysicsBody(30,30);
        goombaBody.addForce(new Gravity(0,1.0));
        goombaBody.addScalar(new GravityConstant(10.0));
        goomba.setPhysicsBody(goombaBody);
        myGoombaObjects.add(goomba);
        
        GameObject goomba1 = new GameObject(null,"Goomba.gif",300,150,30,30,0,"goomba");
        goomba1.setIdentifier(new Identifier("goomba","a"));
        PhysicsBody goombaBody1 = new PhysicsBody(30,30);
        goombaBody1.addForce(new Gravity(0,1.0));
        goombaBody1.addScalar(new GravityConstant(10.0));
        goomba1.setPhysicsBody(goombaBody1);
        myGoombaObjects.add(goomba1);
        
        
        GameObject goomba2 = new GameObject(null,"Goomba.gif",400,150,30,30,0,"goomba");
        goomba2.setIdentifier(new Identifier("goomba","b"));
        PhysicsBody goombaBody2 = new PhysicsBody(30,30);
        goombaBody2.addForce(new Gravity(0,1.0));
        goombaBody2.addScalar(new GravityConstant(50.0));
        goomba2.setPhysicsBody(goombaBody2);
        myGoombaObjects.add(goomba2);
        
        /******
         * conditions
         ******/

        ConditionsCollection myConditions = new ConditionsCollection();
        
        List <Identifier> identList=new ArrayList<Identifier>();
        identList.add(mario.getIdentifier());
        
        List<Identifier> marioIdList = new ArrayList<Identifier>();
        marioIdList.add(mario.getIdentifier());

        TranslateYType yVelAction = new TranslateYType("mario",1.0);
        TranslateYType yVel1Action = new TranslateYType("goomba",1.0);
        
        
        Action fireballMove = new TranslateXType("fireball", 2.0);
        List<Action> yVelActionList = new ArrayList<Action>();
        yVelActionList.add(yVelAction);
        yVelActionList.add(yVel1Action);
        yVelActionList.add(fireballMove);
        

        XVelocityTypeAction XVelAction = new XVelocityTypeAction("goomba",-60.0);
        YVelocityTypeAction aa=new YVelocityTypeAction("goomba", 60.0);
        yVelActionList.add(XVelAction);
        yVelActionList.add(aa);

        //Action yVelAction = new YVelocityIDAction(temp,0.0);
        Action xVelAction=new XVelocityIDAction(identList, 0.0);
        //yVelActionList.add(yVelAction);
        yVelActionList.add(xVelAction);

        TimeCondition myConstantVelocity = new TimeCondition(yVelActionList,1.0,true);
        myConstantVelocity.setIdentifier(new Identifier("time_cond","a"));
        myConditions.add(myConstantVelocity);
        

        //Action aAct = new MakeNewObjectFromLocationAction("ball",200.0,200.0);
        
        // Move Left
        Action aAct = new XVelocityIDAction(identList, -100.0);
        List<Action> actionList = new ArrayList<Action>();
        actionList.add(aAct);
        List<KeyCode> kclA = new ArrayList<KeyCode>();
        kclA.add(KeyCode.A);
        ButtonPressCondition aCon = new ButtonPressCondition(actionList,kclA, 1.0, true);
        aCon.setIdentifier(new Identifier("button_cond","a"));
        myConditions.add(aCon);
        
        
        
        //Move Right
        Action dAct = new XVelocityIDAction(identList ,100.0);
        List<Action> dActList = new ArrayList<Action>();
        dActList.add(dAct);
        List<KeyCode> kclD = new ArrayList<KeyCode>();
        kclD.add(KeyCode.D);
        ButtonPressCondition dCon = new ButtonPressCondition(dActList,kclD,1.0, true);
        dCon.setIdentifier(new Identifier("button_cond","d")); 
        myConditions.add(dCon);
        
        //Shoot Fireball
        List<Action> testList = new ArrayList<Action>(); 
        Action ballAct = new MakeNewObjectFromObjectAction("fireball", mario.getIdentifier());
        testList.add(ballAct);
        List<KeyCode> kclN = new ArrayList<KeyCode>();
        kclN.add(KeyCode.N);
        ButtonPressCondition nCon = new ButtonPressCondition(testList, kclN, 5.0, true);
        nCon.setIdentifier(new Identifier("button_cond", "n"));
        myConditions.add(nCon);
        
        
        //Shoot Random Fireball
        List<Action> rTestList = new ArrayList<Action>(); 
        Action ballRandAct = new MakeNewRandomObjectAction("fireball", 200.0,200.0,100.0,400.0);
        rTestList.add(ballRandAct);
        List<KeyCode> kclR = new ArrayList<KeyCode>();
        kclR.add(KeyCode.R);
        ButtonPressCondition rCon = new ButtonPressCondition(rTestList, kclR, 5.0, true);
        rCon.setIdentifier(new Identifier("button_cond", "r"));
        myConditions.add(rCon);
        
        //Delete 
        Action delete = new DeleteTypeAction("fireball");

        List<Action> actions = new ArrayList<Action>();
        actions.add(delete);
        List<KeyCode> kclH = new ArrayList<KeyCode>();
        kclH.add(KeyCode.H);
        ButtonPressCondition hCon = new ButtonPressCondition(actions, kclH, 1.0, true);
        hCon.setIdentifier(new Identifier("button_cond", "h"));
        myConditions.add(hCon);
        
        //Jump
        List<Action> wActList = new ArrayList<Action>();
        List<Identifier> wActListId = myMarioObjects.getIdentifierList();
        wActList.add(new YImpulseIDAction(wActListId,-200.0));
        List<KeyCode> kclW = new ArrayList<KeyCode>();
        kclW.add(KeyCode.W);
        ButtonPressCondition wCon = new ButtonPressCondition(wActList,kclW,50.0, true);
        wCon.setIdentifier(new Identifier("button_cond","w"));
        myConditions.add(wCon);
        
        
     
        
        //collision stuff
        
        //Floor Collisions
        
        List<Action> MarioConditionActionList = new ArrayList<Action>();
        FixedCollisionTypeAction collisionAction = new FixedCollisionTypeAction("mario","FloorBlock",0.0);
        MarioConditionActionList.add(collisionAction);
        TypeCollisionCondition marioAndFloorCollision = new TypeCollisionCondition(MarioConditionActionList,"mario","FloorBlock");
        marioAndFloorCollision.setIdentifier(new Identifier("collision_cond","a"));
        myConditions.add(marioAndFloorCollision);
        

        List<Action> GoombaConditionActionList = new ArrayList<Action>();
        FixedCollisionTypeAction goombaCollisionAction = new FixedCollisionTypeAction("goomba","FloorBlock",0.0);
        GoombaConditionActionList.add(goombaCollisionAction);
        TypeCollisionCondition goombaAndFloorCollision = new TypeCollisionCondition(GoombaConditionActionList,"goomba","FloorBlock");
        goombaAndFloorCollision.setIdentifier(new Identifier("collision_cond","b"));
        myConditions.add(goombaAndFloorCollision);
        
        //Platform Collisions
        
        List<Action> marioPlatformConditionActionList = new ArrayList<Action>();
        FixedCollisionTypeAction marioPlatformCollisionAction = new FixedCollisionTypeAction("mario","PlatformBlock",0.0);
        marioPlatformConditionActionList.add(marioPlatformCollisionAction);
        TypeCollisionCondition marioAndPlatformCollision = new TypeCollisionCondition(marioPlatformConditionActionList,"mario","PlatformBlock");
        marioAndPlatformCollision.setIdentifier(new Identifier("collision_cond","c"));
        myConditions.add(marioAndPlatformCollision);
        
        
        //fireball Goomba
        
        List<Action> fireballGoombaConditionActionList = new ArrayList<Action>();
        Action DeleteGoombaAction = new DeleteTypeAction("goomba");
        Action DeleteFireballAction = new DeleteTypeAction("fireball");
        fireballGoombaConditionActionList.add(DeleteGoombaAction);
        fireballGoombaConditionActionList.add(DeleteFireballAction);
        TypeCollisionCondition fireballAndGoombaCollision = new TypeCollisionCondition(fireballGoombaConditionActionList,"fireball","goomba");
        fireballAndGoombaCollision.setIdentifier(new Identifier("collision_cond","a"));
        myConditions.add(fireballAndGoombaCollision);
        
        
        
        //Question Mark Collision
        
        List<Action> marioQBlockConditionActionList = new ArrayList<Action>();
        FixedCollisionTypeAction marioQBlockCollisionAction = new FixedCollisionTypeAction("mario","QuestionBlock",0.0);
        marioQBlockConditionActionList.add(marioQBlockCollisionAction);
        Action makeMushroomAction = new MakeNewObjectFromObjectAction("mushroom", questionBlock1.getIdentifier());
        marioQBlockConditionActionList.add(makeMushroomAction);
        TypeCollisionCondition marioAndQBlockCollision = new TypeCollisionCondition(marioPlatformConditionActionList,"mario","QuestionBlock");
        marioAndQBlockCollision.setIdentifier(new Identifier("collision_cond","a"));
        myConditions.add(marioAndQBlockCollision);
        
        //Boundary
        Action boundaryRightAction = new TranslateYType("floor",350.0);
        Action boundaryLeftAction = new TranslateYType("floor",350.0);
        List<Action> boundaryActionList = new ArrayList<Action>();
        boundaryActionList.add(boundaryLeftAction);
        boundaryActionList.add(boundaryRightAction);
        BoundaryConditionY boundaryCondition = new BoundaryConditionY(boundaryActionList,myFloorObjects.getIdentifierList(),-50.0,false);
        boundaryCondition.setIdentifier(new Identifier("bound_cond","a"));
        myConditions.add(boundaryCondition);
        
        
        //Scrolling
        Action boundaryScrollActionBall = new TranslateXType("mario",0.0);
        Action boundaryScrollActionFloor = new TranslateXType("FloorBlock",-1.0);
        Action boundaryScrollActionPlatform = new TranslateXType("PlatformBlock",-1.0);
        Action boundaryScrollActionQBlock = new TranslateXType("QuestionBlock",-1.0);
        Action boundaryScrollActionMushroom = new TranslateXType("mushroom",-1.0);
        Action boundaryScrollActionFireball = new TranslateXType("fireball",-1.0);
        Action boundaryScrollActionGoomba = new TranslateXType("goomba",-1.0);
        List<Action> scrollActionList = new ArrayList<Action>();
        scrollActionList.add(boundaryScrollActionBall);
        scrollActionList.add(boundaryScrollActionFloor);
        scrollActionList.add(boundaryScrollActionPlatform);
        scrollActionList.add(boundaryScrollActionQBlock);
        scrollActionList.add(boundaryScrollActionMushroom);
        scrollActionList.add(boundaryScrollActionFireball);
        scrollActionList.add(boundaryScrollActionGoomba);
        BoundaryConditionX boundaryConditionScroll = new BoundaryConditionX(scrollActionList,myMarioObjects.getIdentifierList(),300.0,true);
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
        allGameObjects.addAll(myMarioObjects);
        allGameObjects.addAll(myPlatformObjects);
        allGameObjects.addAll(myGoombaObjects);
        allGameObjects.addAll(myFloorObjects);
        allGameObjects.addAll(myQuestionBlocksObjects);
        allGameObjects.add(fireball);
        allGameObjects.addAll(myLabels);
        allGameObjects.addAll(myMushroomObjects);


        /*******
         * levels
         *******/
        LevelsCollection myLevels = new LevelsCollection();
        Level level0 = new Level(allGameObjects.getIdentifierList(),myConditions.getIdentifierList(),true);
        level0.setBackgroundMusic("SuperMarioBrosFull.mp3");
        level0.setBackgroundImage("overworld_bg.png");
        level0.setIdentifier(new Identifier("Level","0"));
        Level level1 = new Level(allGameObjects.getIdentifierList(), myConditions.getIdentifierList(),false);
        level1.setBackgroundImage("overworld_bg.png");
        level1.setIdentifier(new Identifier("Level","1"));
        myLevels.add(level0);
        myLevels.add(level1);
        
//        
//        /*
//         * uncomment for saving game
//         */
//        
//        
//        GameData data = new GameData(myLevels,myConditions,allGameObjects);
//        DataManager manager = new DataManager();
//        try {
//            manager.writeGameFile(data, "fd_final.json", Paths.get(".").toString()+"/src/data/games/fd_final/");
//        }
//        catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        
        /*******
         * game
         ******/
        myGameManager = new GameManager(myConditions,allGameObjects,myLevels,group,Paths.get(".").toString()+"/src/data/games/fd_final");
        myGameManager.initialize();
    }

}
