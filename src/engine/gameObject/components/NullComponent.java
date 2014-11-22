package engine.gameObject.components;

import engine.gameObject.GameObject;
import engine.gameObject.components.properties.IProperty;

/**
 * Takes the place of a Null Object.
 * @author Will Chang
 */

public class NullComponent extends Component {

    @Override
    public void addProperty (IProperty property) {
        return;
    }

    @Override
    public void removeProperty (IProperty property) {
        return;
    }

    @Override
    public void update (GameObject object) {
        return;
    }

}
