package authoring.model;

import java.io.Serializable;

/**
 * Passive data object that holds onto all of the
 * data that represents an authored game.
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 * @author Kevin Li
 *
 */
public class GameData implements Serializable{

	/**
	 * Maybe put in properties file?
	 */
	private static final long serialVersionUID = 6633782568176674709L;
	
	
	private LevelsCollection myLevels;
	private SoundsCollection mySounds;
	private GraphicsCollection myImages;
	private SpritesCollection mySprites;
//	private EventCollection myEvents; //events prompt actions and hold onto their corresponding action
//	private VariableCollection myVariables;
	
	
}
