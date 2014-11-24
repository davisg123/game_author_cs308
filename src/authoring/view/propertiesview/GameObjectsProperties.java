package authoring.view.propertiesview;

import java.io.File;
import static authoring.view.levelview.SingleLevelView.OBJECT_X_OFFSET;
import static authoring.view.levelview.SingleLevelView.OBJECT_Y_OFFSET;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import authoring.eventhandlers.GameHandler;
import engine.gameObject.GameObject;

public class GameObjectsProperties extends Properties {

	private Map<String, PropertyTextField> textProperties;
	private Map<String, CheckBox> booleanProperties;
	private GameHandler myHandler;
	private File myGameLocation;

	public GameObjectsProperties(GameObject gObj, GameHandler handler,
			File gameLoc) {
		super(gObj);
		myHandler = handler;
		myGameLocation = gameLoc;
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
		// System.out.println(myHandler);
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
		String filePath = new String(myGameLocation.getPath() + "/images/"
				+ textProperties.get("image").getInformation());
		System.out.println(filePath);
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

		// remove g
		// add edited
		return edited;
	}

	public void setUpForNewObject() {
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
		b.setOnAction(myHandler);
		this.getChildren().add(b);

	}

	public void saveAsNew() {

	}
}
