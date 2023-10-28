package com.example.arcadeplatformer;

public class SolidObject extends GameObject implements Maskable{
    private Mask mask;
    SolidObject(){

    }
    @Override
    void toDo() {
        projectMask(getLevel().getMask());
    }

    @Override
    protected void reset()  {
        setX(getResetX());
        setY(getResetY());
        setHsp(0);
        setVsp(0);
        Controller.resetInputs();

    }

    @Override
    public void projectMask(Mask mask) {
        mask.reflect(mask, (int) getX()-getbBoxW()/2, (int) getY()-getbBoxH()/2);
    }

    @Override
    public void setMask(Mask mask) {
        this.mask=mask;
    }

    @Override
    public Mask getMask() {
        return this.mask;
    }

    @Override
    public void propogate(int mask_chanel) {
        mask.fill(mask_chanel);
    }

    @Override
    public void clearMask() {
        getMask().clear();
    }


}
