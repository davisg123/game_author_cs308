package gamePlayer.view;

import java.io.File;
import java.io.IOException;

import authoring.model.GameData;
import data.DataManager;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class that displays names of available progress states and lets user 
 * choose progress state. Hides actual files from user.
 * 
 * @author Eli Lichtenberg
 */
public class ProgressSelector {
	
	private static final int TEXT_COLUMN_COUNT = 20;
	ObservableList<String> myProgressList;
	ListView<String> myProgressListView;
	String selectedProgressState;
	File myGameLocation;
	File myProgressFolder;
//	GameData myGameData;
	DataManager myDataManager;
//	BooleanProperty myProgressLoaded;
	StringProperty myProgressFileName;
	Stage myProgressStage;
	
//	public ProgressSelector(File gameLocation, GameData gameData, 
//			BooleanProperty progressLoaded, StringProperty progressFileName) {
	public ProgressSelector(File gameLocation, StringProperty progressFileName) {
		myGameLocation = gameLocation;
		myProgressFolder = new File(gameLocation, DataManager.PROGRESS_FOLDER_NAME);
//		myGameData = gameData;
//		if(myGameData == null) System.out.println("super null");
		myDataManager = new DataManager();
		myProgressList = FXCollections.observableArrayList();
		//updateProgressList();
		myProgressListView = new ListView<String>(myProgressList);
		addListViewListener();
//		myProgressLoaded = progressLoaded;
		myProgressFileName = progressFileName;
	}
	
	private void addListViewListener() {
		myProgressListView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						selectedProgressState = newValue;
					}
				});
	}

	private void updateProgressList() {
		File[] progressFiles = myProgressFolder.listFiles();
		for(File f : progressFiles) {
			if(f.getName().contains(".json")) {
				System.out.println(f.getName());//.indexOf(".json"));
				String fileName = f.getName().substring(0, f.getName().indexOf(".json"));
				if(!myProgressList.contains(fileName)) {
					myProgressList.add(fileName);
				}
			}
		}
		FXCollections.sort(myProgressList);
	}

	public void loadProgressState() {
		updateProgressList();
		buildLoadWindow();
	}

	private void buildLoadWindow() {
		VBox root = setupWindow("Load from progress state");
		Button loadButton = new Button();
		loadButton.setText("LOAD");
		loadButton.setOnAction(event -> loadProgressEvent());
		root.getChildren().add(loadButton);
	}
	
	private void loadProgressEvent() {
//		System.out.println("loading");
//		if(myGameData==null) System.out.println("i'm null");
//		System.out.println(myGameData);
//		System.out.println(myGameData.getGameObjects());
//		GameData tempData = myDataManager.readProgressFile(myGameLocation, selectedProgressState);
//		myGameData = tempData;
//		System.out.println(myGameData);
//		System.out.println(myGameData.getGameObjects());
		myProgressStage.close();
//		myProgressLoaded.set(true);
		myProgressFileName.set(selectedProgressState);
//		System.out.println(selectedProgressState);
	}
	
	public void saveProgressState(GameData saveData) {
		updateProgressList();
		buildSaveWindow(saveData);
	}

	private void buildSaveWindow(GameData saveData) {
		VBox root = setupWindow("Save or overwrite progress state");
		TextField name = new TextField();
		HBox header = new HBox();
		root.getChildren().add(header);
		header.toBack();
		name.setPromptText("Enter name for progress state");
		name.setPrefColumnCount(TEXT_COLUMN_COUNT);
		header.getChildren().add(name);
		Button saveButton = new Button();
		saveButton.setText("SAVE");
		saveButton.setOnAction(event -> saveProgressEvent(name, saveData));
		header.getChildren().add(saveButton);
		Button overwriteButton = new Button();
		overwriteButton.setText("OVERWRITE");
		overwriteButton.setOnAction(event -> overwriteProgressEvent(saveData));
		root.getChildren().add(overwriteButton);
	}
	
	private void saveProgressEvent(TextField name, GameData saveData) {
		String saveText = name.getText();
		try {
			myDataManager.writeProgressFile(saveData, myGameLocation, saveText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myProgressStage.close();
	}
	
	private void overwriteProgressEvent(GameData saveData) {
		try {
			myDataManager.writeProgressFile(saveData, myGameLocation, selectedProgressState);
		} catch (IOException e) {
			e.printStackTrace();
		}
		myProgressStage.close();
	}
	
	private VBox setupWindow(String title) {
		myProgressStage = new Stage();
		myProgressStage.setTitle(title);
		VBox root = new VBox();
		root.getChildren().add(myProgressListView);
		Scene scene = new Scene(root, 400, 400);
		myProgressStage.setScene(scene);
		myProgressStage.show();
		return root;
	}

}
