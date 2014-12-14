package authoring.view.wizards;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import authoring.view.propertiesview.PropertyTextField;

public abstract class Wizard extends Stage{

	protected Map<String, PropertyTextField> myMap;
	protected VBox myWindow;
	protected String myTitle;
	protected Group myRoot;
	
	public Wizard(String title, double width, double height, EventHandler<ActionEvent> event){
		myMap = new LinkedHashMap<String, PropertyTextField>();
		myWindow = new VBox();
		myTitle = title;
		
		this.setTitle(title);
		this.initStyle(StageStyle.DECORATED);
		myRoot = new Group();
		
		myRoot.getChildren().add(initializeWizard(event));
		
		Scene scene = new Scene(myRoot, width, height);
		this.setScene(scene);
		this.show();
		
	}
	
	public abstract VBox initializeWizard(EventHandler<ActionEvent> event);

	public void addMapToWindow(){
		for(String s : myMap.keySet()){
			this.myWindow.getChildren().add(myMap.get(s));
		}
	}
	
	public Map<String, PropertyTextField> getMap(){
		return myMap;
	}
	
}