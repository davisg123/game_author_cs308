package engine.conditions;

import static org.junit.Assert.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.Assert;
import application.Main;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConditionTests {
    
    private static Stage myStage;
    
    @Test
    public void testA() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            myStage = new Stage();
                            System.out.println(myStage);
                            new Main().start(myStage);
                        }
                        catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
        thread.start();// Initialize the thread
        Thread.sleep(1000);
    }
    
    @Test
    public void testStageExists(){
        assertNotEquals(myStage,null);
    }

}
