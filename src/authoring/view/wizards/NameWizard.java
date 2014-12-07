package authoring.view.wizards;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.model.collections.GameObjectCollection;
import authoring.view.propertiesview.PropertyTextField;
import engine.gameObject.GameObject;
import errorsAndExceptions.ErrorPopUp;

public class NameWizard extends Wizard{

	
	private GameObjectCollection myGameObjectCollection;
	
	public NameWizard(String title, double width, double height,
			EventHandler<ActionEvent> event, GameObjectCollection col) {
		super(title, width, height, event);
		myGameObjectCollection = col;
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		PropertyTextField nameField = new PropertyTextField("Name: ", "");
		myMap.put("name", nameField);
		
		super.addMapToWindow();
		
		Button add = new Button("Add Game Object");
		add.setOnAction(event);
		myWindow.getChildren().add(add);
		
		return myWindow;
	}
	
	public boolean isDuplicatedID(String s){
		for(GameObject g : myGameObjectCollection){
			if(g.getID().equals(s)){
				return true;
			}			
		}
		return false;
	}
	
	public void updateObjectName(GameObject g){	
		String tryID = g.getID();
		if(!isDuplicatedID(tryID)){
			g.setID(tryID);
			close();
			myGameObjectCollection.add(g);
		}
		else{
			close();
			System.out.println(g.getID());
			System.out.println();
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Need to enter unique ID", false);
		}
		
		
	}

}
