package ie.tudublin;

import processing.core.PApplet;

public class PoliceLights extends UIElements
{
    private float distance;
    public PoliceLights(float x, float y, float distance,PApplet ui)
    {
        super(x,y,ui);
        this.distance = distance;
    }
    public void render()
    {
        float coordx = x-50;
        float coordy = y-100;
        ui.strokeWeight(7);
        for(int i = 0; i < 200; i++)
        {
            ui.stroke(255,0,0);
            ui.line(x,y,coordx - ui.random(distance/2,distance), coordy);
            ui.stroke(0,0,255);
            ui.line(x+10,y,coordx+ui.random(distance/2 + 75,distance + 75),coordy);
            coordy ++;
        }

    }
}