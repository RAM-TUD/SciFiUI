package ie.tudublin;

import processing.core.PApplet;

public class Display extends UIElements
{
    private float size;
    
    public Display(float x, float y, PApplet ui, float size)
    {
        super(x,y,ui);
        this.size = size;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.rect(x,y,size,size);
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}