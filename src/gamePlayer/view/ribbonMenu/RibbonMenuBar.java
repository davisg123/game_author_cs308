package gamePlayer.view.ribbonMenu;

import gamePlayer.view.ViewController;
import javafx.scene.Node;
import javafx.scene.control.TabPane;

/**
 * 
 * @author Abhishek B
 * https://introjava.wordpress.com/2012/04/08/java-fx-2-ribbon-menu/
 */

public class RibbonMenuBar implements ViewController {
	
	private TabPane myTabPane;
	
	public RibbonMenuBar() {
		myTabPane = new TabPane();
		buildTabs();
	}

	@Override
	public Node getNode() {
		return myTabPane;
	}
	
	private void buildTabs() {
		
	}

}
