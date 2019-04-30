package ie.tudublin;

import java.util.ArrayList;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.Table;
import processing.data.TableRow;

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
    PImage soldier;
    PImage bkimage;
    Targeting targeting;
    ArrayList<UIElements> elements = new ArrayList<UIElements>();
    ArrayList<Display> displays = new ArrayList<Display>();
    ArrayList<Specs> specs = new ArrayList<Specs>();
    boolean online = false;
    boolean terminate = false;
    AudioPlayer file;
    Minim minim;
    SearchMode searchmode;
    int analyse;
    boolean killedWoman = false;
    boolean killedMan = false;
    PImage dead;
    PoliceLights popo;
    AudioPlayer scan;
    AudioPlayer intro;
    AudioPlayer womanscream;
    AudioPlayer manscream;
    int threatlevel;
    Weapon weapon;
    ShieldGenerator shield;
    Shield barrier;
    AudioPlayer field;
    ArrayList<Shield>force = new ArrayList<Shield>();
    boolean witnessKilled = false;
;    
    
    public void settings()
    {
        fullScreen();
    }

    public void draw()
    {
    
        background(bkimage);
        if(online == false)
        {
            searchmode.render();
            loading();
        }
        if(online == true)
        {
            
            if(bkimage == alley)
            {
                if(killedMan == true)
                {
                    fill(255);
                    textSize(35);
                    text("TARGET ELIMINATED: MISSION SUCCESS",width/2,200);
                }
                textSize(30);
                text("ONLINE", width - 80, 50);
                printSpec();
                
                if(killedMan == false)
                {
                    targeting.targets(pedestrian1,300, height/2 - 50, 100, 300);
                }
                if(killedWoman == false)
                {
                    targeting.targets(pedestrian2, 750, height/2 - 40, 250, 270);
                }
                targeting.targets(pedestrian3, 650, height/2 - 85, 80, 200);
                for(int i = 0 ; i < elements.size() ; i ++)
                {
                    elements.get(i).render();
                }
                design();
                searchmode.render();
            }
                
        }
            if(bkimage == woman)
            {
                
                textSize(20);
                if(analyse == 0)
                {
                    text("CURRENT THREAT LEVEL: UNKNOWN",200,100);
                }
                else
                {
                    text("CURRENT THREAT LEVEL: " + threatlevel + "%",200,100);
                }
                if(threatlevel < 30 && threatlevel > 0)
                {
                    fill(0,255,0);
                    text("-THREAT LEVEL LOW, NO DANGER",515,100);
                    fill(255);
                }
                else if(threatlevel > 30 && threatlevel < 60)
                {
                    fill(255,255,0);
                    text("-OPTIMAL LEVEL: BE WARY",515,100);
                    fill(255);
                }
                else if(threatlevel > 60)
                {
                    fill(255,0,0);
                    text("DANGER: THREAT LEVEL HIGH",515,100);
                    fill(255);
                }
                for(int i = 0; i <= 2; i++)
                {
                    Display d = displays.get(i);
                    d.render();
                }
                for(int i =0; i <area.length;i++)
                {
                    if(area[i] != -1 && area[i] < 3)  
                {
                    Display d = displays.get(area[i]);
                    float x = d.x;
                    float y = d.y;
                    line(x, y + d.getSize()/4, x - 150, y + d.getSize()/4 );
                    line(x - 150, y + d.getSize()/4, x - 150, y + d.getSize()/4 - 30 );
                    line(x - 150, y + d.getSize()/4 - 30, x - 250, y + d.getSize()/4 - 30 );
                    textSize(15);
                    text(d.getAnalysis() + " " + area[i], x - 250, y + d.getSize()/4 - 60);
                    text(analyse,50,50);
                }
                }
                if(analyse == 3)
                {
                    terminate = true;
                    textSize(20);
                    text("ANALYSIS COMPLETE : BEGIN TERMINATION?",250,height-20);
                }
                if(analyse == 40)
                {
                    for(int i = 0; i < 10; i++)
                    {
                        float liney = random(0,height);
                        line(0,liney,width,liney);
                    }
                    if(womanscream.isPlaying() == false)
                    {
                        bkimage = dead;
                        killedWoman = true;
                    }
                }
            }
            if(bkimage == man)
            {
                weapon.render();
                textSize(20);
                fill(255);
                if(analyse == 0)
                {
                    text("CURRENT THREAT LEVEL: UNKNOWN",200,50);
                }
                else
                {
                    text("CURRENT THREAT LEVEL: " + threatlevel + "%",200,50);
                }
                if(threatlevel < 30 && threatlevel > 0)
                {
                    fill(0,255,0);
                    text("-THREAT LEVEL LOW, NO DANGER",515,50);
                    fill(255);
                }
                else if(threatlevel > 30 && threatlevel < 60)
                {
                    fill(255,255,0);
                    text("-OPTIMAL THREAT LEVEL: BE WARY",515,50);
                    fill(255);
                }
                else if(threatlevel > 60)
                {
                    fill(255,0,0);
                    text("DANGER: THREAT LEVEL HIGH",515,50);
                    fill(255);
                }
                for(int i = 3; i < 6; i++)
                {
                    Display d = displays.get(i);
                    d.render();
                     if(d.isTrigger() == true)
                     {
                         fill(255,0,0,100);
                         rect(d.x,d.y,d.getSize(),d.getSize());
                         line(d.x+d.getSize(),d.y + d.getSize()/2,d.x+d.getSize() + 100,d.y + d.getSize()/2);
                         fill(255);
                         textSize(15);
                         text("THREAT NEUTRILIZED",d.x+d.getSize()+50,d.y-10);
                         witnessKilled = true;
                         weapon.setEnabled(false);
                    }
                }
                for(int i =0; i<area.length;i++)
                {
                    if(area[i] != -1 && area[i] > 2)
                    {
                    Display d = displays.get(area[i]);
                    float x = d.x;
                    float y = d.y;
                    line(x, y + d.getSize()/4, x - 150, y + d.getSize()/4 );
                    line(x - 150, y + d.getSize()/4, x - 150, y + d.getSize()/4 - 30 );
                    line(x - 150, y + d.getSize()/4 - 30, x - 250, y + d.getSize()/4 - 30 );
                    textSize(15);
                    text(d.getAnalysis() + " " + area[i], x - 250, y + d.getSize()/4 - 60);
                  
                    }
                }
                if(analyse == 3)
                {
                    terminate = true;
                    textSize(20);
                    text("ANALYSIS COMPLETE : BEGIN TERMINATION?",250,height-20);
                }
                if(analyse == 40)
                {
                    for(int i = 0; i < 10; i++)
                    {
                        float liney = random(0,height);
                        line(0,liney,width,liney);
                    }
                    if(manscream.isPlaying() == false)
                    {
                        if(witnessKilled == false)
                        {
                            background(0);
                            popo.render();
                            
                        }
                        else
                        {
                            bkimage = dead;
                            killedMan = true;
                        }
                    }
                }
            }
            if(bkimage == soldier)
            {
                shield.render();
                weapon.render();
                float shieldh = shield.y+shield.length-20;
                if(shield.enabled == true && mouseY <= shieldh && mouseY >= shield.y+20 && shield.isActivated() == false)
                {
                    shield.setButtonheight(mouseY);
                }
                if(shield.getButtonheight() == shield.y+20)
                {
                        shield.setActivated(true);
                }
                if(shield.isActivated() == true && shield.fuel != 0)
                {
                    shield.fuel--;
                    for(Shield field:force)
                    {
                        field.render();
                    }
                    field.play();
                }
                else
                {
                    field.pause();
                }
                
                textSize(20);
                if(analyse == 0)
                {
                    text("CURRENT THREAT LEVEL: UNKNOWN",200,100);
                }
                else
                {
                    text("CURRENT THREAT LEVEL: " + threatlevel + "%",200,100);
                }
                if(threatlevel < 30 && threatlevel > 0)
                {
                    fill(0,255,0);
                    text("-THREAT LEVEL LOW, NO DANGER",515,100);
                    fill(255);
                }
                else if(threatlevel > 30 && threatlevel < 60)
                {
                    fill(255,255,0);
                    text("-OPTIMAL LEVEL: BE WARY",515,100);
                    fill(255);
                }
                else if(threatlevel > 60)
                {
                    fill(255,0,0);
                    text("DANGER: THREAT LEVEL HIGH",515,100);
                    fill(255);
                }
                for(int i = 6; i <= 8; i++)
                {
                    Display d = displays.get(i);
                    d.render();
                }
                for(int i =0; i <area.length;i++)
                {
                    if(area[i] > 5 && area[i] < 9)  
                {
                    Display d = displays.get(area[i]);
                    float x = d.x;
                    float y = d.y;
                    line(x, y + d.getSize()/4, x - 150, y + d.getSize()/4 );
                    line(x - 150, y + d.getSize()/4, x - 150, y + d.getSize()/4 - 30 );
                    line(x - 150, y + d.getSize()/4 - 30, x - 250, y + d.getSize()/4 - 30 );
                    textSize(15);
                    text(d.getAnalysis() + " " + area[i], x - 250, y + d.getSize()/4 - 60);
                    text(analyse,50,50);
                }
                }
                if(analyse == 3)
                {
                    terminate = true;
                    textSize(20);
                    text("ANALYSIS COMPLETE : BEGIN TERMINATION?",250,height-20);
                }
                if(analyse == 40)
                {
                    for(int i = 0; i < 10; i++)
                    {
                        float liney = random(0,height);
                        line(0,liney,width,liney);
                    }
                    if(womanscream.isPlaying() == false)
                    {
                        bkimage = dead;
                        killedWoman = true;
                    }
                }
            }
            if(bkimage == dead)
            {
                fill(255,0,0);
                textSize(150);
                text(testTerminate,width/2, height/2);
            }
            if(weapon.isEnabled() == false)
            {
                targeting.targeticon();
            }
            else{
                targeting.weapontarget();
            }
            
        }
    


    public void setup()
    {
        searchmode = new SearchMode(this);
        minim = new Minim(this);
        file = minim.loadFile("Theyre-Here.mp3");
        scan = minim.loadFile("scan.mp3");
        intro = minim.loadFile("intro.mp3");
        womanscream = minim.loadFile("womanscream.mp3");
        manscream = minim.loadFile("manscream.mp3");
        field = minim.loadFile("force.mp3");
        file.play();
        file.loop();
        alley = loadImage("street.jpg");
        offline = loadImage("back.jpg");
        elements.add(new CircleUI(this,100,100,50));
        elements.add(new Barchart(this, 30, height - 30));
        elements.add(new Grid(this,width - 285, (height/2) - 20, 250));
        weapon = new Weapon(width - 200, height/2 + 50, 150,180,false,this);
        shield = new ShieldGenerator(50,height/2-100,200,300,false,this);
        popo = new PoliceLights(width/2,height/2,300,this);
        for(int i = 0; i < 4; i++)
        {
            elements.add(new Numbers(width - 220, 170 + (i*30),this));
        }
        
        for(int i = 0; i < 8; i++)
        { 
            elements.add(new Button(this,350 + (i*80),50,50));
        }
        displays.add(new Display(width/2 - 100, height - 200,this, 120, "OCCUPATION SECURED : OFFICE SECRETARY AT LUMINO CORPS",5,false));
        displays.add(new Display(width/2 + 200, height/2 +50, this,150, "NO WEAPON IDENTIFIED|INCAPABLE OF SELF-DEFENSE: THREAT LEVEL MINIMUM",3,false));
        displays.add(new Display(width/2 - 50,150,this,200,"TARGET IDENTIFIED : ANNA HOMES, GENDER: WOMAN | AGE 45",7,false));
        displays.add(new Display(width/2,100,this,150,"TARGET IDENTIFIED : JACOB HOMES | CONFIRMED MATCH ",9,false));
        displays.add(new Display(width/2 - 50, height - 200,this,120,"BEER CAN AT ARMS : STABILITY AT 73%| CAPABLE OF ATTACK - CAUTION ADVISED",15,false));
        displays.add(new Display(width/2 + 200, 180 ,this,120,"WITNESS IN SURROUNDINGS : CHANCES OF UNDECTION NULLIFIED",34,true));
        displays.add(new Display(width/2 - 220,height/2 - 20,this,100,"TANKS SPOTTED, MUST DEAL WITH TARGET IMMEDIATELY ",24,false));
        displays.add(new Display(width/2 + 150, height - 300,this,150,"GUN CAN AT ARMS : MUST DEFEND SELF",40,false));
        displays.add(new Display(width/2 + 150, 80 ,this,150,"TARGET IDENTIFIED : MASON HAROLDS, DANGEROUS: BE AWARE",25,true));
        targeting = new Targeting(this,50);
        pedestrian1 = targeting.loadtarget("man.png");
        pedestrian2 = targeting.loadtarget("woman.png");
        pedestrian3 = targeting.loadtarget("soldier.png");
        woman = loadImage("womantargeted.jpg");
        man = loadImage("mantargeted.jpg");
        soldier = loadImage("soldierlocked.jpg");
        dead = loadImage("dead.jpg");
        bkimage = offline;
        loadSpec();
        float distance = 30;
        for(int i = 0; i <= 11; i++)
        {
            for(int j = 0; j < 15; j++)
            {
                barrier = new Shield(j*(3*distance),i*(2*(distance)), distance, this);
                force.add(barrier);
            }
        }
        
    }
    int[] area = new int[3];    
    public void mousePressed()
    {
        if(bkimage == alley && mouseX > 750 && mouseX < 750 + 270 && mouseY > height/2 - 40 && mouseY < height/2 - 40 + 250 && killedWoman == false)
        {
            for(int i = 0; i < area.length; i++)
            {
                area[i] = -1;
            }
            analyse = 0;
            bkimage = woman;
            threatlevel = 0;
        }
        if(bkimage == alley && mouseX > 300 && mouseX < 300 + 100 && mouseY > height/2 -50 && mouseY < height/2 - 50 + 300 && killedMan == false)
        {
            for(int i = 0; i < area.length; i++)
            {
                area[i] = -1;
            }
            analyse = 0;
            bkimage = man;
            threatlevel = 0;
        }
        if(bkimage == alley && mouseX > 650 && mouseX < 650 + 250 && mouseY > height/2 && mouseY < height/2 + 30)
        {
            for(int i = 0; i < area.length; i++)
            {
                area[i] = -1;
            }
            analyse = 0;
            tint(255,0,0);
            bkimage = soldier;
            threatlevel = 0;
        }
        if(bkimage == woman)
        {
            for(int i = 0; i < 3; i++)
            {
                float x = displays.get(i).x;
                float y = displays.get(i).y;
                if(mouseX < x + displays.get(i).getSize() && mouseX > x && mouseY < y + displays.get(i).getSize() && mouseY > y)
                {
                    if(displays.get(i).isVisited() == false)
                    {
                        area[analyse] = i;
                        displays.get(i).setVisited(true);
                        scan.play();
                        scan.rewind();
                        
                        if(analyse != 3)
                        {
                            threatlevel += displays.get(i).getIncreasethreat();
                            analyse++;
                        }
                    }  
                }
            }
        }
        if(bkimage == man)
        {
            if(mouseX > weapon.x && mouseX < weapon.x + weapon.getLength() + 50 && mouseY >weapon.y &&  mouseY <weapon.y+weapon.getSize()/2 && weapon.isEnabled() == false)
            {
                weapon.setEnabled(true);
            }
            
            for(int i = 3; i < 6; i++)
            {
                float x = displays.get(i).x;
                float y = displays.get(i).y;
                if(mouseX < x + displays.get(i).getSize() && mouseX > x && mouseY < y + displays.get(i).getSize() && mouseY > y)
                {
                    if(displays.get(i).isVisited() == false)
                    {
                        area[analyse] = i;
                        scan.play();
                        scan.rewind();
                        displays.get(i).setVisited(true);
                        if(analyse != 3)
                        {
                            threatlevel += displays.get(i).getIncreasethreat();
                            analyse++;
                        }
                    }
                    if(displays.get(i).isVisited() == true && weapon.isEnabled() == true)
                    {
                        displays.get(i).setTrigger(true);
                    }
                    
                
                }
            }
        }
        if(bkimage == soldier)
        {
            float triggerx = shield.x+shield.size/2-20;
            float triggery = shield.y+shield.length-20;
            if(mouseX > triggerx && mouseX < triggerx + 40 && mouseY > triggery && mouseY < triggery + 20)
            {
                shield.enabled = true;
            }
            if(mouseX > weapon.x && mouseX < weapon.x + weapon.getLength() + 50 && mouseY >weapon.y &&  mouseY <weapon.y+weapon.getSize()/2 && weapon.isEnabled() == false)
            {
                weapon.setEnabled(true);
            }
            
            for(int i = 6; i < 9; i++)
            {
                float x = displays.get(i).x;
                float y = displays.get(i).y;
                if(mouseX < x + displays.get(i).getSize() && mouseX > x && mouseY < y + displays.get(i).getSize() && mouseY > y)
                {
                    if(displays.get(i).isVisited() == false)
                    {
                        area[analyse] = i;
                        scan.play();
                        scan.rewind();
                        displays.get(i).setVisited(true);
                        if(analyse != 3)
                        {
                            threatlevel += displays.get(i).getIncreasethreat();
                            analyse++;
                        }
                    }
                    if(displays.get(i).isVisited() == true && weapon.isEnabled() == true)
                    {
                        displays.get(i).setTrigger(true);
                    }
                    
                
                }
            }
        }

    }
    String testTerminate;
    public void keyPressed() {
        if(bkimage == alley && shield.enabled == true && key == 'c')
        {
            shield.enabled = false;
        }
        if(key == 't' && analyse == 3)
        {
            testTerminate = "TERMINATED";
            analyse = 40;
            if(bkimage == woman)
            {
                womanscream.play();
            }
            else if(bkimage == man)
            {
                manscream.play();
            }
        }
        if(key == 'b' && bkimage != alley)
        {
            bkimage = alley;
            analyse = 0;
        }
        for(Display d:displays)
        {
            if(d.isHasEvent() == true && d.isVisited() && key == 'k')
            {
                d.setTrigger(true);
                threatlevel -= d.getIncreasethreat() - 20;
            }
        }
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
            fill(0,255,0);
            rect(centerx - 200, height - 150, loadingbar, 50);
            text("ACTIVATED", centerx, height/2 + (height/6) + 50);
            online = true;
            bkimage = alley;
            intro.play();
            
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
    public void loadSpec()
    {
        Table table = loadTable("specs.csv","header");
        for(TableRow row:table.rows())
        {
            Specs spec = new Specs(row);
            specs.add(spec);
        }
    }
    public void printSpec()
    {
        for(int i =0 ; i<specs.size(); i++)
        {
            textSize(15);
            text(specs.get(i).getVersion(), width - 560, height - 100 + (i*15));
            text(specs.get(i).getCorps(), width - 400, height - 100 + (i*15));
            text(specs.get(i).getFeatures(), width/2 - 100, height - 100 + (i*15));
        }
    }
}

