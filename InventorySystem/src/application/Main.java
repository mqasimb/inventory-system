package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Screen");
        Button add = new Button();
        add.setText("Add");
        
        Button modify = new Button();
        modify.setText("Modify");
        
        Button delete = new Button();
        delete.setText("Delete");
        
        Button search = new Button();
        search.setText("Search");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
// 
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
        add.setOnAction(event ->
        	System.out.println("Hellow World!")
        		);
        
        StackPane root = new StackPane();
        root.getChildren().addAll(add, modify, delete, search);
        primaryStage.setScene(new Scene(root, 1000, 750));
        primaryStage.show();
    }
}