package ie.tudublin;

import processing.core.PApplet;

public class Weapon extends UIElements
{
    private float size;
    private float length;
    public Weapon(float x, float y, PApplet ui, float size, float length)
    {
        super(x,y,ui);
        this.size = size;
        this.length = length;
    }

    public void render()
    {
        ui.stroke(255);
        ui.fill(255,0,0,100);
        ui.rect(x,y,size,length+50);
        ui.rect(x,y+size/2,size,length+30);
        ui.fill(255);
        ui.textSize(12);
        ui.text("WEAPON SYSTEM",x+size/2,y+size/3/2);
        ui.text("ENABLE", x + size/2, y + length + 60 );


    }

}