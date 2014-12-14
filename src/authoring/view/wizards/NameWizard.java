package authoring.view.wizards;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.model.collections.GameObjectsCollection;
import authoring.view.propertiesview.PropertyTextField;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import errorsAndExceptions.ErrorPopUp;

public abstract class NameWizard extends Wizard{

	
	private GameObjectsCollection myCollection;
	
	
	public NameWizard(String title, double width, double height,
			EventHandler<ActionEvent> event, GameObjectsCollection col) {
		super(title, width, height, event);
		myCollection = col;
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		PropertyTextField nameField = new PropertyTextField(myTitle + ": ", "");
		myMap.put("name", nameField);
		
		super.addMapToWindow();
		
		Button add = new Button("Add Game Object");
		add.setOnAction(event);
		myWindow.getChildren().add(add);
		
		return myWindow;
	}
	
	
	public boolean isDuplicated(String s){
		for(GameObject g : myCollection){
			if(getIdentifierComponent(g).equals(s)){
				return true;
			}			
		}
		return false;
	}
	
	
	/**
	 * Gets the desired identifier component. Determines if
	 * the duplicate check is for the type or unique ID of the 
	 * game object.
	 * @param g GameObject to be checked
	 * @return The type ID or unique ID of the game object
	 */
	protected abstract String getIdentifierComponent(GameObject g);

}
