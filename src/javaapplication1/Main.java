/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 6305020
 */
public class Main extends Application {
    
    public boolean testValid(int[][] nums, int i, int j) {
        System.out.println("Hello world");
        
        boolean flag = false;
        
        for (int c = 0; c < 9; c++) {
            if (c != j && nums[i][j] == nums[i][c]) {
                return false;
            }
            
            if (c != i && nums[c][j] == nums[i][j]) {
                return false;
            }
            
            if (nums[((int) i / 3) * 3 + c % 3][((int) j / 3) * 3 + c % 3] == nums[i][j]) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        
        return true;
    }
    
    public void solve(int[][] nums, int i, int j) {
//        for (int c = 0; c < 9; c++) {
//                System.out.println(Arrays.toString(nums[i]));
//            }
        
        if (i >= 8) {
            i = 0;
            j += 1;
        } 
        
        if (j >= 8) {
            for (int c = 0; c < 9; c++) {
                System.out.println(Arrays.toString(nums[i]));
            }
            
            return;
        }
        
        for (int c = 1; c < 10; c++) {
            if (nums[i][j] == 0) {
                nums[i][j] = c;
                boolean test = testValid(nums, i, j);
                
                if (!test) {
                    System.out.println("False board!");
                    for (int ctr = 0; ctr < 9; ctr++) {
                         System.out.println(Arrays.toString(nums[ctr]));
                    }
                    nums[i][j] = 0;
                    return;
                }
                
                solve(nums, i + 1, j);
                
                nums[i][j] = 0;
            } else {
                solve(nums, i + 1, j);
            }
        }
        
    }
    
    public void fill(TextField[][] grid) {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello world");
        
        Button btn = new Button("Click me!");
        
        VBox root = new VBox();
                
        GridPane grid = new GridPane(10, 10);
        
        TextField[][] gridFields = new TextField[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField temp = new TextField();
                temp.setPadding(new Insets(10));
                
                grid.add(temp, j, i);
                gridFields[i][j] = temp;
            }
        }
        
        
        
        root.getChildren().addAll(grid, btn);
        
        btn.setOnAction(event -> {
            System.out.println("Button clicked!");
            
            int[][] nums = new int[9][9];
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    nums[i][j] = Integer.parseInt((gridFields[i][j].getText().isEmpty()) ? "0": gridFields[i][j].getText());
                }
            }
            
            for (int i = 0; i < 9; i++) {
                System.out.println(Arrays.toString(nums[i]));
            }
            
            System.out.println("Solving!!!");
            solve(nums, 0, 0);
            
            
            // Add your desired actions here
        });
        
//        Image img = new Image("file:src/HotAirBalloon.jpg");
//        ImageView imgView = new ImageView(img);
//        root.getChildren().add(imgView);
        
        
        Scene scene = new Scene(root, 600, 600);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
