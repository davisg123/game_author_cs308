package authoring.model;

import java.util.ArrayList;
import java.util.List;

import authoring.view.graphicsview.Graphic;
import engine.sprite.Sprite;

public class SpritesCollection extends GameObjectCollection{
	
private List<Sprite> mySprites;
	
	public SpritesCollection(){
		mySprites = new ArrayList<Sprite>();
	}
	
	
	public void addSprite(Sprite s){
		mySprites.add(s);
		setChanged();
		notifyObservers(s);
	}

}
