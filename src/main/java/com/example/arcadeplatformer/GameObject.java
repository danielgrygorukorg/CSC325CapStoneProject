package com.example.arcadeplatformer;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public abstract class GameObject {
    private Level level;
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
    private GraphicsContext gc;

   private Image sprite;
   // graphics rendering called from animation timer
    void draw(){
        //only draw if on tab
        if(gc!=null){
        if (sprite!=null){
           // checkRotate();
            gc.drawImage(sprite, (int) (x-bBoxW/2),(int) (y-bBoxH/2));
        }
        gc.setStroke(Color.AQUA);
            boolean debug = false;
            if (debug){gc.strokeRect(x- (double) bBoxW /2, y- (double) bBoxH /2, bBoxW, bBoxH);}}}

    // backend logic that gets called each frame
    abstract void toDo() ;

    public void setGraphicsContext(GraphicsContext graphicsContext){
        gc= graphicsContext;
    }
   public void setX(float x){
       this.x=x;
   }
   public void setY(float y){
        this.y=y;
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

    public boolean loadSprite(String path){
       try {
           sprite = new Image(path);
           setbBoxW((int)sprite.getWidth());
           setbBoxH((int)sprite.getHeight());
           return true;
       }
       catch (Exception e){
           System.out.print("Failed to load image "+ path);
           return false;
       }
    }
    public float getX(){
       return x;
    }
    public float getY(){
       return y;
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

    public GraphicsContext getGc() {
        return gc;
    }
    public Level getLevel(){
        return level;
    }
    public void setLevel(Level level){
        this.level = level;
    }
    public int getRotation(){
        return curentRotation;
    }
    public void setRotation(int rotation){
        this.newRotation= rotation;
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
    abstract void reset();
    //sets new roatation rleative to the original not curent rotation
    private void checkRotate(){
        //check for change
        if(curentRotation!=newRotation){
            // not working
            ImageView iv = new ImageView(sprite);
            int tmpR=(-curentRotation+newRotation);
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            params.setTransform(new Rotate(tmpR, sprite.getWidth() / 2, sprite.getHeight() / 2));
            params.setViewport(new Rectangle2D(0, 0, sprite.getWidth(), sprite.getHeight()));
            //updates the rotation so it dousnt eep rotating every frame actually made it crash
            curentRotation = newRotation;
            Image tmpImg=iv.snapshot(params,null);
            sprite=tmpImg;


        }
    }
}
