package gamePlayer.view;

import javafx.scene.Node;
import javafx.scene.control.TabPane;

/**
 * 
 * @author Abhishek B
 *         https://introjava.wordpress.com/2012/04/08/java-fx-2-ribbon-menu/
 */

public class RibbonMenuBar implements ViewController {

	private TabPane myTabPane;
	private RibbonOptionsTab myOptionsTab;
	private RibbonPreferencesTab myPreferencesTab;

	public RibbonMenuBar() {
		myTabPane = new TabPane();
		buildTabs();
	}

	@Override
	public Node getNode() {
		return myTabPane;
	}

	private void buildTabs() {
		myOptionsTab = new RibbonOptionsTab("Options");
		myPreferencesTab = new RibbonPreferencesTab("Preferences");
		
		myTabPane.getTabs().addAll(myOptionsTab.getTab(), myPreferencesTab.getTab());
	}

}
