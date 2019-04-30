package ie.tudublin;

import processing.core.PApplet;


public class Shield
{
   
    private float distance;
    private PApplet ui;
    public float x, y;
   
    

    public Shield (float x, float y, float distance, PApplet ui)
    {
        //this.coord.x = x;
        //this.coord.y = y;
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.ui = ui;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(0,255,0);
        ui.beginShape();
        ui.vertex(x, y);
        ui.vertex(x + distance, y);
        ui.vertex (x + 2*(distance), y + distance);
        ui.vertex(x + distance, y + 2*(distance));
        ui.vertex(x,y+2*(distance));
        ui.vertex(x - distance, y+distance);
        ui.vertex(x,y);
        ui.endShape();
       
    }
}