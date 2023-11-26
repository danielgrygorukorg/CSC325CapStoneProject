package com.example.arcadeplatformer.aabb_collision;
import com.example.arcadeplatformer.Level;
import com.example.arcadeplatformer.Coordinatable;
import java.util.ArrayList;

public interface Collidable extends Coordinatable{

 default ArrayList<Collidable> getCollidables(){
  return Level.getInstances(Collidable.class);
 }

}
