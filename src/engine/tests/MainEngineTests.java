package engine.tests;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;
import engine.GameManager;
import engine.level.Level;
import engine.render.SpriteRenderer;
import engine.sprite.Sprite;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainEngineTests extends Application {

    private GameManager myGameManager;
    private Stage myStage;
    private Group myRootGroup;
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start (Stage arg0) throws Exception {
        myStage = arg0;
        myStage.setTitle("");

        myRootGroup = new Group();

        Scene myScene = new Scene(myRootGroup,300,300);
       /* ImageView view = new ImageView();
       
        Image image = new Image(getClass().getResourceAsStream("resources/images/slowpoke.jpg"));
        view.setImage(image);
        Group asdf = new Group();
        asdf.getChildren().add(view);
        myRootGroup.getChildren().add(asdf);*/
        myStage.setScene(myScene);
        myStage.show();
        createSprite(myRootGroup);
        
    }
    
    public void createSprite (Group group) {
        Point2D location = new Point2D.Double(50,50);
        Sprite sprite = new Sprite(null,"slowpoke.jpg",
                                   location, 100, 100, 0, "TestSprite");
        List<Sprite> mySpriteList = new ArrayList<Sprite>();
        mySpriteList.add(sprite);
        myGameManager = new GameManager(null,mySpriteList,group);
        Level level0 = new Level(mySpriteList,null);
        SpriteRenderer mySpriteRenderer = new SpriteRenderer(group);
        mySpriteRenderer.renderSprites(level0);
        
    }

    
}
