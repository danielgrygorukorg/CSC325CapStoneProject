package com.example.arcadeplatformer;

import javafx.scene.image.PixelReader;

public class Collision {
    private static int color= -16755815;
    private static int color2=-16760833;
    static boolean pixelCollision(GameObject gameObject, PixelReader pixelReader,int xOff, int yOff){
            int w = gameObject.getbBoxW();
            int h = gameObject.getbBoxH();
            for (int i=0;i< h;i++){
                for (int j=0;j<w;j++){
                    //temp store cordinates to check
                    int xTmp= (int) (gameObject.getX()-w/2)+j+xOff;
                    int yTmp = (int) (gameObject.getY()-h/2)+i+yOff;
                    int tmpCol=0;
                    try {
                   tmpCol=pixelReader.getArgb(xTmp,yTmp);
                    }
                    catch (Exception e) {
                        // do nothing if pixel cordinates invalid
                    }
                    if (tmpCol==color||tmpCol==color2){
                        return true;
                    }
                }

            }
            return false;
    }

    //collision helper method
    //check if bounds of object intersect with a specific point
    static boolean pointCollision(float x,float y,GameObject o){
        boolean c =false;
        float x1=o.getX();
        float w1 =o.getbBoxW();
        float h1 = o.getbBoxH();
        float y1=o.getY();
        if ((x>=x1-w1/2)&&(x<=x1+w1/2)&&(y>=y1-h1/2)&&(y<=y1+h1/2)){c=true;}
        return c;
    }
}
