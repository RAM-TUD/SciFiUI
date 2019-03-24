package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;

public class Targeting
{
    private float diameter;
    private float radius;
    PApplet ui;
    PImage pedestrian;

    public Targeting(PApplet ui,float diameter)
    {
        this.ui = ui;
        this.diameter = diameter;
        radius = diameter/2;
        
    }

    public void targeticon()
    {
        ui.stroke(200,150,0);
        ui.line(ui.mouseX, ui.mouseY + radius + 10, ui.mouseX, ui.mouseY - radius - 10);
        ui.line(ui.mouseX - radius - 10, ui.mouseY, ui.mouseX + radius + 10, ui.mouseY);
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(ui.mouseX, ui.mouseY, diameter,diameter);
    }

    public PImage loadtarget(String name)
    {
        pedestrian = ui.loadImage(name);
        return pedestrian;
    }

    public void targets(PImage name,float x, float y, float size, float length)
    {
        
        ui.image(name,x,y,size,length);
    }

}