package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Shield
{
    public PVector coord;
    private float distance;
    private PApplet ui;

    public Shield (float x, float y, float distance, PApplet ui)
    {
        this.coord.x = x;
        this.coord.y = y;
        this.distance = distance;
        this.ui = ui;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(0,255,0);
        ui.beginShape();
        ui.vertex(coord.x, coord.y);
        ui.vertex(coord.x + distance, coord.y);
        ui.vertex (coord.x + 2*(distance), coord.y + distance);
        ui.vertex(coord.x + distance, coord.y + 2*(distance));
        ui.vertex(coord.x,coord.y+2*(distance));
        ui.vertex(coord.x - distance, coord.y+distance);
        ui.vertex(coord.x,coord.y);
    }
}