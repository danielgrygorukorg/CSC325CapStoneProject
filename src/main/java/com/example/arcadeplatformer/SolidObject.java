package com.example.arcadeplatformer;

import com.example.arcadeplatformer.aabb_collision.Collidable;
import com.example.arcadeplatformer.rendering.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class SolidObject extends CoordinateObject implements Collidable, Renderable {
 Image sprite;
    SolidObject(){

    }
    @Override
    public boolean toDo() {
       return isMarkedForDeletion();
    }

    @Override
    void initialize() {

    }

    @Override
    public void onDelete() {

    }

    @Override
    public void reset()  {
        setX(getResetX());
        setY(getResetY());
        setHsp(0);
        setVsp(0);
        Controller.resetInputs();

    }
    @Override
    public void draw(){
        GraphicsContext gc = getGc();
        //only draw if on tab
        if(gc!=null){
            if (sprite!=null){
                // checkRotate();
                gc.drawImage(sprite, (int) (getX()-sprite.getWidth()/2),(int) (getY()-sprite.getHeight()/2));
            }
            gc.setStroke(Color.AQUA);
            boolean debug = false;
            if (debug){gc.strokeRect(getX()- (double) sprite.getWidth() /2, getY()- (double) sprite.getHeight() /2, sprite.getWidth(), sprite.getHeight());}}}


    public void loadSprite(String image) {
        sprite= loadImage(image);
    }
}
