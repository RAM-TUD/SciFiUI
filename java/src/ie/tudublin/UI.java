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
    ArrayList<Display> displays = new ArrayList<Display>();
    boolean online = false;
    boolean terminate;
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
                int analyse = 0;
                for(int i = 0; i <= 2; i++)
                {
                    Display d = displays.get(i);
                    d.render();
                }
                if(areaselect != -1 && areaselect < 3)
                {
                    if(analyse == 0)
                    {
                        terminate = false;
                    }
                    Display d = displays.get(areaselect);
                    float x = d.x;
                    float y = d.y;
                    line(x, y + d.getSize()/4, x - 150, y + d.getSize()/4 );
                    line(x - 150, y + d.getSize()/4, x - 150, y + d.getSize()/4 - 30 );
                    line(x - 150, y + d.getSize()/4 - 30, x - 250, y + d.getSize()/4 - 30 );
                    textSize(15);
                    text(d.getAnalysis() + " " + areaselect, x - 250, y + d.getSize()/4 - 60);
                    analyse++;
                }
                if(analyse >= 3)
                {
                    terminate = true;
                    textSize(20);
                    text("ANALYSIS COMPLETE : BEGIN TERMINATION?",20,height-20);
                    analyse = 0;
                }
            }
            if(bkimage == man)
            {
                int analyse = 0;
                for(int i = 3; i < 5; i++)
                {
                    Display d = displays.get(i);
                    d.render();
                }
                if(areaselect != -1 && areaselect > 2)
                {
                    if(analyse == 0)
                    {
                        terminate = false;
                    }
                    Display d = displays.get(areaselect);
                    float x = d.x;
                    float y = d.y;
                    line(x, y + d.getSize()/4, x - 150, y + d.getSize()/4 );
                    line(x - 150, y + d.getSize()/4, x - 150, y + d.getSize()/4 - 30 );
                    line(x - 150, y + d.getSize()/4 - 30, x - 250, y + d.getSize()/4 - 30 );
                    textSize(15);
                    text(d.getAnalysis() + " " + areaselect, x - 250, y + d.getSize()/4 - 60);
                    analyse++;
                }
                if(analyse >= 3)
                {
                    terminate = true;
                    textSize(20);
                    text("ANALYSIS COMPLETE : BEGIN TERMINATION?",20,height-20);
                    analyse = 0;
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
        displays.add(new Display(width/2 + 200, height/2 +50, this,150, "NO WEAPON IDENTIFIED|INCAPABLE OF SELF-DEFENSE: THREAT LEVEL MINIMUM"));
        displays.add(new Display(width/2 - 50,150,this,200,"TARGET IDENTIFIED : ANNA HOMES, GENDER: WOMAN | AGE 45"));
        displays.add(new Display(width/2 - 70, height - 150,this, 120, "OCCUPATION SECURED : OFFICE SECRETARY AT LUMINO CORPS"));
        displays.add(new Display(width/2,100,this,150,"TARGET IDENTIFIED : JACOB HOMES | CONFIRMED MATCH "));
        displays.add(new Display(width/2 - 50, height - 200,this,150,"BEER CAN AT ARMS : STABILITY AT 73%| CAPABLE OF ATTACK - CAUTION ADVISED"));
        targeting = new Targeting(this,50);
        pedestrian1 = targeting.loadtarget("man.png");
        pedestrian2 = targeting.loadtarget("woman.png");
        pedestrian3 = targeting.loadtarget("soldier.png");
        woman = loadImage("womantargeted.jpg");
        man = loadImage("mantargeted.jpg");
        bkimage = offline;
     }
    int areaselect = -1;    
    public void mousePressed()
    {
        if(bkimage == alley && mouseX > 750 && mouseX < 750 + 270 && mouseY > height/2 - 40 && mouseY < height/2 - 40 + 250 )
        {
            bkimage = woman;
            
        }
        if(bkimage == alley && mouseX > 300 && mouseX < 300 + 100 && mouseY > height/2 -50 && mouseY < height/2 - 50 + 300)
        {
            bkimage = man;
        }
        if(bkimage == woman | bkimage == man)
        {
            for(int i = 0; i < displays.size(); i++)
            {
                float x = displays.get(i).x;
                float y = displays.get(i).y;
                if(dist(mouseX,mouseY,x + x/4,y + y/4) < displays.get(i).getSize())
                {
                    areaselect = i;
                }
            }
        }
    }
    
    public void keyPressed() {
        /*if(key == 't' && terminate == true)
        {
        }*/
        if(key == 'b' && bkimage != alley)
        {
            bkimage = alley;
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

