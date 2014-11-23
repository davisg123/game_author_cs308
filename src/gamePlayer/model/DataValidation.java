package gamePlayer.model;

/**
 * 
 * @author Abhishek B
 *
 */
public class DataValidation {

	public boolean checkDataValid(DataWrapper dataWrapper) {

		return dataWrapper.getGameObjects() == null
				|| dataWrapper.getConditions() == null;

	}
}
