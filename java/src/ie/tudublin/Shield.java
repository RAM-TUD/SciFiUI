package ie.tudublin;

import processing.core.PApplet;

public class Shield extends DefenseSystem
{
    private float buttonheight;
    
    public Shield(float x, float y, float size, float length, boolean enabled, PApplet ui)
    {
        super(x,y,size,length,enabled,ui);
        this.buttonheight = y;
    }
    public void render()
    {
        ui.fill(255,0,0,100);
        ui.rect(x,y,size,length);
        int gap = 20;
        for(int i = 0; i < 6; i++)
        {
            ui.fill(150,0,40);
            ui.rect(x+length/12,y + gap+ (i*(gap+size/8)),length/6,size/8);
        }
        ui.stroke(0);
        ui.line(x+size/2,y+20,x+size/2, y + length - 20);
        ui.fill(255);
        ui.rect(x+size/2-20,buttonheight+length-20,40,20);
        ui.fill(0,255,0);
        ui.rect(x+3*(size)/4,y+20,gap,length - 40);
    }

    /**
     * @return the buttonheight
     */
    public float getButtonheight() {
        return buttonheight;
    }

    /**
     * @param buttonheight the buttonheight to set
     */
    public void setButtonheight(float buttonheight) {
        this.buttonheight = buttonheight;
    }
}