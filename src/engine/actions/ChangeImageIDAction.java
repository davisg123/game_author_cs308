package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class ChangeImageIDAction extends IDAction{

	private String myPathName;
	
	public ChangeImageIDAction(List<Identifier> ids, String pathName){
		super(ids);
		myPathName = pathName; 
		
	}
	
	@Override
	public void execute() {
		for (GameObject object: myGameObjects){
			object.setCurrentImagePath(myPathName);
		}
	}

	
	
}
