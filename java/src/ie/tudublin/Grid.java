package ie.tudublin;

import processing.core.PApplet;

public class Grid
{
    private float x;
    private float y;
    private float distance;
    PApplet ui;

    public Grid(PApplet ui,float x, float y, float distance)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public void render()
    {
        int gap = 20;
        ui.stroke(255);
        int numlines = 10; 
        for(int i = 0; i < numlines; i++)
        {
            ui.line(x,y,x,y+distance);
            x += gap;
        }

    }
}