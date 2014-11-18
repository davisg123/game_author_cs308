package gamePlayer.view;

import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

public abstract class RibbonMenuTab {
	
	protected Tab myRibbonTab;
	protected HBox myContainer;
	
	public RibbonMenuTab(String ribbonTabTitle) {
		myRibbonTab = new Tab(ribbonTabTitle);
	}
	
	protected void buildButton() {
		
	}
	
}
