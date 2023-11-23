package com.example.arcadeplatformer.masking;

public class Mask {
    //2D array of  X Y MaskPoint
    private int x_size;
    private int y_size;
    private MaskPoint[][] points;
   public Mask(int x_size,int y_size){
        //propogate point matrix with defaualt point vals
        this.x_size=x_size;
        this.y_size=y_size;
        points= new MaskPoint[x_size][y_size];
        for (int i=0;i<x_size;i++){
            for (int j=0;j<y_size;j++){
                points[i][j]=new MaskPoint();
            }
        }
    }
    MaskPoint getPoint(int x,int y){
        return points[x][y];
    }
   public void setPoint(int x,int y,MaskPoint maskPoint){
        points[x][y]=maskPoint;
    }
   public void fill(int chanel){
        //set chanel index of maskval to true for all mask points in this matrix
        for (int i=0;i<x_size;i++){
            for (int j=0;j<y_size;j++){
                points[i][j].maskVals[chanel]=true;
            }
        }
    }
    //take mask values and merge with own
   public void reflect(Mask mask,int x_offset, int y_offset){
        for (int i=0;i<mask.x_size;i++){
            for (int j=0;j<mask.y_size;j++){
                int x_tmp=i+x_offset;
                int y_tmp=j+y_offset;
                if (x_tmp<x_size&&y_tmp<y_size&&x_tmp>=0&&y_tmp>=0){
                    points[x_tmp][y_tmp].orVals(mask.points[i][j]);
                }
            }
        }
    }
   public void clear(){
        //set maskval to false for all mask points in this matrix
        for (int i=0;i<x_size;i++){
            for (int j=0;j<y_size;j++){
                points[i][j].clear();
            }
        }
    }
}
