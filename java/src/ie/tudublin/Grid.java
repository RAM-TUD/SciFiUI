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
        float coordx = x;
        float coordy = y;
        int gap = 25;
        ui.stroke(255);
        int numlines = 10; 
        for(int i = 0; i < numlines; i++)
        {
            ui.line(coordx,coordy,coordx,coordy+distance);
            coordx += gap;
        }
        coordx = x;
        for(int i = 0; i < numlines; i++)
        {
            ui.line(coordx,coordy,coordx+distance,coordy);
            coordy += gap;
        }

    }
}