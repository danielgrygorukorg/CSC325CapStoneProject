package com.example.arcadeplatformer;

public interface Maskable {
    void projectMask(Mask mask);
    void setMask(Mask mask);
    Mask getMask();
    void propogate(int mask_chanel);
    void clearMask();

}
