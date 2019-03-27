package ie.tudublin;

import processing.core.PApplet;


public abstract class UIElements
{
    float x;
    float y;
    PApplet ui;

    public UIElements(float x, float y, PApplet ui)
    {
        this.x = x;
        this.y = y;
        this.ui = ui;
    }
    public abstract  void render();
	
}