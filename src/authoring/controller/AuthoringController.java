package authoring.controller;

import java.util.ResourceBundle;

import authoring.model.AuthoringModel;
import authoring.view.AuthoringView;
import authoring.view.GraphicsView;
import authoring.view.LevelsView;
import authoring.view.SoundsView;
import authoring.view.SpritesView;

public class AuthoringController {
	private AuthoringView myView;
	private AuthoringModel myModel;
	private ResourceBundle myLanguage;
	
	private LevelsView myLevels;
	private SpritesView mySprites;
	private GraphicsView myGraphics;
	private SoundsView mySounds;
	private double myWidth;
	private double myHeight;

	public AuthoringController(AuthoringView view, AuthoringModel model,
			double width, double height, ResourceBundle resource) {
		myView = view;
		myModel = model;
		myWidth = width;
		myHeight = height;
		myLanguage = resource;
		initializeView();
	}

	private void initializeView() {
		myView.setCenter(new LevelsView(myWidth, myHeight));

	}

}
