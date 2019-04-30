# SciFi UI Project

Name: Reda Ali Mohammed

Student Number: C17456666 

Fork this repository and use it a starter project for your assignment

# Description of the assignment

A UI for a evil Terminatiing robot, who's goal is to terminate all targets. Made using processing.

# Instructions

While you are in the main screen, click on a silohouette to zoom in to the target.
While you are zoomed in a target, there will be three squares around the target's body. Click on each square to analyse them to update the threat level. Once you have analysed all points, press t to terminate them. After that the target will dissapear from the main screen.
If you are zoomed in the man, one analysis point is a witness. You must click on the weapon and the cursor will change. Click on the witness to eliminate him, otherwise he will call the police, and it's game over.
If you are zoomed in the soldier, pressing t will get you shot down. Clicking the weapon will do the same. You need to activate the shield by clicking the white bar and moving the mouse up until the top. The shield will activate and then you can use the weapon to shoot the soldier. You only have a limited time before the fuel goes down and the shiled gets deactivated.

# How it works

The cursor is controlled by the mouse. The targets being on the main screen is controlled by boolean variables killed = false, once killed it will set change them to true , hence dissapeared. The UI designs are all made using Processing shapes and rotations each with it's own class which all inherit the UIElements super class. All the designs are put into an Arraylist of type UIElements, in here Polymorphism is used as many diffrent elements are instances of their own subclass, but type of super class. The arralist is iterated through in draw(), which draws out all the shapes. These include the Grid(Drawn using lines and for loops),CircleUI (drawn using arcs and transforms such as rotate,translate,pushMatrix,popMatrix,)Barchart (using rects and loops, as well as random()) classes.

The background images is controlled by the PImage variable bkimage. Depending on events such as loading screen finished, or clicked on a silohoutte, the bkimage will be intialised to a diffrent image, thus changing the background.

Using the Display class, each target has three displays. Using mousePressed() will set it's trigger field to true, and increase the threat level field as well. Each untriggered display will increment the analyse variable, upon which if it's three will display a message using text() to terminate, upon pressing t using keyPressed() will change the bkimage to dead after the sound effect using the isPlaying() function from the minim libraries is false.
Some Display objects have hasEvent fields, which will require the user to click on the display when the Weapon object's field isEnabled() is true, turning the display red and decreases the threat level.

The Button class implements the interface Reloader which if the mouse hovers over the button object, it will fill green, and incrementing the ammo field of the Weapon object. It can only be done once it's field used is false, it will be set true once it's hovered over once.

The Specs class encapsulates te data from a csv file, which is loaded in the UI class and populated into an arraylist. It's used to display it on the main page.

UIElements is a super class to design elements, while DefenseSystem is a super class to weapons such as the ShieldGenerator and Weapon class. The Weapon design is drawn using rects and triangles. If clicked it's boolean field is set to true (enabled) which will change the cursor in the Targeting class which draws the icon and silhouettes from targeticon() to weaponicon(). The ShieldGenerator class when the rect is clicked, it's boolean field enabled will be true allowing the rect to be moved up and down by setting it's y coordinate to mouseY up to the length of the line controlled by if statements. Once it reaches the top, it will set Acitvated to true, which will draw objects from the Shield class, which are multiple hexagons iterated through a nested for loop, covering the entire screen. The Shield object was drawn with the functions beginShape() and endShape().

PoliceLigts class is lines thickened by strokeweight(), that is drawn if the Display field trigger when bkimage is man is false. Basically when the witness is not killed when analysing the man

All sound effects were from loading mp3 files, the AudioPlayer class and using minim libraries such as play(),loop(),isplaying() and pause(). All Images were from loading jpg files and the PImage class.


# What I am most proud of in the assignment
I'm most proud of how I made this both a UI and a little game. I incorparated both some designs as well as scenarios in which must be played out to have effect and move on. I'm proud of how I managed to get all the events played out, even scenarios where you have not correctly dealt with the Target, in which you will get a game over, but also making each target a bit more challenging, thus adding more functionality.

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

