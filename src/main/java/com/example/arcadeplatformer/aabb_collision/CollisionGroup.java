package com.example.arcadeplatformer.aabb_collision;

import java.util.ArrayList;
import java.util.List;

public class CollisionGroup {
    private ArrayList<Collidable> all;

    private ArrayList<Collidable> unresolved;
    private int size;
CollisionGroup(){
    size=0;

    all = new ArrayList<Collidable>();
    unresolved = new ArrayList<Collidable>();
}

public int size(){
    return size;
}

    public int unresolvedSize(){
        return unresolvedSize();
    }


public void add(Collidable collidable){
        all.add(collidable);
        unresolved.add(collidable);
        size++;
}
public void resolve(){
    for(int i=0;i<unresolved.size();i++){
        if (unresolved.get(i).getMass()==0){
            unresolved.remove(i);
        }else {
            //check for interection with all other objects
            for (int j=0; j<all.size();j++){
                if(unresolved.get(i)!=all.get(j)){
                    while (Collision.intersects(unresolved.get(i),all.get(j))){
                                 Collision.moveApart(unresolved.get(i),all.get(j));
                                System.out.println("moving");
                    }
                }
            }
            unresolved.remove(i);
        }
    }
}

}
