package data;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import engine.actions.Action;
import engine.actions.render.RenderAction;
import engine.conditions.Condition;
import engine.conditions.TimeCondition;
import engine.gameObject.GameObject;
import engine.gameObject.components.Component;

public class SampleWrapper {
	
//	public List<Double> myNumbers;
//	public String word;
//	
//	public SampleWrapper() {
//		myNumbers = new ArrayList<Double>();
//		myNumbers.add(5.0);
//		myNumbers.add(22.0);
//		word = "qwerty";
//	}
	
	private List<GameObject> spriteList;
	private List<Condition> conditionList;
	
	public SampleWrapper() {
		spriteList = new ArrayList<GameObject>();
		conditionList = new ArrayList<Condition>();
		addSprites();
		addConditions();
	}

	private void addSprites() {
		// TODO Auto-generated method stub
		GameObject s1 = new GameObject("duvall");
		GameObject s2 = new GameObject(new ArrayList<Component>(), "name of image", new Point2D.Double(1, 4), 
				50.0, 20.0, 45.0, "hank");
		spriteList.add(s1);
		spriteList.add(s2);
	}

	private void addConditions() {
		// TODO Auto-generated method stub
		List<Action> actionList = createActionList();
		Condition c1 = new TimeCondition(actionList, spriteList, 5, false);
		conditionList.add(c1);
	}
	
	private List<Action> createActionList() {
		Action a1 = new RenderAction(spriteList);
		List<Action> actionList = new ArrayList<Action>();
		actionList.add(a1);
		return actionList;
	}
	
	public String toString() {
		return spriteList.toString() + "\n" + conditionList.toString();
	}
	
	public String getSpriteName() {
		return spriteList.get(0).getID();
	}
}
