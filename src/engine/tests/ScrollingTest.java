package engine.tests;

import java.util.ArrayList;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.FrameRateAction;
import engine.actions.TranslateX;
import engine.conditions.ButtonCondition;
import engine.conditions.ButtonConditionManager;
import engine.conditions.CollisionCondition;
import engine.conditions.TimeCondition;
import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import engine.physics.CollisionConstant;
import engine.physics.Velocity;
import engine.render.GameObjectRenderer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class ScrollingTest extends Application {

	/**
	 * @author Abhishek
	 * 
	 *         the sandbox for engine used to get stuff on the screen and keep
	 *         engine team morale high
	 */

	private GameManager myGameManager;
	private Stage myStage;
	private Scene myScene;
	private Group myRootGroup;

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		myStage = arg0;
		myStage.setTitle("");

		myRootGroup = new Group();

		myScene = new Scene(myRootGroup, 300, 300);
		ButtonConditionManager.getInstance().beginListeningToScene(myScene);
		myStage.setScene(myScene);
		myStage.show();
		createGameObject(myRootGroup);

	}

	public void createGameObject(Group group) {
		/*****
		 * create a sprite and put it in a collection
		 *****/
		GameObjectsCollection myFloorObjects = new GameObjectsCollection();
		GameObjectsCollection myBallObjects = new GameObjectsCollection();
		// create the floor
		GameObject floorRight = new GameObject(null, "floor", 0, 200, 20,
				20000, 0, "floor_right");
		// ugh, why do we have to set this explicitly?
		PhysicsBody floorRightBody = new PhysicsBody(20000, 20);
		floorRightBody.setVelocity(new Velocity(0, 0));
		floorRightBody.addScalar((new CollisionConstant(1.0)));
		floorRight.setPhysicsBody(floorRightBody);
		
		GameObject floorAway = new GameObject(null, "floor", 1000, 200, 20,
				20000, 0, "floor_away");
		// ugh, why do we have to set this explicitly?
		PhysicsBody floorAwayBody = new PhysicsBody(20000, 20);
		floorAwayBody.setVelocity(new Velocity(0, 0));
		floorAwayBody.addScalar((new CollisionConstant(1.0)));
		floorAway.setPhysicsBody(floorAwayBody);
		myFloorObjects.add(floorRight);
		myFloorObjects.add(floorAway);
		// create a ball
		GameObject ball = new GameObject(null, "duvall", 150, 50, 40, 40, 0,
				"ball_object");
		PhysicsBody ballBody = new PhysicsBody(30, 30);
		ballBody.setVelocity(new Velocity(0, 30));
		ball.setPhysicsBody(ballBody); 
		myBallObjects.add(ball);

		/******
		 * conditions
		 ******/
		ConditionsCollection myConditions = new ConditionsCollection();
		Action aAct = new TranslateX(myFloorObjects, -1.0);
		Action dAct = new TranslateX(myBallObjects, 2.0);
		ArrayList<Action> actionList = new ArrayList<Action>();
		actionList.add(aAct);
		TimeCondition timeCondition = new TimeCondition(actionList, myFloorObjects, null, 1, true);
		myConditions.add(timeCondition);
		ButtonCondition aCon = new ButtonCondition(actionList, "a_button",
				KeyCode.A);
		ArrayList<Action> dActList = new ArrayList<Action>();
		dActList.add(dAct);
		ButtonCondition dCon = new ButtonCondition(dActList, "d_button",
				KeyCode.D);
		myConditions.add(aCon);
		myConditions.add(dCon);

		// collision stuff
		CollisionCondition ballAndPlatformCollision = new CollisionCondition(
				null, myFloorObjects, myBallObjects, "BALL_PLATFORM_COLLISION");
		myConditions.add(ballAndPlatformCollision);

/*		Action boundaryRightAction = new TranslateY(myFloorObjects, 350);
		ArrayList<Action> boundaryActionList = new ArrayList<Action>();
		boundaryActionList.add(boundaryRightAction);
		BoundaryConditionY boundaryCondition = new BoundaryConditionY(
				boundaryActionList, myFloorObjects, "bound_cond", -50, false);
		myConditions.add(boundaryCondition);*/

		Action pauseAct = new FrameRateAction(0.0);
		ArrayList<Action> pauseActList = new ArrayList<Action>();
		pauseActList.add(pauseAct);
		ButtonCondition pCon = new ButtonCondition(pauseActList,
				"pause_button", KeyCode.P);
		Action playAct = new FrameRateAction(60.0);
		ArrayList<Action> playListAct = new ArrayList<Action>();
		playListAct.add(playAct);
		ButtonCondition uCon = new ButtonCondition(playListAct, "play_button",
				KeyCode.U);
		// myConditions.add(pCon);
		// myConditions.add(uCon);

		GameObjectsCollection allGameObjects = new GameObjectsCollection();
		allGameObjects.addAll(myBallObjects);
		allGameObjects.addAll(myFloorObjects);

		/*******
		 * levels
		 *******/
		LevelsCollection myLevels = new LevelsCollection();
		Level level0 = new Level(allGameObjects);
		myLevels.add(level0);

		/*
		 * uncomment for saving game
		 */
		/*
		 * GameData data = new GameData(); data.addLevel(level0);
		 * data.addCondition(aCon); data.addCondition(dCon);
		 * //data.addCondition(boundaryCondition); data.addGameObject(ball);
		 * data.addGameObject(floorLeft); data.addGameObject(floorRight);
		 * DataManager manager = new DataManager(); try {
		 * manager.writeGameFile(data, "fd_final.json"); } catch (IOException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		/*******
		 * game
		 ******/
		myGameManager = new GameManager(myConditions, myFloorObjects, myLevels,
				group);

		GameObjectRenderer myGameObjectRenderer = new GameObjectRenderer(group);
		myGameObjectRenderer.renderGameObjects(level0);
		myGameManager.initialize();
	}

}
