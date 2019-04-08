package ie.tudublin;

import processing.core.PApplet;

public class Weapon extends UIElements
{
    private float size;
    private float length;
    private float rotation;
    public Weapon(float x, float y, PApplet ui, float size, float length)
    {
        super(x,y,ui);
        this.size = size;
        this.length = length;
        this.rotation = 0;
    }

    public void render()
    {
        ui.stroke(255);
        ui.fill(255,0,0,100);
        ui.rect(x,y,size,length+50);
        ui.rect(x,y+size/2,size,length+30);
        ui.fill(255);
        ui.textSize(12);
        ui.text("WEAPON SYSTEM",x+size/2,y+size/3/2);
        ui.text("ENABLE", x + size/2, y + length + 60);

        ui.fill(255,50);
        float trix = x + size/2;
        float triy = y + size - 50;
        ui.triangle(trix,triy,trix - 15, triy + 15, trix+15, triy + 15);
        ui.rect(trix-15,triy+20,30,length/2);
        ui.triangle(trix-30,triy-15 + length/2,trix-20,triy-15 + length/2, trix - 20, triy - 30 + length/2);
        ui.triangle(trix+30,triy+15 + length/2,trix+20,triy+15 + length/2, trix + 20, triy + 30 + length/2);

        int gap = 20;
        for(int i = 0; i < 5; i++)
        {
            ui.line(x+5, y + size/2 + (i*gap),trix - 20, y + size/2 + (i*gap));
            ui.line(x+ size - 5, y + size/2 + (i*gap),trix + 20, y + size/2 + (i*gap));
        }
        ui.pushMatrix();
        ui.translate(trix - 45, triy + 15+length/2);
        ui.rotate(rotation);
        ui.noFill();
        ui.stroke(255);
        ui.arc(0,0,25,25,0,ui.PI);
        ui.popMatrix();
        rotation += 0.05f;


    }

}