package com.example.arcadeplatformer;

import com.example.arcadeplatformer.aabb_collision.Collidable;
import com.example.arcadeplatformer.aabb_collision.CollisionGeometry;

import java.util.ArrayList;

public class GroundBlock extends SolidObject{

    GroundBlock(int width,int height){
        super();
       setbBoxW(width);
       setbBoxH(height);
    }
    @Override
    public CollisionGeometry getGeometry() {
        return new CollisionGeometry(getbBoxW(),getbBoxH());
    }

    @Override
    public double getMass() {
        return 0;
    }

    @Override
    public int getMask() {
        return 0;
    }

    @Override
    public void collisionEvent(Collidable collision) {

    }

    @Override
    public boolean debug() {
        return true;
    }
}
