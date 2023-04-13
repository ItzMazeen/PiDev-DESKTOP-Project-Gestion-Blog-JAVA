/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author mazee
 */
public class FirstFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Index.FXML"));
            Scene scene = new Scene(root);
        
        primaryStage.setTitle("Gestion Article");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException ex) {
        System.out.println(ex.getMessage());        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
