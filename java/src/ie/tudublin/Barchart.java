package ie.tudublin;

import processing.core.PApplet;

public class Barchart extends UIElements
{
    
    

    public Barchart(PApplet ui,float x, float y)
    {
        super(x,y,ui);
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

