package com.example.arcadeplatformer.rendering;

import com.example.arcadeplatformer.Coordinatable;
import com.example.arcadeplatformer.Level;
import com.example.arcadeplatformer.aabb_collision.Collidable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public interface Renderable extends Coordinatable {
    default Image loadImage(String path){
        try {
            Image sprite = new Image(path);

            return sprite;
        }
        catch (Exception e){
            System.out.print("Failed to load image "+ path);
            return null;
        }
    }

    default GraphicsContext getGc() {
        return Level.getLevel().getGc();
    }

    default ArrayList<Collidable> getRenderables(){
        return Level.getInstances(Collidable.class);
    }
    void draw();
}
