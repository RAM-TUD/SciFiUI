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
    
    int y= 0;
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

        int gap = 40;
        int gridx = 950;
        int gridy = 350;
        
        
        stroke(255);
        for(int i = 0; i < 6; i++)
        {
            int random = (int)(Math.random() * 99 + 1);
            textSize(20);
            text(random,910, gridy);
            line(940 ,gridy,1240,gridy);
            gridy += gap;
        }
        for(int i = 0; i < 9; i++)
        {
            int random = (int)(Math.random() * 99 + 1);
            textSize(20);
            text(random,gridx, 320);
            line(gridx,335,gridx,560);
            gridx += (gap - 5);
        }

        stroke(255);
        line(0, y, width, y);
        y+=5;
        if (y > height)
        {
            y = 0; 
        }

        int timer = 0;
        int xbutton = width/2 - 200;
        int limit = width/2 + 200;
        int buttonspace = 50;
        while(xbutton != limit)
        {
            if(timer <= 500)
            {
                fill(255);
            }
            if(timer%5 == 0)
            {
                fill(255,0,0);
            }
            rect(xbutton,40,40,40);
            xbutton += buttonspace;
            if(timer == 500)
            {
                timer = 0;
            }
            timer++;
            
        }

         //moving bar
         int space = 30;
         int xbar = 30;
         line(30,height - 30, 340, height-30);
         for(int i = 0; i < 12; i++)
         {
             int bar = (int)(Math.random() * 200 + 1);
             rect(xbar,(height-30) - bar ,space,bar);
             xbar += space;
         }

    }
}

