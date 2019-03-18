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
        int gap = 30;
        float numbars = (float)gap/distance;
        ui.stroke(255);
        ui.line(x,y,x+distance,y);
        /*for(int i = 0; i<numbars; i++)
        {
            int barheight = (int)(Math.random() * 200 + 1);
            ui.rect(x,y,gap,barheight);
            x += gap;
        }*/
    }
    public void update()
    {
        int gap = 30;
        float numbars = (float)gap/distance;
         for(int i = 0; i<numbars; i++)
        {
            int barheight = (int)(Math.random() * 200 + 1);
            ui.rect(x,y,gap,barheight);
            x += gap;
        }
        
    }
}

