package ie.tudublin;

import processing.core.PApplet;

public class SearchMode
{
    private PApplet ui;

    public SearchMode (PApplet ui)
    {
        this.ui = ui;
    }

    public void render()
    {
        float centerx = ui.width/2;
        float centery = ui.height/2;
        //fill(255);
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(centerx, centery,ui.width/(float)5.5,ui.height/(float)5.5); //big circle
        ui.fill(255,0,0);
        ui.stroke(255);
        ui.line(centerx - ui.width/11, centery, centerx + ui.width/11, centery); //line across small circle
        ui.line(centerx,centery + 20, centerx, centery - 20); //tiny center line
        ui.fill(255);
        ui.textAlign(ui.CENTER, ui.CENTER);
        ui.textSize(50);
        ui.text("SEARCH MODE", centerx, centery + (ui.height/6));
        ui.textSize(30);
    }
}