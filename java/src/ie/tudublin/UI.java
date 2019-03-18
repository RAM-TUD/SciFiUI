package ie.tudublin;



import processing.core.PApplet;
import processing.core.PImage;



public class UI extends PApplet
{
    
    PImage alley;
    PImage target;
    Button button;
    public void settings()
    {
        fullScreen();
    }

    public void draw()
    {
        
        background(alley);
        //background(255,0,0);
        button.render();
        searchmode();
        loading();
        design();
        
        
    }

    public void setup()
    {
        System.out.println(width);
        System.out.println(height);
        alley = loadImage("street.jpg");
        target = loadImage("target.jpg");
        button = new Button(this,width/2,50,50);
    }


    public void searchmode()
    {
        
        float centerx = width / 2;
        float centery = height / 2;
        
        //fill(255);
        stroke(255);
        noFill();
        ellipse(centerx, centery,width/(float)5.5,height/(float)5.5); //big circle
        fill(255,0,0);
        stroke(255);
        line(centerx - width/11, centery, centerx + width/11, centery); //line across small circle
        line(centerx,centery + 20, centerx, centery - 20); //tiny center line
        fill(255);
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
        stroke(0);
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
    float r = 0;
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

        


        //grid
        int gap = 40;
        int gridx = 950;
        int gridy = 350;
        
        image(target,gridx, gridy,280,200);
        textSize(35);
        text("AQUIRED TARGET",gridx + 135,gridy + 250);
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

        //appreaing buttons
        /*int timer = 0;
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
            
        }*/

        //line coming down
        stroke(255);
        line(0, y, width, y);
        y+=5;
        if (y > height)
        {
            y = 0; 
        }
        
        

       
    }

   
}

