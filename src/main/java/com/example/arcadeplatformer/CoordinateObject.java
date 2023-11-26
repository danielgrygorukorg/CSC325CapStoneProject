package com.example.arcadeplatformer;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public abstract class CoordinateObject implements Coordinatable{
    private Level level;
    //flag
    private boolean delete = false;
    private float resetX=0;
   private float resetY=0;
   private float x=0;
   private int newRotation =0;
   private int curentRotation=0;
   private float y=0;
   private float hsp=0;
   private float vsp=0;
   private int bBoxW=0;
    private int bBoxH=0;


   // graphics rendering called from animation timer


    // backend logic that gets called each frame
    abstract void initialize();

    @Override
   public void setX(float x){
       this.x=x;
   }
   @Override
   public void setY(float y){
        this.y=y;
    }
    @Override
    public float getX(){
        return x;
    }
    @Override
    public float getY(){
        return y;
    }
    public void setHsp(float hsp){
       this.hsp=hsp;
    }
    public void setVsp(float vsp){
       this.vsp=vsp;
    }
    public void setbBoxW(int bBoxW){
        this.bBoxW=bBoxW;
    }
    public void setbBoxH(int bBoxH){
        this.bBoxH=bBoxH;
    }

    public float getHsp(){
       return hsp;
    }
    public float getVsp(){
       return vsp;
    }
    public int getbBoxW(){
       return bBoxW;
    }
    public int getbBoxH(){
       return bBoxH;
    }

    public void setResetX(float x){
        resetX=x;
    }
    public void setResetY(float y){
        resetY=y;
    }
    public float getResetX(){
        return resetX;
    }
    public float getResetY(){
       return resetY;
    }
    @Override

    public void markForDelettion(){
        this.delete=true;
    }
    @Override
    public boolean isMarkedForDeletion(){
        return delete;
    }
    public abstract void onDelete();

    //sets new roatation rleative to the original not curent rotation

}
