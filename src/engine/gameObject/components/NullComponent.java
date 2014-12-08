package engine.gameObject.components;

import engine.gameObject.GameObject;
import engine.gameObject.components.properties.IProperty;

/**
 * Takes the place of a Null Object.
 * @author Will Chang
 */

public class NullComponent extends Component {



    @Override
    public void update (GameObject object) {
        return;
    }

    @Override
    public String getID () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Component getClone() {
        // TODO Auto-generated method stub
        return null;
    }

}
