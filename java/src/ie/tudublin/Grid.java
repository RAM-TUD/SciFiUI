package ie.tudublin;


import processing.core.PApplet;
import processing.core.PImage;

public class Grid extends UIElements
{
    
    private float distance;
    PImage target;
    

    public Grid(PApplet ui,float x, float y, float distance)
    {
        super(x,y,ui);
        this.distance = distance;
    }
    public PImage loadtarget(String targetname)
    {
        target = ui.loadImage(targetname);
        return target;
    }

    public void render()
    {

        float coordx = x;
        float coordy = y;
        int gap = 25;
        ui.stroke(255);
        int numlines = 10;
        ui.image(loadtarget("target.jpg"),x,y,distance,distance);
        for(int i = 0; i < numlines + 1; i++)
        {
            ui.line(coordx,coordy,coordx,coordy+distance);
            coordx += gap;
        }
        coordx = x;
        for(int i = 0; i < numlines + 1; i++)
        {
            ui.line(coordx,coordy,coordx+distance,coordy);
            coordy += gap;
        }
        ui.fill(255);
        ui.textSize(30);
        ui.text("TARGET AQUIRED",x + (distance/2), y + distance + 50);
        
    }
}