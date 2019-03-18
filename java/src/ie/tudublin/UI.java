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
        // Use fullscreen instead of size to make your interface fullscreen
        fullScreen(); 
    }

    public void setup()
    {
      
    }

    public void draw()
    {
        background(255,0,0);
        design();
        searchmode();
        loading();
        
        

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

    float loadingbar = 0;
    public void loading()
    {
        
        textSize(30);
        float centerx = width/2;
        fill(255,0,0);
        rect(centerx - 200, height - 150, 400,50);
        fill(255);
        rect(centerx - 200, height - 150, loadingbar, 50);
        if(loadingbar == 400)
        {
            
            loadingbar = 400;
            text("ONLINE", width - 80, 50);
            fill(0,255,0);
            rect(centerx - 200, height - 150, loadingbar, 50);
            text("ACTIVATED", centerx, height/2 + (height/6) + 50);
        }
        else
        {
            text("OFFLINE", width - 80, 50);
            text("ACTIVATING ...", centerx, height/2 + (height/6) + 50);
            loadingbar++;
        }
     
    }
    float rotatex = 0;
    float rotatey = 50;
    public void design()
    {
       
        //circle icon on top left
        int outline = 150;
        stroke(255);
        noFill();
        for(int i = 0; i < 25; i++)
        {
            ellipse(100,100,outline,outline);
            outline--;
        }
        fill(255,0,0);
        //ellipse(100,100,100,100);
        fill(255);
        ellipse(100,100,30,30);

    }
}

