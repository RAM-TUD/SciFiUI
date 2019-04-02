package ie.tudublin;





import java.util.ArrayList;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;




public class UI extends PApplet
{
    
    
    PImage alley;
    PImage offline;
    PImage target;
    PImage pedestrian1;
    PImage pedestrian2;
    PImage pedestrian3;
    PImage woman;
    PImage man;
    PImage bkimage;
    Targeting targeting;
    ArrayList<UIElements> elements = new ArrayList<UIElements>();
    boolean aquireinfo = false;
    boolean online = false;
    AudioPlayer file;
    Minim minim;
    
    public void settings()
    {
        fullScreen();
    }

    public void draw()
    {
    
        background(bkimage);
        if(online == false)
        {
            searchmode();
            loading();
        }
        if(online == true)
        {
            if(bkimage == alley)
            {
                targeting.targets(pedestrian1,300, height/2 - 50, 100, 300);
                targeting.targets(pedestrian2, 750, height/2 - 40, 250, 270);
                targeting.targets(pedestrian3, 650, height/2 - 85, 80, 200);
                for(int i = 0 ; i < elements.size() ; i ++)
                {
                    elements.get(i).render();
                }
                design();
                searchmode();
            }
            if(bkimage == woman)
            {
                targeting.displayArea();
                if(aquireinfo == true)
                {
                    targeting.displayInfo("TARGET IDENTIFIED : ANNA HOMES","GENDER: WOMAN | AGE 45", "OCCUPATION:SECRETARY AT LIU WEB APP CORPS",false);
                }
    
            }
            targeting.targeticon();
            
        }
    
    }
    public void setup()
    {
        minim = new Minim(this);
        file = minim.loadFile("Theyre-Here.mp3", 2000);
        file.play();
        alley = loadImage("street.jpg");
        offline = loadImage("back.jpg");
        elements.add(new CircleUI(this,100,100,50));
        elements.add(new Barchart(this, 30, height - 30));
        elements.add(new Grid(this,width - 285, (height/2) - 20, 250));
        elements.add(new Numbers(100,200,this)); 
        for(int i = 0; i < 8; i++)
        {
            elements.add(new Button(this,350 + (i*80),50,50));
        }
        targeting = new Targeting(this,50);
        pedestrian1 = targeting.loadtarget("man.png");
        pedestrian2 = targeting.loadtarget("woman.png");
        pedestrian3 = targeting.loadtarget("soldier.png");
        woman = loadImage("womantargeted.jpg");
        man = loadImage("mantargeted.jpg");
        bkimage = offline;
     }
        
    public void mousePressed()
    {
        if(mouseX > 750 && mouseX < 750 + 270 && mouseY > height/2 - 40 && mouseY < height/2 - 40 + 250 )
        {
            bkimage = woman;
            
        }
        if(mouseX > 300 && mouseX < 300 + 100 && mouseY > height/2 -50 && mouseY < height/2 - 50 + 300)
        {
            bkimage = man;
        }
        if(bkimage == woman)
        {
            if(mouseX > width/2 - 50 && mouseX < width/2 - 50 + 200 && mouseY > 150 && mouseY < 150 + 200)
            {
                aquireinfo = true;
            } 
        }
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
            online = true;
            bkimage = alley;
            
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
       
       
        
        

   

        
        //line coming down
        stroke(255);
        line(0, y, width, y);
        y+=5;
        if (y > height)
        {
            y = 0; 
        }
        
        

       
    }

    public void pointalize()
    {
        float x = random(0,width);
        float y = random(0,height);
        fill(200,0,0);
        ellipse(x,y,10,10);
    }

   
}

