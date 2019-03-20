/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iTravel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Abdelkader
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        

        Pane root = FXMLLoader.load(getClass().getResource("iTravel.fxml"));
        stage.setTitle("iTravel");
        stage.getIcons().add(new Image("/iTravel/WesternLogo.png"));
        stage.setScene(new Scene(root, 1190, 660));

        BackgroundImage bgImage = new BackgroundImage(new Image("/iTravel/westernbackground.png"), null, null, null, null);
        root.setBackground(new Background(bgImage));

        stage.show();
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
