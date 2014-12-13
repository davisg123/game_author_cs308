package gamePlayer.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import authoring.model.GameData;
import data.DataManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class that displays names of available progress states and lets user 
 * choose progress state. Hides actual files from user.
 * 
 * @author Eli Lichtenberg
 */
public class ProgressSelector {
	
	ObservableList<String> myProgressList;
	ListView<String> myProgressListView;
	String selectedProgressState;
	File myProgressFolder;
	DataManager myDataManager;
	
	public ProgressSelector(File gameLocation) {
		myProgressFolder = new File(gameLocation, DataManager.PROGRESS_FOLDER_NAME);
		myDataManager = new DataManager();
		myProgressList = FXCollections.observableArrayList();
		updateProgressList();
		myProgressListView = new ListView<String>(myProgressList);
		addListViewListener();
	}
	
	private void addListViewListener() {
		myProgressListView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						selectedProgressState = newValue;
						System.out.println(selectedProgressState);
					}
				});
	}

	private void updateProgressList() {
		File[] progressFiles = myProgressFolder.listFiles();
		for(File f : progressFiles) {
			if(!myProgressList.contains(f.getName())) {
				myProgressList.add(f.getName());
			}
		}
		
	}

	public GameData loadProgressState() {
		updateProgressList();
		VBox root = setupWindow("Choose progress state");		
		return null;
	}
	
	public boolean saveProgressState() {
		updateProgressList();
		VBox root = setupWindow("Save or overwrite progress state");
		TextField name = new TextField();
		HBox header = new HBox();
		root.getChildren().add(header);
		header.toBack();
		name.setPromptText("Enter name for progress state");
		name.setPrefColumnCount(10);
		header.getChildren().add(name);
		Button saveButton = new Button();
		saveButton.setText("SAVE");
		header.getChildren().add(saveButton);
		return true;
	}
	
	private VBox setupWindow(String title) {
		Stage progressStage = new Stage();
		progressStage.setTitle(title);
		VBox root = new VBox();
		root.getChildren().add(myProgressListView);
		Scene scene = new Scene(root, 400, 400);
		progressStage.setScene(scene);
		progressStage.show();
		return root;
	}

}
