package com.example.arcadeplatformer;

public abstract class CoordinateObject implements Coordinatable{
    private Level level;
    //flag
    private boolean delete = false;
    private double resetX=0;
   private double resetY=0;
   private double x=0;
   private int newRotation =0;
   private int curentRotation=0;
   private double y=0;
   private double hsp=0;
   private double vsp=0;
   private int bBoxW=0;
    private int bBoxH=0;


   // graphics rendering called from animation timer


    // backend logic that gets called each frame
    abstract void initialize();

    @Override
   public void setX(double x){
       this.x=x;
   }
   @Override
   public void setY(double y){
        this.y=y;
    }
    @Override
    public double getX(){
        return x;
    }
    @Override
    public double getY(){
        return y;
    }
    public void setHsp(double hsp){
       this.hsp=hsp;
    }
    public void setVsp(double vsp){
       this.vsp=vsp;
    }
    public void setbBoxW(int bBoxW){
        this.bBoxW=bBoxW;
    }
    public void setbBoxH(int bBoxH){
        this.bBoxH=bBoxH;
    }

    public double getHsp(){
       return hsp;
    }
    public double getVsp(){
       return vsp;
    }
    public int getbBoxW(){
       return bBoxW;
    }
    public int getbBoxH(){
       return bBoxH;
    }

    public void setResetX(double x){
        resetX=x;
    }
    public void setResetY(double y){
        resetY=y;
    }
    public double getResetX(){
        return resetX;
    }
    public double getResetY(){
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
