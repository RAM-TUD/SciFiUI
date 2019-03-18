package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
      
    }

    public void draw()
    {
        background(0);
        searchmode();
        

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }

    public void searchmode()
    {
        
        float centerx = width / 2;
        float centery = height / 2;
        fill(255);
        ellipse(centerx, centery,width/4,height/4); //big circle
        ellipse(centerx, centery, width/6, height/6); //small circle
        line(centerx - width/12, centery, centerx + width/12, centery); //line across small circle
        line(centerx,centery + 10, centerx, centery - 10); //tiny center line
        textAlign(CENTER, CENTER);
        textSize(50);
        text("SEARCH MODE", centerx, centery + (height/6));
        textSize(30);
        
    }
}

