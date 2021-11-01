
package game;

import core.Scene;
import core.gamesystem.KeyboardInput;
import core.gamesystem.Timer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

    public void start(Stage theStage) 
    {
        theStage.setTitle( "Canvas Example" );
        
        Group root = new Group();
        javafx.scene.Scene javaFxScene = new javafx.scene.Scene( root );
        theStage.setScene( javaFxScene );
            
        Canvas canvas = new Canvas( 400, 200 );
        root.getChildren().add( canvas );
           
        GraphicsContext gc = canvas.getGraphicsContext2D();
        theStage.show();
        
        
        // Make scene
        Scene scene = new Scene(gc);
        
        // Add GameSystem
        Timer timer = new Timer();
        scene.addGameSystem(timer);
        KeyboardInput keyboardInput = new KeyboardInput(javaFxScene);
        scene.addGameSystem(keyboardInput);
        
        // Add GameObject
        Rectangle rectangle1 = new Rectangle(100, 100, Color.RED);
        scene.addGameObject(rectangle1);
        
        // RUN
        scene.start();
            
//        gc.setFill( Color.RED );
//        gc.setStroke( Color.BLACK );
//        gc.setLineWidth(2);
//        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
//        gc.setFont( theFont );
//        gc.fillText( "Hello, World!", 60, 50 );
//        gc.strokeText( "Hello, World!", 60, 50 );
        
        // Image earth = new Image( "earth.png" );
        // gc.drawImage( earth, 180, 100 );
            
    }
}
