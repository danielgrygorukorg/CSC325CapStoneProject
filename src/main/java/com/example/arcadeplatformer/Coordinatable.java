package com.example.arcadeplatformer;

public interface Coordinatable extends GameObject{
    public void setX(double x);
    public void setY(double y);
    double getX();
    double getY();
    double getHsp();
    double getVsp();

    void setVsp(double vsp);
    void setHsp(double hsp);
}
