package ie.tudublin;

import processing.core.PApplet;

public class Button
{
    private float x;
    private float y;
    private float size;
    PApplet ui;

    public Button(PApplet ui, float x, float y, float size)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void render()
    {
        
        ui.stroke(200,0,0);
        ui.fill(255);
        ui.rect(x,y,size,size);
    }

}