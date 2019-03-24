package ie.tudublin;

import processing.core.PApplet;

public class Numbers extends UIElements
{
    public Numbers(float x, float y, PApplet ui)
    {
        super(x,y,ui);
    }
    public void render()
    {
        int num = (int)(Math.random()*Integer.MAX_VALUE +1);
        float length = (int)(Math.random()*ui.height + 0);
        ui.textSize(25);
        ui.text(num,x ,y);
        ui.stroke(255,50);
        ui.line(0,length,ui.width,length);
    }
}