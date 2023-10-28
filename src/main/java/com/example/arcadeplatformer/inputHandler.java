package com.example.arcadeplatformer;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public interface inputHandler {

    void setInputs(KeyEvent e);
    void unSetInputs(KeyEvent e);

    void bindToScene(Scene scene);
}
