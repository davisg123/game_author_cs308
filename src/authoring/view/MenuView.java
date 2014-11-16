package authoring.view;

import java.util.Locale;
import java.util.ResourceBundle;

import authoring.controller.AuthoringController;
import authoring.model.AuthoringModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Class that contains the MenuBar for the authoring environments. Users can
 * open new or saved files, save files, or change general settings such as
 * language.
 * 
 * @author Kevin Li
 *
 */
public class MenuView extends MenuBar {
	private static final String DEFAULT_RESOURCE = "authoring.resources.languages/language";
	private Locale myLocale;
	private ResourceBundle myLanguage;

	TabPane myTabs;
	private double myWidth;
	private double myHeight;

	public MenuView(TabPane tab, Locale locale, double width, double height) {
		myWidth = width;
		myHeight = height;
		myLocale = locale;
		myTabs = tab;
		myLanguage = ResourceBundle.getBundle(DEFAULT_RESOURCE, myLocale);
		this.getMenus().add(FileMenu());

	}

	/**
	 * Method that creates the menu for all File related features such as open,
	 * save, new file, etc.
	 * 
	 * @return Menu containing MenuItems that allows the user to save, open, and
	 *         generate new authoring environments.
	 */
	private Menu FileMenu() {
		Menu FileMenu = new Menu(myLanguage.getString("File"));
		FileMenu.getItems().add(newFile());
		return FileMenu;
	}

	/**
	 * Creates a menuItem that allows the user to open new instances of
	 * authoring environments.
	 * 
	 * @return MenuItem that allows
	 */

	private MenuItem newFile() {
		MenuItem newFile = new MenuItem(myLanguage.getString("New"));
		newFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {

				Tab tab = new Tab(myLanguage.getString("Program"));
				AuthoringView newView = new AuthoringView(myWidth,
						myHeight);
				AuthoringModel newModel = new AuthoringModel();
				AuthoringController newController = new AuthoringController(
						newView, newModel, myWidth, myHeight, myLanguage);
				tab.setContent(newView);
				myTabs.getTabs().add(tab);
				myTabs.getSelectionModel().select(tab);
			}
		});
		return newFile;

	}

}
