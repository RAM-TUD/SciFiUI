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

        ui.line(ui.mouseX - 50, ui.mouseY - 30, ui.mouseX - 25, ui.mouseY - 30);
        ui.line(ui.mouseX - 50, ui.mouseY - 30, ui.mouseX - 50, ui.mouseY - 15);

        ui.line(ui.mouseX + 50, ui.mouseY - 30, ui.mouseX + 25, ui.mouseY - 30);
        ui.line(ui.mouseX + 50, ui.mouseY - 30, ui.mouseX + 50, ui.mouseY - 15);

        ui.line(ui.mouseX + 50, ui.mouseY + 30, ui.mouseX + 25, ui.mouseY + 30);
        ui.line(ui.mouseX + 50, ui.mouseY + 30, ui.mouseX + 50, ui.mouseY + 15);

        ui.line(ui.mouseX - 50, ui.mouseY + 30, ui.mouseX - 25, ui.mouseY + 30);
        ui.line(ui.mouseX - 50, ui.mouseY + 30, ui.mouseX - 50, ui.mouseY + 15);
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

    public void displayArea()
    {
        ui.noFill();
        ui.rect(ui.width/2 - 50,150,200,200);
    }

    public void displayInfo(String info, float linex,float liney)
    {
        float distance = 50;
        ui.stroke(255);
        ui.line(linex,liney,linex + distance, liney);
        ui.textSize(10);
        ui.text(info,linex + distance + 30, liney);
    }

}