package authoring.view;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import authoring.controller.AuthoringController;
import authoring.model.AuthoringModel;

/**
 * Class that contains the MenuBar for the authoring environments. Users can
 * open new or saved files, save files, or change general settings such as
 * language.
 * 
 * @author Kevin Li
 *
 */
public class ProgramMenu extends MenuBar {
	private static final String DEFAULT_RESOURCE = "authoring.resources.languages/language";
	private Locale myLocale;
	private ResourceBundle myLanguage;

	TabPane myTabs;
	private double myWidth;
	private double myHeight;
	FileChooser myFileChooser;

	public ProgramMenu(TabPane tab, Locale locale, double width, double height) {
		myWidth = width;
		myHeight = height;
		myLocale = locale;
		myTabs = tab;
		myLanguage = ResourceBundle.getBundle(DEFAULT_RESOURCE, myLocale);
		myFileChooser = new FileChooser();
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
	 * authoring environments. This is where the controller, view, and model are
	 * instantiated and connected with one another.
	 * 
	 * @return MenuItem that allows new files to be created.
	 */

	private MenuItem newFile() {
		MenuItem newFile = new MenuItem(myLanguage.getString("New"));
		newFile.setOnAction(handle -> addNew());
		return newFile;

	}

	/**
	 * Method for adding a new tab.
	 */

	private void addNew() {
		File gameFile = myFileChooser.showSaveDialog(new Stage());
		if (gameFile != null) {
			makeFolders(gameFile);
			Tab tab = new Tab(gameFile.getPath());
			AuthoringView newView = new AuthoringView(myLanguage, myWidth,
					myHeight);
			AuthoringModel newModel = new AuthoringModel();
			AuthoringController newController = new AuthoringController(
					newView, newModel, myWidth, myHeight, myLanguage);
			tab.setContent(newView);
			myTabs.getTabs().add(tab);
			myTabs.getSelectionModel().select(tab);
		}
	}

	private void makeFolders(File gameFile) {
	gameFile.mkdir();
	File imageFolder = new File(gameFile.getPath() +"/images");
    imageFolder.mkdir();
    File soundFolder = new File(gameFile.getPath() +"/sounds");
    soundFolder.mkdir();
		
	}
}
