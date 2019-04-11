package ie.tudublin;

import processing.core.PApplet;

public abstract class DefenseSystem
{
    protected float x;
    protected float y;
    protected float size;
    protected float length;
    protected boolean enabled;
    protected PApplet ui;

    public DefenseSystem(float x, float y, float size, float length, boolean enabled, PApplet ui)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.length = length;
        this.enabled = enabled;
        this.ui = ui;
    }
    public abstract void render();
	

}