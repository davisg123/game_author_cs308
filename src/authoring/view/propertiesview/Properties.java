package authoring.view.propertiesview;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.layout.VBox;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public abstract class Properties extends VBox {

	protected Map<String, PropertyField> myMap = new LinkedHashMap<String, PropertyField>();

	public abstract void initializeProperties(Object o); // game object, level,
															// sound, image...

	public void addMapToView() {
		for (String s : myMap.keySet()) {
			this.getChildren().add(myMap.get(s));
		}
	}

}
