package ie.tudublin;

import processing.core.PApplet;

public class CircleUI
{
    private float x;
    private float y;
    private float diameter;
    private float radius;
    PApplet ui;

    public CircleUI(PApplet ui,float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        radius = diameter/2;
    }

    public void render()
    {
        float outline = 100 + diameter;
        int numoutline = 25;
        for(int i =0; i<numoutline; i++)
        {
            ui.stroke(255);
            ui.noFill();
            ui.ellipse(x,y,outline,outline);
            outline--;
        }
        ui.fill(255);
        ui.ellipse(x,y,diameter,diameter);
    }
}