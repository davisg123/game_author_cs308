package authoring.view;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import authoring.controller.AuthoringController;
import authoring.model.AuthoringModel;
import authoring.model.GameData;
import data.DataManager;

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
	private FileChooser myFileChooser;
	private DirectoryChooser myDirectoryChooser;
	Map ControllerMap;
	private DataManager myDataManager;

	public ProgramMenu(TabPane tab, Locale locale, double width, double height) {
		myWidth = width;
		myHeight = height;
		myLocale = locale;
		myTabs = tab;
		myLanguage = ResourceBundle.getBundle(DEFAULT_RESOURCE, myLocale);
		// ControllerMap = new HashMap<>
		myFileChooser = new FileChooser();
		myDirectoryChooser = new DirectoryChooser();
		myDataManager = new DataManager();
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
		FileMenu.getItems().addAll(newFile(), saveFile(), loadFile());
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

	private MenuItem saveFile() {
		MenuItem saveFile = new MenuItem(myLanguage.getString("Save"));
		saveFile.setOnAction(handle -> saveData());
		return saveFile;
	}

	private void saveData() {
		int currentTab = myTabs.getSelectionModel().getSelectedIndex();
		((AuthoringView) myTabs.getTabs().get(currentTab).getContent())
				.getController().saveData();

	}
	
	private MenuItem loadFile(){
		MenuItem loadFile = new MenuItem(myLanguage.getString("Load"));
		loadFile.setOnAction(handle -> loadData());
		return loadFile;
	}

	private void loadData(){
		File gameLocation = myDirectoryChooser.showDialog(new Stage());
		if (gameLocation != null) {
			setupGame(gameLocation);
		}
		try {
			GameData gameData = myDataManager.readGameFile(gameLocation);
			System.out.println("game loaded");
			int currentTab = myTabs.getSelectionModel().getSelectedIndex();
			((AuthoringView) myTabs.getTabs().get(currentTab).getContent())
					.getController().loadData(gameData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method for adding a new tab.
	 */

	private void addNew() {
		
		File gameLocation = myFileChooser.showSaveDialog(new Stage());
		if (gameLocation != null) {
			makeFolders(gameLocation);
			setupGame(gameLocation);
		}
	}

	private void setupGame(File gameLocation) {
		Tab tab = new Tab(gameLocation.getName());
		AuthoringView newView = new AuthoringView(myWidth, myHeight);
		AuthoringModel newModel = new AuthoringModel();
		AuthoringController newController = new AuthoringController(
				newView, newModel, myWidth, myHeight, myLanguage, gameLocation);
		newView.setController(newController);
		tab.setContent(newView);
		myTabs.getTabs().add(tab);
		myTabs.getSelectionModel().select(tab);
	}

	private void makeFolders(File gameLocation) {
		gameLocation.mkdir();
		File imageFolder = new File(gameLocation.getPath() + "/" 
				+ DataManager.IMAGES_FOLDER_NAME);
		imageFolder.mkdir();
		File soundFolder = new File(gameLocation.getPath() + "/" 
				+ DataManager.SOUNDS_FOLDER_NAME);
		soundFolder.mkdir();
		File progressFolder = new File(gameLocation.getPath() + "/" 
				+ DataManager.PROGRESS_FOLDER_NAME);
		progressFolder.mkdir();
	}
}
