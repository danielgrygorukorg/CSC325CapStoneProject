package com.example.arcadeplatformer.aabb_collision;
import com.example.arcadeplatformer.Level;
import com.example.arcadeplatformer.Coordinatable;
import java.util.ArrayList;

public interface Collidable extends Coordinatable{
 //get the geometry of the collision boundrys
CollisionGeometry getGeometry();
//0 means infinite mass // immovable -1 means don't resolve collision // not solid
double getMass();
//arbitrary value to allow objects to choose how to handle collisions with certain objects
int getMask();
//called when involved in a resolved collision takes all objects involved
void collisionEvent(Collidable collision);

 default ArrayList<Collidable> getCollidables(){
  return Level.getInstances(Collidable.class);
 }

}
