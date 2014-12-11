package engine.scrolling;

import javafx.scene.Camera;
import javafx.scene.ParallelCamera;

/**
 * For specialized scrolling 
 * @author Will Chang
 *
 */

public class ScrollingUtility {
    private Camera myCamera;
    
    public ScrollingUtility () {
        myCamera = new ParallelCamera();
    }
    
    public void translateX (double value) {
        myCamera.setTranslateX(value);
    }
    
    public void translateY (double value) {
        myCamera.setTranslateY(value);
    }
    
    public Camera getCamera () {
        return myCamera;
    }
    
}
