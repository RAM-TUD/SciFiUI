package ie.tudublin;

import processing.core.PApplet;

public class ShieldGenerator extends DefenseSystem
{
    private float buttonheight;
    private boolean activated = false;
    public float fuel;
    
    public ShieldGenerator(float x, float y, float size, float length, boolean enabled, PApplet ui)
    {
        super(x,y,size,length,enabled,ui);
        this.buttonheight = y +length-20;
        this.activated = false;
        this.fuel = length - 40;
    }
    public void render()
    {
        ui.fill(255,0,0,100);
        ui.rect(x,y,size,length);
        int gap = 20;
        for(int i = 0; i < 6; i++)
        {
            if(buttonheight <= y + gap+ (i*(gap+size/8)))
            {
                ui.fill(0,200,0);
            }
            else
            {
                ui.fill(150,0,40);
            }
            ui.rect(x+length/12,y + gap+ (i*(gap+size/8)),length/6,size/8);
        }
        ui.stroke(0);
        ui.line(x+size/2,y+20,x+size/2, y + length - 20);
        ui.fill(255);
        ui.rect(x+size/2-20,buttonheight,40,20);
        ui.fill(0,255,0);
        ui.rect(x+3*(size)/4,y+20,gap,fuel);
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

    /**
     * @return the activated
     */
    public boolean isActivated() {
        return activated;
    }

    /**
     * @param activated the activated to set
     */
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    
}