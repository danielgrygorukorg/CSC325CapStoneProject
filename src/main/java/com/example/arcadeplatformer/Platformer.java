package com.example.arcadeplatformer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Platformer extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Platformer.class.getResource("hello-view.fxml"));
        Controller controller = new Controller();
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Platformer");
        stage.setScene(scene);
        stage.show();

        Player p = new Player();
        p.loadSprite("robot.png");
        p.setMaze(new Image("maze.png"));
        p.setGraphicsContext(controller.gc);
        p.setX(26);
        p.setY(270);
        p.setResetX(p.getX());
        p.setResetY(p.getY());
        p.setMask(new Mask(p.getbBoxW(),p.getbBoxW()));
        p.propogate(1);
        controller.addToLevel(p);




        //begin animation and thread
        controller.startRendering();

        controller.bindToScene(scene);
       stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("closing threads");
                controller.stopRendering();
            }
        });
    }
    public void focusCanvas(Canvas canvas){
        canvas.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }


}