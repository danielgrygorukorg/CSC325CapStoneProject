package com.example.arcadeplatformer.masking;

import java.util.Arrays;

public class MaskPoint {
    //simple model for boolean data stored in each point of a Collision mask
    //max mask values / colission types determined by array size
    boolean[] maskVals= new boolean[64];;
    MaskPoint(){
        //initialize
        Arrays.fill(maskVals, false);
    }
    public void clear(){
        Arrays.fill(maskVals,false);
    }
    public void orVals(MaskPoint m){
        for (int i=0;i<maskVals.length;i++){
            // OR all mask values with another maskPoint
            maskVals[i]=(m.maskVals[i]||maskVals[i]);
        }
    }
    public void clearVals(){
        Arrays.fill(maskVals, false);
    }

}
