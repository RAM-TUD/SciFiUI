package ie.tudublin;

import processing.core.PApplet;

public class Weapon extends DefenseSystem
{
    
    private float rotation;
    private float ammo;
    
    public Weapon(float x, float y, float size, float length, boolean enabled, PApplet ui)
    {
        super(x,y,size,length,enabled,ui);
        this.rotation = 0;
        this.ammo = 1;
    }

    public void render()
    {
        ui.stroke(255);
        ui.fill(255,0,0,100);
        ui.rect(x,y,size,length+50);
        ui.rect(x,y+size/2,size,length+30);
        ui.fill(255);
        ui.textSize(12);
        ui.text("ENABLE",x+size/2,y+size/3/2);
        ui.text("AMMO : " + ammo,x+size/2,y+size/3/2 - 15);
        ui.text("WEAPON SYSTEMS", x + size/2, y + length + 60);

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
     * @return the length
     */
    public float getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(float length) {
        this.length = length;
    }

    /**
     * @return the rotation
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * @param rotation the rotation to set
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the ammo
     */
    public float getAmmo() {
        return ammo;
    }

    /**
     * @param ammo the ammo to set
     */
    public void setAmmo(float ammo) {
        this.ammo = ammo;
    }

}