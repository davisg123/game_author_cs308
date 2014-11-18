package engine.render;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Will
 *
 */

public class RenderedNode extends Group {
    private ImageView myImageView;
    private Node myCollisionBody;
    private String myImagePath;
    //visibility....

    public void setCollisionBody(Node body) {
        //Handle null case
        if(body != null) {
            myCollisionBody = body;
            this.getChildren().add(myCollisionBody);
        }
    }
    public void setImageView(ImageView view) {
        //Handle null case
        if(view != null) {
            myImageView = view;
            this.getChildren().add(myImageView);
        }
    }
    public ImageView getImageView() {
        return myImageView;
    }
    
    public Node getCollisionBody () {
        return myCollisionBody;
    }
    
    @Override
    public boolean intersects (Bounds localBounds) {
        return (myCollisionBody != null) ? myCollisionBody.intersects(localBounds): false;
    }
}
