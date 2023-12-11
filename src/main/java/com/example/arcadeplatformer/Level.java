package com.example.arcadeplatformer;

import com.example.arcadeplatformer.aabb_collision.Collidable;
import com.example.arcadeplatformer.masking.Mask;
import com.example.arcadeplatformer.masking.Maskable;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int width;
    private int height;
    protected ArrayList<GameObject> gameObjects;

    public Level(int width, int height) {
        this.width= width;
        this.height=height;
        gameObjects = new ArrayList<GameObject>();
    }


    public int getHeight() {
        return height;
    }
    public int getWidth(){
        return width;
    }


    public<T > ArrayList<T> getInstances(Class<?> cls){
        ArrayList<T> tmp = new ArrayList<>();
        for(GameObject gameObject:gameObjects){
            if (cls.isAssignableFrom(gameObject.getClass()) ){
                tmp.add((T) gameObject);
            }
        }
        return tmp;
    }
}
