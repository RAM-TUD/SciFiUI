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
    int i =0;
    int a =0;
    int x;
    public void displayInfo(String info, String info2, String info3, boolean match)
    {
        boolean nextline = false;
        float distance = 150;
        float x = ui.width/2 - 50;
        float y = 200;
        ui.stroke(255);
        if(i < distance)
        {
            ui.line(x,200,x - i,y);
            i++;
        }       
        if(i == distance)
        {
            nextline = true;
        }
        if(nextline == true)
        {
            if(a != 30)
            {
                ui.line(x - distance, y, x- distance, y + a);
                a++;
            }
        } 
        
        ui.line(x - distance, y + 30, x - (distance)*2, y + 30);
        ui.textSize(15);
        ui.text(info,x - distance, y - 50);
        ui.text(info2,x-distance,y+50);
        ui.text(info3,x-distance,y+70);
        if(match == false)
        {
            ui.text("MATCH NOT FOUND", x - distance, y - 35);
        }
        else
        {
            ui.text("MATCH FOUND", x - distance, y - 35);
        }

    }

}