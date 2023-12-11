package com.example;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class startScreenController {
    public ListView TopTenDisplay;
    //private String scene="";

    public static void initialize(){
        fillTable();
    }

    public void StartGame(){
        Stage.setScene(scene);
    }
}
