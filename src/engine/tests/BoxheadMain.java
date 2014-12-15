package engine.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import data.DataManager;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.DeleteInteractingObjectsAction;
import engine.actions.DeleteTypeAction;
import engine.actions.FixedCollisionTypeAction;
import engine.actions.MakeNewObjectFromObjectAction;
import engine.actions.MakeNewRandomObjectAction;
import engine.actions.PlayAudioClipAction;
import engine.actions.RotateImageIDAction;
import engine.actions.RotateImageTypeAction;
import engine.actions.TranslateXID;
import engine.actions.TranslateXType;
import engine.actions.TranslateYID;
import engine.actions.TranslateYType;
import engine.actions.XVelocityIDAction;
import engine.actions.XVelocityTypeAction;
import engine.actions.YVelocityIDAction;
import engine.actions.YVelocityTypeAction;
import engine.conditions.BoundaryConditionX;
import engine.conditions.BoundaryConditionY;
import engine.conditions.ButtonPressCondition;
import engine.conditions.ButtonConditionManager;
import engine.conditions.ButtonReleaseCondition;
import engine.conditions.Condition;
import engine.conditions.TimeCondition;
import engine.conditions.TypeCollisionCondition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import engine.physics.Velocity;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BoxheadMain extends Application {
  
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
        GameObjectsCollection myHeroObjects = new GameObjectsCollection();
        GameObjectsCollection myEnemyObjects = new GameObjectsCollection();
        GameObjectsCollection myBulletObjects = new GameObjectsCollection();

        ConditionsCollection myConditions = new ConditionsCollection();
        
        //create a hero
        GameObject hero = new GameObject(null,"hero.png",50,150,40,40,0,"hero_object");
        hero.setIdentifier(new Identifier("hero","a"));
        PhysicsBody heroBody = new PhysicsBody(37,37);
        hero.setPhysicsBody(heroBody);
        myHeroObjects.add(hero);
        
        //create a up walking zombie
        GameObject upEnemy = new GameObject(null,"zombie_slow.gif",100,250,35,35,0,"zombie_object");
        upEnemy.setIdentifier(new Identifier("zombie_up","template"));
        PhysicsBody upEnemyBody = new PhysicsBody(29,19);
        upEnemy.setPhysicsBody(upEnemyBody);
        myEnemyObjects.add(upEnemy);
        
        List<Action> upEnemyGenerationAction = new ArrayList<Action>();
        upEnemyGenerationAction.add(new MakeNewRandomObjectAction("zombie_up",-1000.,1000.,-1000.,1000.));
        upEnemyGenerationAction.add(new YVelocityTypeAction("zombie_up",-40.));
        TimeCondition upEnemyGenerationCondition = new TimeCondition(upEnemyGenerationAction,60.,true);
        upEnemyGenerationCondition.setIdentifier(new Identifier("gen_cond","a"));
        myConditions.add(upEnemyGenerationCondition);
        
        //create a down walking zombie
        GameObject downEnemy = new GameObject(null,"zombie_slow.gif",100,250,35,35,0,"zombie_object");
        downEnemy.setIdentifier(new Identifier("zombie_down","template"));
        PhysicsBody downEnemyBody = new PhysicsBody(29,19);
        downEnemy.setPhysicsBody(downEnemyBody);
        myEnemyObjects.add(downEnemy);
        
        List<Action> downEnemyGenerationAction = new ArrayList<Action>();
        downEnemyGenerationAction.add(new MakeNewRandomObjectAction("zombie_down",-1000.,1000.,-1000.,1000.));
        downEnemyGenerationAction.add(new YVelocityTypeAction("zombie_down",40.));
        downEnemyGenerationAction.add(new RotateImageTypeAction("zombie_down",180.));
        TimeCondition downEnemyGenerationCondition = new TimeCondition(downEnemyGenerationAction,60.,true);
        downEnemyGenerationCondition.setIdentifier(new Identifier("gen_cond","a"));
        myConditions.add(downEnemyGenerationCondition);
        
        //create a left walking zombie
        GameObject leftEnemy = new GameObject(null,"zombie_slow.gif",100,250,35,35,0,"zombie_object");
        leftEnemy.setIdentifier(new Identifier("zombie_left","template"));
        PhysicsBody leftEnemyBody = new PhysicsBody(29,19);
        leftEnemy.setPhysicsBody(leftEnemyBody);
        myEnemyObjects.add(leftEnemy);
        
        List<Action> leftEnemyGenerationAction = new ArrayList<Action>();
        leftEnemyGenerationAction.add(new MakeNewRandomObjectAction("zombie_left",-1000.,1000.,-1000.,1000.));
        leftEnemyGenerationAction.add(new XVelocityTypeAction("zombie_left",-40.));
        leftEnemyGenerationAction.add(new RotateImageTypeAction("zombie_left",270.));
        TimeCondition leftEnemyGenerationCondition = new TimeCondition(leftEnemyGenerationAction,60.,true);
        leftEnemyGenerationCondition.setIdentifier(new Identifier("gen_cond","a"));
        myConditions.add(leftEnemyGenerationCondition);
        
        //create a right walking zombie
        GameObject rightEnemy = new GameObject(null,"zombie_slow.gif",100,250,35,35,0,"zombie_object");
        rightEnemy.setIdentifier(new Identifier("zombie_right","template"));
        PhysicsBody rightEnemyBody = new PhysicsBody(29,19);
        rightEnemy.setPhysicsBody(rightEnemyBody);
        myEnemyObjects.add(rightEnemy);
        
        List<Action> rightEnemyGenerationAction = new ArrayList<Action>();
        rightEnemyGenerationAction.add(new MakeNewRandomObjectAction("zombie_right",-1000.,1000.,-1000.,1000.));
        rightEnemyGenerationAction.add(new XVelocityTypeAction("zombie_right",40.));
        rightEnemyGenerationAction.add(new RotateImageTypeAction("zombie_right",90.));
        TimeCondition rightEnemyGenerationCondition = new TimeCondition(rightEnemyGenerationAction,60.,true);
        rightEnemyGenerationCondition.setIdentifier(new Identifier("gen_cond","a"));
        myConditions.add(rightEnemyGenerationCondition);
        
        
        /******
         * scrolling
         ******/
        
        Action boundaryScrollHeroRightAction = new TranslateXType("hero",-2.0);
        List<Action> boundaryScrollZombieRightActionList = new ArrayList<Action>();
        boundaryScrollZombieRightActionList.add(new TranslateXType("zombie_up",-1.0));
        boundaryScrollZombieRightActionList.add(new TranslateXType("zombie_down",-1.0));
        boundaryScrollZombieRightActionList.add(new TranslateXType("zombie_left",-1.0));
        boundaryScrollZombieRightActionList.add(new TranslateXType("zombie_right",-1.0));
        boundaryScrollZombieRightActionList.add(boundaryScrollHeroRightAction);
        Condition playerRightBoundary = new BoundaryConditionX(boundaryScrollZombieRightActionList,myHeroObjects.getIdentifierList(),475.,true);
        playerRightBoundary.setIdentifier(new Identifier("bound_cond","right"));
        myConditions.add(playerRightBoundary);
        
        Action boundaryScrollHeroLeftAction = new TranslateXType("hero",2.0);
        List<Action> boundaryScrollZombieLeftActionList = new ArrayList<Action>();
        boundaryScrollZombieLeftActionList.add(new TranslateXType("zombie_up",1.0));
        boundaryScrollZombieLeftActionList.add(new TranslateXType("zombie_down",1.0));
        boundaryScrollZombieLeftActionList.add(new TranslateXType("zombie_left",1.0));
        boundaryScrollZombieLeftActionList.add(new TranslateXType("zombie_right",1.0));
        boundaryScrollZombieLeftActionList.add(boundaryScrollHeroLeftAction);
        Condition playerLeftBoundary = new BoundaryConditionX(boundaryScrollZombieLeftActionList,myHeroObjects.getIdentifierList(),25.,false);
        playerLeftBoundary.setIdentifier(new Identifier("bound_cond","left"));
        myConditions.add(playerLeftBoundary);
        
        Action boundaryScrollHeroDownAction = new TranslateYType("hero",-2.0);
        List<Action> boundaryScrollZombieDownActionList = new ArrayList<Action>();
        boundaryScrollZombieDownActionList.add(new TranslateYType("zombie_up",-1.0));
        boundaryScrollZombieDownActionList.add(new TranslateYType("zombie_down",-1.0));
        boundaryScrollZombieDownActionList.add(new TranslateYType("zombie_left",-1.0));
        boundaryScrollZombieDownActionList.add(new TranslateYType("zombie_right",-1.0));
        boundaryScrollZombieDownActionList.add(boundaryScrollHeroDownAction);
        Condition playerDownBoundary = new BoundaryConditionY(boundaryScrollZombieDownActionList,myHeroObjects.getIdentifierList(),125.,true);
        playerDownBoundary.setIdentifier(new Identifier("bound_cond","down"));
        myConditions.add(playerDownBoundary);
        
        Action boundaryScrollHeroUpAction = new TranslateYType("hero",2.0);
        List<Action> boundaryScrollZombieUpActionList = new ArrayList<Action>();
        boundaryScrollZombieUpActionList.add(new TranslateYType("zombie_up",1.0));
        boundaryScrollZombieUpActionList.add(new TranslateYType("zombie_down",1.0));
        boundaryScrollZombieUpActionList.add(new TranslateYType("zombie_left",1.0));
        boundaryScrollZombieUpActionList.add(new TranslateYType("zombie_right",1.0));
        boundaryScrollZombieUpActionList.add(boundaryScrollHeroUpAction);
        Condition playerUpBoundary = new BoundaryConditionY(boundaryScrollZombieUpActionList,myHeroObjects.getIdentifierList(),675.,false);
        playerUpBoundary.setIdentifier(new Identifier("bound_cond","up"));
        myConditions.add(playerUpBoundary);
        


        /******
         * bullet firing
         ******/
        
        //create bullet
        GameObject bullet = new GameObject(null, "bullet.png", 50,50, 5, 5, 0, "ball_object");
        bullet.setIdentifier(new Identifier("bullet", "template"));
        PhysicsBody bulletBody = new PhysicsBody(5, 5);
        bullet.setPhysicsBody(bulletBody);
        myBulletObjects.add(bullet);
        
        /******
         *  movement
         ******/
        
        ArrayList<Identifier> ballIdList = new ArrayList<Identifier>();
        ballIdList.add(hero.getIdentifier());

        Action moveRightAction = new TranslateXID(ballIdList, 2.0);
        ArrayList<Action> moveRightActionList = new ArrayList<Action>();
        moveRightActionList.add(moveRightAction);
        //rotate image
        Action moveRightRotateAction = new RotateImageIDAction(myHeroObjects.getIdentifierList(),0.0);
        moveRightActionList.add(moveRightRotateAction);
        //change bullet velocity
        Action bulletVelocityRight = new XVelocityTypeAction("bullet",200.0);
        moveRightActionList.add(bulletVelocityRight);

        ArrayList<KeyCode> kclD = new ArrayList<KeyCode>();
        kclD.add(KeyCode.D);
        ButtonPressCondition dCon = new ButtonPressCondition(moveRightActionList,kclD,1.0, true);
        dCon.setIdentifier(new Identifier("button_cond","d"));
        myConditions.add(dCon);

        Action moveLeftAction = new TranslateXID(ballIdList, -2.0);
        ArrayList<Action> moveLeftActionList = new ArrayList<Action>();
        moveLeftActionList.add(moveLeftAction);
        //rotate image
        Action moveLeftRotateAction = new RotateImageIDAction(myHeroObjects.getIdentifierList(),180.0);
        moveLeftActionList.add(moveLeftRotateAction);
        //change bullet velocity
        Action bulletVelocityLeft = new XVelocityTypeAction("bullet",-200.0);
        moveLeftActionList.add(bulletVelocityLeft);
        
        ArrayList<KeyCode> kclA = new ArrayList<KeyCode>();
        kclA.add(KeyCode.A);
        ButtonPressCondition aCon = new ButtonPressCondition(moveLeftActionList,kclA, 1.0, true);
        aCon.setIdentifier(new Identifier("button_cond","a"));
        myConditions.add(aCon);
        
        Action moveUpAction = new TranslateYID(ballIdList, -2.0);
        ArrayList<Action> moveUpActionList = new ArrayList<Action>();
        moveUpActionList.add(moveUpAction);
        //rotate image
        Action moveUpRotateAction = new RotateImageIDAction(myHeroObjects.getIdentifierList(),270.0);
        moveUpActionList.add(moveUpRotateAction);
        //change bullet velocity
        Action bulletVelocityUp = new YVelocityTypeAction("bullet",-200.0);
        moveUpActionList.add(bulletVelocityUp);
        
        ArrayList<KeyCode> kclW = new ArrayList<KeyCode>();
        kclW.add(KeyCode.W);
        ButtonPressCondition wCon = new ButtonPressCondition(moveUpActionList,kclW, 1.0, true);
        wCon.setIdentifier(new Identifier("button_cond","w"));
        myConditions.add(wCon);
        
        Action moveDownAction = new TranslateYID(ballIdList, 2.0);
        ArrayList<Action> moveDownActionList = new ArrayList<Action>();
        moveDownActionList.add(moveDownAction);
        Action moveDownRotateAction = new RotateImageIDAction(myHeroObjects.getIdentifierList(),90.0);
        moveDownActionList.add(moveDownRotateAction);
        //change bullet velocity
        Action bulletVelocityDown = new YVelocityTypeAction("bullet",200.0);
        moveDownActionList.add(bulletVelocityDown);
        
        ArrayList<KeyCode> kclS = new ArrayList<KeyCode>();
        kclS.add(KeyCode.S);
        ButtonPressCondition sCon = new ButtonPressCondition(moveDownActionList,kclS, 1.0, true);
        sCon.setIdentifier(new Identifier("button_cond","s"));
        myConditions.add(sCon);
        
        
        Action heroBulletAct = new MakeNewObjectFromObjectAction("bullet", hero.getIdentifier());
        List<Action> heroBulletActionList = new ArrayList<Action>();
        heroBulletActionList.add(new DeleteTypeAction("bullet"));
        heroBulletActionList.add(heroBulletAct);
        heroBulletActionList.add(new PlayAudioClipAction("laser1.mp3"));
        
        ArrayList<KeyCode> kclF = new ArrayList<KeyCode>();
        kclF.add(KeyCode.F);
        ButtonPressCondition fCon = new ButtonPressCondition(heroBulletActionList,kclF, 30.0, true);
        fCon.setIdentifier(new Identifier("button_cond","f"));
        myConditions.add(fCon);

        
        //collision for enemy and bullet
        List<Action> heroBulletCollisionAction = new ArrayList<Action>();
        heroBulletCollisionAction.add(new DeleteInteractingObjectsAction("bullet"));
        heroBulletCollisionAction.add(new DeleteInteractingObjectsAction("zombie_up"));
        Condition enemyBulletCondition = new TypeCollisionCondition(heroBulletCollisionAction,"bullet","zombie_up");
        enemyBulletCondition.setIdentifier(new Identifier("hero_zomb","a"));
        myConditions.add(enemyBulletCondition);
        
        List<Action> heroBulletCollisionActionLeft = new ArrayList<Action>();
        heroBulletCollisionActionLeft.add(new DeleteInteractingObjectsAction("bullet"));
        heroBulletCollisionActionLeft.add(new DeleteInteractingObjectsAction("zombie_left"));
        Condition enemyBulletConditionLeft = new TypeCollisionCondition(heroBulletCollisionActionLeft,"bullet","zombie_left");
        enemyBulletConditionLeft.setIdentifier(new Identifier("hero_zomb","b"));
        myConditions.add(enemyBulletConditionLeft);
        
        List<Action> heroBulletCollisionActionRight = new ArrayList<Action>();
        heroBulletCollisionActionRight.add(new DeleteInteractingObjectsAction("bullet"));
        heroBulletCollisionActionRight.add(new DeleteInteractingObjectsAction("zombie_right"));
        Condition enemyBulletConditionRight = new TypeCollisionCondition(heroBulletCollisionActionRight,"bullet","zombie_right");
        enemyBulletConditionRight.setIdentifier(new Identifier("hero_zomb","c"));
        myConditions.add(enemyBulletConditionRight);
        
        List<Action> heroBulletCollisionActionDown = new ArrayList<Action>();
        heroBulletCollisionActionDown.add(new DeleteInteractingObjectsAction("bullet"));
        heroBulletCollisionActionDown.add(new DeleteInteractingObjectsAction("zombie_down"));
        Condition enemyBulletConditionDown = new TypeCollisionCondition(heroBulletCollisionActionDown,"bullet","zombie_down");
        enemyBulletConditionDown.setIdentifier(new Identifier("hero_zomb","d"));
        myConditions.add(enemyBulletConditionDown);
        
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
        BoundaryConditionX boundaryConditionScroll = new BoundaryConditionX(scrollActionList,myHeroObjects.getIdentifierList(),200.0,true);
        boundaryConditionScroll.setIdentifier(new Identifier("bound_scroll","a"));
        myConditions.add(boundaryConditionScroll);

        
        GameObjectsCollection allGameObjects = new GameObjectsCollection();
        allGameObjects.addAll(myHeroObjects);
        allGameObjects.addAll(myFloorObjects);
        allGameObjects.addAll(myBulletObjects);
        allGameObjects.addAll(myEnemyObjects);

        /*******
         * levels
         *******/
        LevelsCollection myLevels = new LevelsCollection();
        Level level0 = new Level(allGameObjects.getIdentifierList(),myConditions.getIdentifierList(),true);
        //level0.setBackgroundMusic("Flappy_Bird_Theme_Song.mp3");
        level0.setBackgroundImage("overworld_bg.png");
        myLevels.add(level0);
        
        /*
         * uncomment for saving game
         */
        
        GameData data = new GameData(myLevels,myConditions,allGameObjects);
        DataManager manager = new DataManager();
        try {
            File fileLocation = new File(Paths.get(".").toString()+"/src/data/games/boxhead");
            manager.writeGameFile(data, fileLocation);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        /*******
         * game
         ******/
        myGameManager = new GameManager(myConditions,allGameObjects,myLevels,group,Paths.get(".").toString()+"/src/data/games/boxhead");
        myGameManager.initialize();
    }

}
