package engine.actions.render;

import java.util.List;

import javafx.scene.Group;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.level.Level;
import engine.render.GameObjectRenderer;

public class EraseCanvas extends RenderAction {

    public EraseCanvas (List<GameObject> objects, GameObjectRenderer renderer, Level level) {
        super(objects, renderer, level);
    }
    
    @Override
    protected void applyRender () {
        for(GameObject object : myGameObjects) {
            myRenderer.removeRenderedNode(object.getID());
            //Should add an action???... separate it into the condition?..
            //TODO myLevel.remove(object);
            
        }
    }

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}
    
}
