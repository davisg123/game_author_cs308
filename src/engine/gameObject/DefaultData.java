package engine.gameObject;

import java.util.List;

import engine.gameObject.components.Component;
import engine.gameObject.components.PhysicsBody;

/**
 * @author Shreyas
 */

public class DefaultData {

	private double myRotation;
	
	private double myHeight; 
	private double myWidth; 
	
	private double myXCoord; 
	private double myYCoord; 
	
	private String myCurrentImageName; 
	
	private List<Component> myComponents;
		
	public DefaultData(List<Component> defaultComponents,
			String imagename, double x, double y,
			double height, double width, double rotation) {
		// TODO Auto-generated constructor stub
		myComponents=defaultComponents; 
		myCurrentImageName= imagename; 
		myXCoord=x; 
		myYCoord=y;
		myHeight=height; 
		myWidth=width; 
		myRotation=rotation; 

	}
	
	public List<Component> getComponents(){
		return myComponents; 
	}
	
	public String getImageName(){
		return myCurrentImageName; 
	}
	
	public double getXCoordinate(){
		return myXCoord; 
	}
	
	public double getYCoordinate(){
		return myYCoord; 
	}
	
	public double getHeight(){
		return myHeight;
	}
	
	public double getWidth(){
		return myWidth; 
	}
	
	public double getRotation(){
		return myRotation; 
	}

}
