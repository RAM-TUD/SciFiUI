package ie.tudublin;

import processing.core.PApplet;

public class Barchart 
{
    private float x;
    private float y;
    private float distance;
    PApplet ui;

    public Barchart(PApplet ui,float x, float y, float distance)
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
        int gap = 30;
        float numbars = 12;
        ui.stroke(255,100);
        for(int i = 0; i<numbars; i++)
        {
            ui.fill(255,100);
            int barheight = (int)(Math.random() * 200 + 1);
            ui.rect(coordx,coordy - barheight,gap,barheight);
            coordx += gap;
        }
    }
    
}

