package com.example.arcadeplatformer.aabb_collision;

import java.util.ArrayList;

public class CollisionGeometry {
    protected double bBoxW;
    protected double bBoxH;
    //if null bBox dimensions will be used for collision
    protected ArrayList<Shape> shapes;

    public CollisionGeometry (double bBoxW, double bBoxH){
        this.bBoxW= bBoxW;
        this.bBoxH=bBoxH;
        shapes=null;
    }
    public CollisionGeometry (double bBoxW, double bBoxH,ArrayList<Shape> shapes){
        this.bBoxW= bBoxW;
        this.bBoxH=bBoxH;
        this.shapes=shapes;
    }
    public void addShape(Shape shape){
        shapes.add(shape);
    }



}
