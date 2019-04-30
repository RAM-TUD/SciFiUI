package ie.tudublin;

import processing.core.PApplet;

public class Button extends UIElements implements Reloader
{
   
    private float size;
    private boolean used = false;
    

    public Button(PApplet ui, float x, float y, float size)
    {
        super(x,y,ui);
        this.size = size;
    }

    public void render()
    { 
        ui.stroke(200,0,0);
        if(used == false)
        {
            ui.fill(255,0,0,100);
        }
        else{
            ui.fill(0,255,0);
        }
        ui.rect(x,y,size,size);
    }
    public void reload(Weapon w)
    {
        w.setAmmo(w.getAmmo()+1);
        used = true;
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the used
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * @param used the used to set
     */
    public void setUsed(boolean used) {
        this.used = used;
    }
   

}