package com.example.arcadeplatformer;

import com.example.arcadeplatformer.aabb_collision.Collidable;


import java.util.ArrayList;

public class SolidObject extends GameObject implements Collidable {

    SolidObject(){

    }
    @Override
    boolean toDo() {
        getCollidables();
        return isMarkedForDeletion();
    }

    @Override
    void initialize() {

    }

    @Override
    public void onDelete() {

    }

    @Override
    protected void reset()  {
        setX(getResetX());
        setY(getResetY());
        setHsp(0);
        setVsp(0);
        Controller.resetInputs();

    }


    @Override
    public ArrayList<GameObject> getCollidables() {
        ArrayList<GameObject> tmp= new ArrayList<GameObject>();
        tmp = getLevel().getInstances(Collidable.class);
        return tmp;
    }
}
