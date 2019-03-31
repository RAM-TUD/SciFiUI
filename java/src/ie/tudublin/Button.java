package ie.tudublin;

import processing.core.PApplet;

public class Button extends UIElements
{
   
    private float size;
    

    public Button(PApplet ui, float x, float y, float size)
    {
        super(x,y,ui);
        this.size = size;
    }

    public void render()
    { 
        ui.stroke(200,0,0);
        ui.fill(255);
        ui.rect(x,y,size,size);
        
      
    }
   

}