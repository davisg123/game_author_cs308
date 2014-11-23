package authoring.view.generalcollectionview;

import java.util.ResourceBundle;

import javafx.scene.control.ToolBar;

public class CollectionsTool extends ToolBar {
	protected ResourceBundle myLanguage;
	protected double myHeight;
	protected double myWidth;

	public CollectionsTool(ResourceBundle language, double width, double height) {
		myLanguage = language;
		myHeight = height;
		myWidth = width;
	}
}
