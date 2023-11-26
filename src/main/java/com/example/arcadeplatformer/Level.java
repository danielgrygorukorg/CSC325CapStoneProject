package com.example.arcadeplatformer;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Level {
    private double width;
    private double height;
    private static final int DEF_WIDTH=500;
    private static final int DEF_HEIGHT=500;
    private static Level level;
    private GraphicsContext gc;
    protected ArrayList<GameObject> gameObjects;
//only one level can ever exist at a single time
    //lets me use default methods on interface that reference this
    private Level(int width, int height) {
        this.width= width;
        this.height=height;
        gameObjects = new ArrayList<GameObject>();
    }
public static Level getLevel(){
        if (level==null){
            level = new Level(Level.DEF_WIDTH,Level.DEF_HEIGHT);
        }
        return level;
}

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public double getHeight() {
        return  this.height;
    }
    public double getWidth(){
        return this.width;
    }
    public void setHeight(double height) {
               this.height=height;
    }
    public void setWidth(double width){
      this.width=width;
    }

    //utility function used by default method in interface to retrieve like instances from mixed arraylist

    public static <T> ArrayList<T> getInstances(Class<?> cls){
        ArrayList<T> tmp = new ArrayList<>();
        for(GameObject gameObject : level.gameObjects){
            if (cls.isAssignableFrom(gameObject.getClass()) ){
                tmp.add((T) gameObject);
            }
        }
        return tmp;
    }
}
