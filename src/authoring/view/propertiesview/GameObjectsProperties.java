package authoring.view.propertiesview;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import authoring.eventhandlers.GameHandler;
import engine.gameObject.GameObject;

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

		textProperties.put("name", new PropertyTextField("Name: ",
		gameObject.getID()));
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
		textProperties
				.put("x",
						new PropertyTextField("X: ", Double.toString(gameObject
								.getX())));
		textProperties
				.put("y",
						new PropertyTextField("Y: ", Double.toString(gameObject
								.getY())));
		textProperties.put("rotation", new PropertyTextField("Rotation: ",
				Double.toString(gameObject.getRotation())));

		for (String s : textProperties.keySet()) {
			this.getChildren().add(textProperties.get(s));
		}

		HBox visibilityField = new HBox();
		CheckBox cb = new CheckBox("Enabled");
		cb.setSelected(gameObject.isEnabled());
		visibilityField.getChildren().add(cb);
		this.getChildren().add(visibilityField);
		booleanProperties.put("enabled", cb);

		Button editButton = new Button("Edit");
		//System.out.println(myHandler);
		editButton.setOnAction(myHandler);
		this.getChildren().add(editButton);

		Button saveAsNew = new Button("Save as New");
		saveAsNew.setOnMouseClicked(event -> saveAsNew());
		this.getChildren().add(saveAsNew);

	}

	public GameObject edit(GameObject g) {

		// public GameObject (List<Component> components, String imageName,
		// SoundReference sounds,
		// double x, double y, double height, double width, double rotation,
		// String iD)

		
		
		GameObject edited = new GameObject(g.getComponents(), textProperties
				.get("image").getInformation(),
				Double.parseDouble(textProperties.get("x").getInformation()),
				Double.parseDouble(textProperties.get("y").getInformation()),
				Double.parseDouble(textProperties.get("height")
						.getInformation()), Double.parseDouble(textProperties
						.get("width").getInformation()),
				Double.parseDouble(textProperties.get("rotation")
						.getInformation()), textProperties.get("name")
						.getInformation());
		
		//remove g
		//add edited
		return edited;
	}

	public void saveAsNew() {

	}
}
