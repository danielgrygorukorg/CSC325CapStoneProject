package com.example.arcadeplatformer;

import java.util.ArrayList;

public class Level implements Maskable {
    private Mask world_projection;
    private int width;
    private int height;
    protected ArrayList<GameObject> gameObjects;
    Level(int width,int height){
        gameObjects= new ArrayList<GameObject>();
        world_projection = new Mask(width,height);
        this.width=width;
        this.height=height;
    }

    @Override
    public void projectMask(Mask mask) {

    }

    @Override
    public void setMask(Mask mask) {

    }

    @Override
    public Mask getMask() {
       return world_projection;
    }

    @Override
    public void propogate(int mask_chanel) {

    }

    @Override
    public void clearMask() {
        getMask().clear();
    }

    public int getHeight() {
        return height;
    }
    public int getWidth(){
        return width;
    }
}
