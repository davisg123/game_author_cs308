package engine.actions;

import java.util.List;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class RotateImageIDAction extends IDAction {
    
    Double myAngle;

    public RotateImageIDAction (List<Identifier> ids, Double angle) {
        super(ids);
        myAngle = angle;
    }

    @Override
    public void execute () {
        for (GameObject g : myGameObjects){
            g.getRenderedNode().getImageView().setRotate(myAngle);
        }
    }

}
