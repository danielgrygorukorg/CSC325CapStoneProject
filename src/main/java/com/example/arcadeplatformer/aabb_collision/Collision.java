package com.example.arcadeplatformer.aabb_collision;

import com.example.arcadeplatformer.CoordinateObject;
import javafx.scene.image.PixelReader;

import java.util.ArrayList;
import java.util.Arrays;

public class Collision {
    private static int color= -16755815;
    private static int color2=-16760833;
    private static void resolveCollisions(CollisionGroup collisionGroup){
           collisionGroup.resolve();

    }
   protected static boolean intersects(Collidable obj1, Collidable obj2){
        //default to basic box collision for now
        return (collisionPossible(obj1,obj2)||collisionPossible(obj2,obj1));
   }
    protected static void moveApart(Collidable obj1, Collidable obj2){
        //move objects found to be intersecting apart with respect to direction of impact and mass
          double hsp=obj1.getHsp();
          double vsp=obj1.getVsp();
        boolean ll = pointCollision((obj1.getX()-obj1.getGeometry().bBoxW/2)-1,obj1.getY()+(obj1.getGeometry().bBoxH/2)+1,obj2);
        boolean lr = pointCollision((obj1.getX()+obj1.getGeometry().bBoxW/2)+1,obj1.getY()+(obj1.getGeometry().bBoxH/2)+1,obj2);
        boolean tl = pointCollision((obj1.getX()-obj1.getGeometry().bBoxW/2)-1,obj1.getY()-(obj1.getGeometry().bBoxH/2)-1,obj2);
        boolean tr = pointCollision((obj1.getX()+obj1.getGeometry().bBoxW/2)+1,obj1.getY()-(obj1.getGeometry().bBoxH/2)-1,obj2);
        boolean above =(obj1.getY()<obj2.getY());
        boolean right =(obj1.getX()>obj2.getX());
        if(ll&&lr&&above){
            //bottom col
            obj1.setY(obj1.getY()-1);
            obj1.setVsp(0);
        }else

        if(tl&&tr&&!above){
            //bottom col
            obj1.setY(obj1.getY()+1);
        }else
        if (ll&&right&&above){
            obj1.setY(obj1.getY()-vsp/Math.abs(vsp));
            obj1.setX(obj1.getX()+vsp/Math.abs(hsp));
        }else
        if (ll&&right&&!above){
            obj1.setY(obj1.getY()-vsp/Math.abs(vsp));
            obj1.setX(obj1.getX()-hsp/Math.abs(hsp));
        }


    }

    public static void handleCollisions(ArrayList<Collidable> collidables){
        //copy ref to array
        Collidable[] tmpC = new Collidable[collidables.size()];
            for (int i=0; i<collidables.size();i++){
                tmpC[i]= collidables.get(i);
            }
            //find groups of possible collisions
            CollisionGroup[] collisionGroups= findCollisionGroups(tmpC);
        Arrays.stream(collisionGroups).forEach(Collision::resolveCollisions);

    }
     protected static CollisionGroup[] findCollisionGroups(Collidable[] collidables){
        boolean sorted=false;
        int c =0;
        ArrayList<CollisionGroup> collisionGroups = new ArrayList<CollisionGroup>();
        //loop until all elements removed from array
        while (!sorted){
            sorted = true;
            //start from next non null
            if (collidables[c]!=null){
                CollisionGroup cTmp = new CollisionGroup();
            //scan forward for collisions with non null
            for (int i=c+1; i< collidables.length;i++){
                // check if any of the 4 corners exsist within the bounds of the other
                    if (collisionPossible(collidables[c],collidables[i])||collisionPossible(collidables[i],collidables[c])){
                        //add to current collision group
                        cTmp.add(collidables[i]);
                        //remove from array
                        collidables[i]=null;
                        sorted = false;
                    }
            }
            //only add to list of groups if collisions occur
            if (cTmp.size()>0){
                cTmp.add(collidables[c]);
                collisionGroups.add(cTmp);

            }
            //remove last start point from array
                collidables[c]=null;
        }
        c++;
        }

      //convert to array
         CollisionGroup[] tmpCG = new CollisionGroup[collisionGroups.size()];
         for (int i=0; i<collisionGroups.size();i++){
             tmpCG[i]= collisionGroups.get(i);

         }
            return tmpCG;
     }

     protected static boolean collisionPossible(Collidable obj1, Collidable obj2){
        boolean col=false;
        if (obj2 !=null&& obj1!=null){
            double obj1_x1= (obj1.getX()-(obj1.getGeometry().bBoxW/2));
            double obj1_x2= (obj1.getX()+(obj1.getGeometry().bBoxW/2));
            double obj1_y1= (obj1.getY()-(obj1.getGeometry().bBoxH/2));
            double obj1_y2= (obj1.getY()+(obj1.getGeometry().bBoxH/2));
            double obj2_x1= (obj2.getX()-(obj2.getGeometry().bBoxW/2));
            double obj2_x2= (obj2.getX()+(obj2.getGeometry().bBoxW/2));
            double obj2_y1= (obj2.getY()-(obj2.getGeometry().bBoxH/2));
            double obj2_y2= (obj2.getY()+(obj2.getGeometry().bBoxH/2));
            boolean x1_between=(obj1_x1>=obj2_x1&&obj1_x1<=obj2_x2);
            boolean x2_between=(obj1_x2>=obj2_x1&&obj1_x2<=obj2_x2);
            boolean y1_between=(obj1_y1>=obj2_y1&&obj1_y1<=obj2_y2);
            boolean y2_between=(obj1_y2>=obj2_y1&&obj1_y2<=obj2_y2);
            if ((x1_between||x2_between)&&(y1_between||y2_between)){
                col=true;

            }
        }
        return col;
     }




   public static boolean pixelCollision(CoordinateObject coordinateObject, PixelReader pixelReader, int xOff, int yOff){
            int w = coordinateObject.getbBoxW();
            int h = coordinateObject.getbBoxH();
            for (int i=0;i< h;i++){
                for (int j=0;j<w;j++){
                    //temp store cordinates to check
                    int xTmp= (int) (coordinateObject.getX()-w/2)+j+xOff;
                    int yTmp = (int) (coordinateObject.getY()-h/2)+i+yOff;
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
  public   static boolean pointCollision(double x, double y, Collidable o){
        boolean c =false;
        double x1=o.getX();
        double w1 =o.getGeometry().bBoxW;
        double h1 = o.getGeometry().bBoxH;
        double y1=o.getY();
        if ((x>=x1-w1/2)&&(x<=x1+w1/2)&&(y>=y1-h1/2)&&(y<=y1+h1/2)){c=true;}
        return c;
    }
}
