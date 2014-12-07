package engine.scrolling;

import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.util.Duration;


/**
 * Handles dat scrolling doe (y)
 * 
 * Adaptation of Scrolling from Wayne Young's port of Silveira Neto's 
 * implementation of Scrolling in JavaFX 1.2
 * https://blogs.oracle.com/wayneyoung/entry/side_scroller_in_javafx_2
 * 
 * @author the WILL chang
 *
 */

public class ScrollingGroup extends Group {
        
    private List<Node> myScrollingNodes;
    private Timeline anim = new Timeline();

        public ScrollingGroup (List<Node> scrollingNodes, final int width) {
            myScrollingNodes = scrollingNodes;
            this.getChildren().addAll(scrollingNodes);
            anim.setCycleCount(Timeline.INDEFINITE);
            EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent t) {
                    for(Node n : scrollingNodes) {
                        n.setTranslateX(n.getTranslateX() - 1.0);
                        if(n.getLayoutX() + n.getTranslateX() + n.getBoundsInLocal().getWidth() <= 0) {
                            n.setTranslateX(width - n.getLayoutX());
                        }
                    }
                }
            };
            //KeyValue keyValueX = new KeyValue(Sliding.this.rotateProperty(),0);
            //KeyFrame keyFrame = new KeyFrame(new Duration(100), onFinished , keyValueX); //, keyValueY);
            //anim.getKeyFrames().add(keyFrame);
            anim.play();
        }

}
