package com.example.arcadeplatformer.masking;

import com.example.arcadeplatformer.masking.Mask;

public interface Maskable {
   public void projectMask(Mask mask);
   public void setMask(Mask mask);
   public Mask getMask();
   public void propogate(int mask_chanel);
   public void clearMask();

}
