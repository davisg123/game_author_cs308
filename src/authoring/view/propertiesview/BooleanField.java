package authoring.view.propertiesview;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class BooleanField extends PropertyField {

	private CheckBox myCheckBox;

	public BooleanField(String label, boolean value) {
		this.getChildren().add(new Text(label));
		myCheckBox = new CheckBox();
		myCheckBox.setSelected(value);
		this.getChildren().add(myCheckBox);
	}

	public boolean getInformation() {
		return myCheckBox.isSelected();
	}

	public void setValue(boolean b) {
		myCheckBox.setSelected(b);
	}
}
