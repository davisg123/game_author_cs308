package authoring.view.baseclasses;

import javafx.scene.control.Accordion;

/**
 * Base class that other classes can extend or call to create an accordian.
 * 
 * @author Kevin Li
 *
 */
public class AccordionContainer extends Accordion {

	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.20;

	public AccordionContainer(double width, double height) {
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
	}

	private void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}
}
