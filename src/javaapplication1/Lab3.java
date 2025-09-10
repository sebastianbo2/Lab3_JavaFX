/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 6305020
 */
public class Lab3 extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage stage) {
        stage.setTitle("Lab3_ImageGenerator");
        
        Label topLabel = new Label("Random Game");
        Label bottomLabel = new Label("Waiting");
        
        Label leftPlaceholder = new Label("LEFT");
        Label rightPlaceholder = new Label("RIGHT");
        
        StackPane center = new StackPane();
        
        BorderPane root = new BorderPane(center, topLabel, rightPlaceholder, bottomLabel, leftPlaceholder);
        
        String imagePathTemplate = "file:images/";
        
        Random random = new Random();
        
        int randIndex = random.nextInt(20) + 101;
        
        Image randomImage = new Image(imagePathTemplate + randIndex + ".jpg");
        ImageView imgView = new ImageView(randomImage);
        
        Label imgLabel = new Label();
        imgLabel.setGraphic(imgView);
        
        center.getChildren().add(imgView);
        
        Scene scene = new Scene(root, 250, 300);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
