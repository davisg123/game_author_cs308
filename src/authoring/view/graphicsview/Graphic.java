package authoring.view.graphicsview;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.Properties;

/**
 * Represents an image, but does not instantiate JavaFX object so that the
 * object can easily be serialized if necessary.
 * 
 * @author Chris Bernt
 * @author Kevin Li
 * @author Arjun Jain
 * @author Wesley Valentine
 *
 */
public abstract class Graphic extends VBox {

	protected String myImagePath;
	protected GameHandler[] myOnClick;
	protected GameHandler myEditButtonBehavior;
	private boolean myIsVisible = true;
	protected ImageView myImageView;
	
	protected double myWidth;
	protected double myHeight;
	protected double myRotation;

	public Graphic(String name, File location, GameHandler... event) {
		myOnClick = event;
		myImagePath = name;

		myWidth = 50;
		myHeight = 50;
		myRotation = 0;
		
		makeGraphic(location);
		
	}
	
	public Graphic(String name, GameHandler... event){
		myOnClick = event;
		myImagePath = name;
		myImageView = new ImageView();
	}

	/**
	 * creates an instance of the JavaFX object that can be displayed on the
	 * GUI. Takes in a MouseEvent so that the graphic will respond to the
	 * specified events.
	 * 
	 * @param event
	 */
	
	private void makeGraphic(File gameLoc){
		File file = new File(gameLoc.getPath() + "/images/" + myImagePath);
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			
			myImageView = new ImageView(image);

			
			myImageView.setFitHeight(myHeight);
			myImageView.setFitWidth(myWidth);
			myImageView.setRotate(myRotation);
			
			
			this.getChildren().add(myImageView);

			
			for (GameHandler g : myOnClick) {
				this.addEventFilter(g.getEventType(), g);
			}
			
			
			
		} catch (IOException e) {
			System.out.println("Couldn't use path");
		}
	}
	
	public void setDimensions(double width, double height, double rotation){
		myWidth = width;
		myHeight = height;
		myRotation = rotation;
		myImageView.setFitHeight(myHeight);
		myImageView.setFitWidth(myWidth);
		myImageView.setRotate(myRotation);
	}

	public void addLabel(){
		this.getChildren().add(new Text(myImagePath));
	}
	
	public abstract Properties makeProperties();
	
	
	public String getName() {
		return myImagePath;
	}

	public boolean getVisible() {
		return myIsVisible;
	}
	
	public void setEditButtonBehavior(GameHandler edit){
		myEditButtonBehavior = edit;
		System.out.println("behave set in graphic");
	}

}
