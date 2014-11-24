package authoring.view.propertiesview;

import static authoring.view.levelview.SingleLevelView.OBJECT_X_OFFSET;
import static authoring.view.levelview.SingleLevelView.OBJECT_Y_OFFSET;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import authoring.eventhandlers.GameHandler;
import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;
import engine.physics.CollisionConstant;
import engine.physics.Vector;

public class GameObjectsProperties extends Properties {

	private Map<String, PropertyTextField> textProperties;
	private Map<String, CheckBox> booleanProperties;
	private GameHandler myHandler;

	public GameObjectsProperties(GameObject gObj, GameHandler handler) {
		super(gObj);
		myHandler = handler;
		initializeProperties(gObj);
	}

	@Override
	public void initializeProperties(Object g) {

		GameObject gameObject = (GameObject) g;

		this.getChildren().clear();

		textProperties = new HashMap<String, PropertyTextField>();
		booleanProperties = new HashMap<String, CheckBox>();

		textProperties.put("name",
				new PropertyTextField("Name: ", gameObject.getID()));
		textProperties.put(
				"image",
				new PropertyTextField("Image: ", gameObject
						.getCurrentImageName()));
		textProperties.put(
				"width",
				new PropertyTextField("Width: ", Double.toString(gameObject
						.getWidth())));
		textProperties.put(
				"height",
				new PropertyTextField("Height: ", Double.toString(gameObject
						.getHeight())));
		textProperties.put(
				"x",
				new PropertyTextField("X: ", Double.toString(gameObject.getX()
						+ OBJECT_X_OFFSET)));
		textProperties.put(
				"y",
				new PropertyTextField("Y: ", Double.toString(gameObject.getY()
						+ OBJECT_Y_OFFSET)));
		textProperties.put("rotation", new PropertyTextField("Rotation: ",
				Double.toString(gameObject.getRotation())));
		
		textProperties.put("collision", new PropertyTextField("Collision Constant", "0"));
		textProperties.put("initXV", new PropertyTextField("Initial X Velocity", "0"));
		textProperties.put("initYV", new PropertyTextField("Initial Y Velocity", "0"));
		

		for (String s : textProperties.keySet()) {
			this.getChildren().add(textProperties.get(s));
		}

		HBox visibilityField = new HBox();
		CheckBox cbVisibility = new CheckBox("Enabled");
		cbVisibility.setSelected(gameObject.isEnabled());
		visibilityField.getChildren().add(cbVisibility);
		this.getChildren().add(visibilityField);
		booleanProperties.put("enabled", cbVisibility);

		HBox physicsBody = new HBox();
		CheckBox cbPhysics = new CheckBox("Physics Body");
		cbPhysics.setSelected(gameObject.getPhysicsBody() != null);
		physicsBody.getChildren().add(cbPhysics);
		this.getChildren().add(physicsBody);
		booleanProperties.put("has physics", cbPhysics);

		Button editButton = new Button("Edit");
		editButton.setOnAction(myHandler);
		this.getChildren().add(editButton);

		Button saveAsNew = new Button("Save as New");
		saveAsNew.setOnMouseClicked(event -> saveAsNew());
		this.getChildren().add(saveAsNew);

	}

	public GameObject edit(GameObject g) {

		GameObject edited = new GameObject(g.getComponents(), textProperties
				.get("image").getInformation(),
				Double.parseDouble(textProperties.get("x").getInformation())
						- OBJECT_X_OFFSET, Double.parseDouble(textProperties
						.get("y").getInformation()) - OBJECT_Y_OFFSET,
				Double.parseDouble(textProperties.get("height")
						.getInformation()), Double.parseDouble(textProperties
						.get("width").getInformation()),
				Double.parseDouble(textProperties.get("rotation")
						.getInformation()), textProperties.get("name")
						.getInformation());

		System.out.println(booleanProperties.get("has physics"));
		
		
		if (booleanProperties.get("has physics").isSelected()) {
			
			System.out.println("HAS PHYSICS");
			
			PhysicsBody pb = new PhysicsBody(Double.parseDouble(textProperties
					.get("height").getInformation()),
					Double.parseDouble(textProperties.get("width")
							.getInformation()));

			pb.addScalar(new CollisionConstant(Double.parseDouble(textProperties.get("collision").getInformation())));
			pb.setVelocity(new Vector(Double.parseDouble(textProperties.get("initXV").getInformation()), Double.parseDouble(textProperties.get("initYV").getInformation())));
			
			System.out.println(pb);
			edited.setPhysicsBody(pb);
		}
	
		return edited;
	}

	public Button setUpForNewObject() {
		for (String s : textProperties.keySet()) {
			PropertyTextField cleared = textProperties.get(s);
			cleared.setString("");
			textProperties.put(s, cleared);
		}
		this.getChildren().clear();
		for (String s : textProperties.keySet()) {
			this.getChildren().add(textProperties.get(s));
		}
		Button b = new Button("Create");
		this.getChildren().add(b);
		return b;
	}

	public void saveAsNew() {

	}
}
