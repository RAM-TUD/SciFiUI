package ie.tudublin;

import processing.core.PApplet;

public class Bullet extends UIElements
{
    private float length;
    public Bullet(float x,float y,float length, PApplet ui)
    {
        super(x,y,ui);
        this.length = length;
    }
    public void render()
    {
        ui.fill(200,200,0);
       ui.triangle(x, y, x+length/2, y+length, x+length, y+length);
       ui.triangle(x+length*2,y+length*2,x+length/2,y+length,x+length,y+length);
       ui.triangle(x+length, y, x+length/2, y+length, x+length, y+length);
       ui.triangle(x-length,y+length*2,x+length/2,y+length,x+length,y+length);
    }
}