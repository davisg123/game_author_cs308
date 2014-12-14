package Falldown;

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
import engine.actions.ChangeLevelAction;
import engine.actions.FixedCollisionTypeAction;
import engine.conditions.BoundaryConditionY;
import engine.conditions.ButtonConditionManager;
import engine.conditions.ButtonPressCondition;
import engine.conditions.TypeCollisionCondition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import engine.physics.CollisionConstant;
import engine.physics.Gravity;
import engine.physics.GravityConstant;

public class FalldownEngineTest extends Application {

	private GameManager myGameManager;
	private Stage myStage;
	private Scene myScene;
	private Group myRootGroup;

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		myStage = arg0;
		myStage.setTitle("");

		myRootGroup = new Group();

		myScene = new Scene(myRootGroup, 300, 300);
		ButtonConditionManager.getInstance().beginListeningToScene(myScene);
		myStage.setScene(myScene);
		myStage.show();
		createGameObject(myRootGroup);
	}

	private void createGameObject(Group group) {
		ConditionsCollection myConditions = new ConditionsCollection();
		GameObjectsCollection myGameObjects = new GameObjectsCollection();
		LevelsCollection myLevels = new LevelsCollection();

		/*
		 * Level 0 Splash Screen
		 */
		ConditionsCollection myLevel0Conditions = new ConditionsCollection();
		GameObjectsCollection myLevel0Objects = new GameObjectsCollection();
		Identifier level0ID = new Identifier("level", "level0");
		Identifier level1ID = new Identifier("level", "level1");
		Identifier level2ID = new Identifier("level", "level2");
		List<KeyCode> level0Keys = new ArrayList<KeyCode>();
		level0Keys.add(KeyCode.SPACE);

		Action changeLevelAction = new ChangeLevelAction(level1ID);
		List<Action> level0Actions = new ArrayList<Action>();
		level0Actions.add(changeLevelAction);
		ButtonPressCondition changeLevelButtonCondition = new ButtonPressCondition(
				level0Actions, level0Keys, 1.0, false);
		changeLevelButtonCondition.setIdentifier(new Identifier("levelChange",
				"levelChange0to1"));
		myLevel0Conditions.add(changeLevelButtonCondition);

		myConditions.addAll(myLevel0Conditions);
		myGameObjects.addAll(myLevel0Objects);

		Level level0 = new Level(myLevel0Objects.getIdentifierList(),
				myLevel0Conditions.getIdentifierList(), true);
		level0.setIdentifier(level0ID);
		level0.setBackgroundImage("Personnages-celebres-Troll-face-Troll-face-me-gusta-29215.jpg");
		myLevels.add(level0);

		/*
		 * 
		 * Level 1
		 * 
		 * 
		 * 
		 */
		List<Action> level1Actions = new ArrayList<Action>();
		ConditionsCollection myLevel1Conditions = new ConditionsCollection();
		GameObjectsCollection myLevel1Objects = new GameObjectsCollection();

		GameObject ball = new GameObject(null, "ball.png", 50, 150, 30, 30, 0,
				"ball_object");
		ball.setIdentifier(new Identifier("ball", "ball"));
		PhysicsBody ballBody = new PhysicsBody(37, 37);
		ballBody.addForce(new Gravity(0,1.0));
		ballBody.addScalar(new GravityConstant(30.0));
		ball.setPhysicsBody(ballBody);
		myLevel1Objects.add(ball);

		GameObject floorRight = new GameObject(null, "floor.png", 200, 200, 20,
				200, 0, "floor_right");
		floorRight.setIdentifier(new Identifier("floor", "a"));
		PhysicsBody floorRightBody = new PhysicsBody(20, 200);
		floorRightBody.addScalar(new CollisionConstant(1.0));
		floorRight.setPhysicsBody(floorRightBody);
		GameObject floorLeft = new GameObject(null, "floor.png", -50, 200, 20,
				200, 0, "floor_left");
		floorLeft.setIdentifier(new Identifier("floor", "b"));
		PhysicsBody floorLeftBody = new PhysicsBody(20, 210);
		floorLeftBody.addScalar((new CollisionConstant(1.0)));
		floorLeft.setPhysicsBody(floorLeftBody);
		myLevel1Objects.add(floorRight);
		myLevel1Objects.add(floorLeft);
		
		ArrayList<Action> ConditionActionList = new ArrayList<Action>();
        FixedCollisionTypeAction collisionAction = new FixedCollisionTypeAction("ball","floor",0.0);
        ConditionActionList.add(collisionAction);
        TypeCollisionCondition ballAndPlatformCollision = new TypeCollisionCondition(ConditionActionList,"ball","floor");
        ballAndPlatformCollision.setIdentifier(new Identifier("collision_cond","a"));
        myLevel1Conditions.add(ballAndPlatformCollision);

		Action changeLevelAction2 = new ChangeLevelAction(level2ID);
		level1Actions.add(changeLevelAction2);

		BoundaryConditionY boundaryBottomCondition = new BoundaryConditionY(
				level1Actions, myLevel1Objects.getIdentifierList(), 250.0, false);
		BoundaryConditionY boundaryTopCondition = new BoundaryConditionY(
				level1Actions, myLevel1Objects.getIdentifierList(), -50.0,
				true);
		boundaryBottomCondition.setIdentifier(new Identifier("changeLevel",
				"bottomBoundaryGameOver"));
		//myLevel1Conditions.add(boundaryBottomCondition);
		// myLevel1Conditions.add(boundaryTopCondition);

		Level level1 = new Level(myLevel1Objects.getIdentifierList(),
				myLevel1Conditions.getIdentifierList(), false);
		level1.setIdentifier(level1ID);

		myGameObjects.addAll(myLevel1Objects);
		myConditions.addAll(myLevel1Conditions);
		myLevels.add(level1);

		/*
		 * 
		 * LEVEL 2
		 * 
		 * 
		 */
		
		// Level 2, game over screen
		ConditionsCollection myLevel2Conditions = new ConditionsCollection();
		GameObjectsCollection myLevel2Objects = new GameObjectsCollection();

		myLevel1Objects.add(ball);

		Level level2 = new Level(myLevel2Objects.getIdentifierList(),
				myLevel2Conditions.getIdentifierList(), false);
		level2.setBackgroundImage("GameOverScreen.png");
		level2.setIdentifier(level2ID);
		myGameObjects.addAll(myLevel2Objects);
		myLevels.add(level2);

		myGameManager = new GameManager(myConditions, myGameObjects, myLevels,
				group, Paths.get(".").toString() + "/src/data/games/fd_final");
		myGameManager.initialize();
	}

}
