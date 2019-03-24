package ie.tudublin;

import processing.core.PApplet;

public class CircleUI extends UIElements
{
   
    private float diameter;
    float r;


    public CircleUI(PApplet ui,float x, float y, float diameter)
    {
        super(x,y,ui);
        this.diameter = diameter;
        
    }

    public void render()
    {
        
        float outline = 100 + diameter;
        int numoutline = 25;
        for(int i =0; i<numoutline; i++)
        {
            ui.pushMatrix();
            ui.translate(x,y);
            ui.rotate(ui.radians(r));
            ui.stroke(255,100);
            ui.noFill();
            ui.arc(0, 0, outline, outline, 0, ui.PI + (float)ui.PI/1.5f);
            outline--;
            r += 0.25f;
            ui.popMatrix();
        }
       
        ui.fill(255,100);
        ui.ellipse(x,y,diameter,diameter);
    }
}