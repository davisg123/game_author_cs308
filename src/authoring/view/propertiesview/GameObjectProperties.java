package authoring.view.propertiesview;

import static authoring.view.levelview.SingleLevelView.OBJECT_X_OFFSET;
import static authoring.view.levelview.SingleLevelView.OBJECT_Y_OFFSET;
import static authoring.main.Main.SCREEN_WIDTH;
import static authoring.main.Main.SCREEN_HEIGHT;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.AccordionContainer;
import authoring.view.icons.BaseIcon;
import authoring.view.icons.GameObjectIcon;
import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;
import engine.physics.Mass;
import engine.physics.Vector;

public class GameObjectProperties extends Properties {

	
	private AccordionContainer myAccordion;
	
	private Map<String, PropertyTextField> inherentTextProperties;
	private Map<String, PropertyTextField> concreteTextProperties;
	private Map<String, CheckBox> booleanProperties;
	private Map<String, PropertyTextField> physicsProperties;
	
	private Map<String, PropertyTextField> wizardProperties;
	
	private GameHandler myEditHandler;
	private GameHandler myDeleteHandler;
	private GameHandler mySaveAsNewHandler;

	public GameObjectProperties(GameObjectIcon gObj, GameHandler ...handler) {
		
		myAccordion = new AccordionContainer(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		
		
		myEditHandler = handler[0];
		mySaveAsNewHandler = handler[1];
		myDeleteHandler = handler[2];
		initializeProperties(gObj);
	}

	public GameObjectProperties(){
		//nullary constructor that creates empty map to generate new game objects
		//consider refactoring this
		wizardProperties = new HashMap<String, PropertyTextField>();

		wizardProperties.put("image", new PropertyTextField("Image: ", ""));	
		wizardProperties.put("initXV", new PropertyTextField("Initial X Velocity", "0"));
		wizardProperties.put("initYV", new PropertyTextField("Initial Y Velocity", "0"));
		wizardProperties.put("width", new PropertyTextField("Width: ", ""));
		wizardProperties.put("height",new PropertyTextField("Height: ", ""));
	}
	
	@Override
	public void initializeProperties(BaseIcon g) {

		GameObject gameObject = ((GameObjectIcon) g).getGameObject();

		this.getChildren().clear();
		
		TitledPane corePane = new TitledPane();
		corePane.setText("Core Properties");
		VBox coreBox = new VBox();
		TitledPane physicsPane = new TitledPane();
		physicsPane.setText("Physics Properties");
		VBox physicsBox = new VBox();

		inherentTextProperties = new HashMap<String, PropertyTextField>();
		concreteTextProperties = new HashMap<String, PropertyTextField>();
		booleanProperties = new HashMap<String, CheckBox>();
		physicsProperties = new HashMap<String, PropertyTextField>();
		

		PropertyTextField unmodifiableName = new PropertyTextField("Name: ", gameObject.getID());
		unmodifiableName.setDisable(true);
		inherentTextProperties.put("name",unmodifiableName);
		inherentTextProperties.put("image",new PropertyTextField("Image: ", gameObject.getCurrentImageName()));
//		inherentTextProperties.put("initXV", new PropertyTextField("Initial X Velocity", "0"));
//		inherentTextProperties.put("initYV", new PropertyTextField("Initial Y Velocity", "0"));
		inherentTextProperties.put("width", new PropertyTextField("Width: ", Double.toString(gameObject.getWidth())));
		inherentTextProperties.put("height",new PropertyTextField("Height: ", Double.toString(gameObject.getHeight())));
		
		
		concreteTextProperties.put("x",new PropertyTextField("X: ", Double.toString(gameObject.getX()+ OBJECT_X_OFFSET)));
		concreteTextProperties.put("y",new PropertyTextField("Y: ", Double.toString(gameObject.getY()+ OBJECT_Y_OFFSET)));
		concreteTextProperties.put("rotation", new PropertyTextField("Rotation: ", Double.toString(gameObject.getRotation())));
	
		
		physicsProperties.put("initXV", new PropertyTextField("Initial X Velocity", Double.toString(gameObject.getPhysicsBody().getVelocity().getX())));
		physicsProperties.put("initYV", new PropertyTextField("Initial Y Velocity", Double.toString(gameObject.getPhysicsBody().getVelocity().getY())));
		physicsProperties.put("mass", new PropertyTextField("Mass", Double.toString(gameObject.getPhysicsBody().getScalar("Mass").getValue())));
		
		
		for (String s : inherentTextProperties.keySet()) {
			coreBox.getChildren().add(inherentTextProperties.get(s));
		}
		for(String s: concreteTextProperties.keySet()){
			coreBox.getChildren().add(concreteTextProperties.get(s));
		}
		corePane.setContent(coreBox);
		
		
		for(String s : physicsProperties.keySet()){
			physicsBox.getChildren().add(physicsProperties.get(s));
		}
		physicsPane.setContent(physicsBox);
		
		
		HBox physicsBody = new HBox();
		CheckBox cbPhysics = new CheckBox("Physics Body");
		cbPhysics.setSelected(gameObject.getPhysicsBody() != null);
		physicsBody.getChildren().add(cbPhysics);
		booleanProperties.put("has physics", cbPhysics);
		
		for(String s: booleanProperties.keySet()){
			this.getChildren().add(booleanProperties.get(s));
		}

		Button editButton = new Button("Edit");
		editButton.setOnAction(myEditHandler);
		this.getChildren().add(editButton);

		Button saveAsNew = new Button("Save as New");
		saveAsNew.setOnMouseClicked(mySaveAsNewHandler);
		this.getChildren().add(saveAsNew);
		
		Button delete = new Button("Delete");
		delete.setOnAction(myDeleteHandler);
		this.getChildren().add(delete);
		
		myAccordion.getPanes().addAll(corePane, physicsPane);
		myAccordion.setExpandedPane(corePane);
		this.getChildren().add(myAccordion);

	}

	public GameObject edit(GameObject g) {

		GameObject edited = new GameObject(g.getComponents(), inherentTextProperties
				.get("image").getInformation(),
				Double.parseDouble(concreteTextProperties.get("x").getInformation())
						- OBJECT_X_OFFSET, Double.parseDouble(concreteTextProperties
						.get("y").getInformation()) - OBJECT_Y_OFFSET,
				Double.parseDouble(inherentTextProperties.get("height")
						.getInformation()), Double.parseDouble(inherentTextProperties
						.get("width").getInformation()),
				Double.parseDouble(concreteTextProperties.get("rotation")
						.getInformation()), g.getID());
		
		
		if (booleanProperties.get("has physics").isSelected()) {
			
			PhysicsBody pb = new PhysicsBody(Double.parseDouble(inherentTextProperties.get("width")
					.getInformation()), Double.parseDouble(inherentTextProperties
					.get("height").getInformation()));

			pb.addScalar(new Mass(Double.parseDouble(physicsProperties.get("mass").getInformation())));
			pb.setVelocity(new Vector(Double.parseDouble(physicsProperties.get("initXV").getInformation()), Double.parseDouble(physicsProperties.get("initYV").getInformation())));
			//may need to change
			
			edited.setPhysicsBody(pb);
		}
	
		return edited;
	}

	public Button setUpForNewObject() {
		this.getChildren().clear();
		for (String s : inherentTextProperties.keySet()) {
			PropertyTextField cleared = inherentTextProperties.get(s);
			cleared.setString("");
			this.getChildren().add(cleared);
		}
 
		for(String s: booleanProperties.keySet()){
			this.getChildren().add(booleanProperties.get(s));
		}
		
		Button b = new Button("Create");
		this.getChildren().add(b);
		return b;
	}

	public void saveAsNew() {

	}
	
	public Map<String, PropertyTextField> getWizardMap(){
		return wizardProperties;
	}
}
