package edu.usu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

//=====================================================
// USE THIS CLASS AS AN EXAMPLE FOR CREATING YOUR CLASSES.
// YOU SHOULD BE ABLE TO MAKE YOUR CLASSES WITHOUT MODIFYING ANY OTHER CLASS
// WITH THE EXECPTION OF THE INSTRUCTIONS IN THE GAMECLASS.JAVA FILE
// 
// DONT MODIFY ANY OTHER FILES WITHOUT THE REST OF THE GROUP OR WHEN WE COMBINE EVERYTHING
// TOGETHER, YOURS OR SOMEONE ELSES FILES WONT WORK.
//=====================================================

public class PacManObject extends GameObject implements EventListener, Runnable {
	
	// YOU WILL LIKELY NEED TO CREATE NEW VARIABLES THAT ARENT IN THE GAMEOBJECT BASE CLASS.
	// THESE SHOULD BE PRIVATE BECAUSE THEY WONT NEED TO BE ACCESSED BY ANY OTHER CLASSES
	private int speedX=1;
	private int speedY=1;
	private int nextDir;
	
	// These are the sounds, sorry you wont be able to here them because I am not hosting
	// the website anymore.
	URL url;
	URL url2;
	URL url3;
	URL url4;
	String website = "https://javapacman.ngrok.com/pacman_chomp.wav";
	String website2 = "https://javapacman.ngrok.com/pacman_death.wav";
	String website3 = "https://javapacman.ngrok.com/pacman_eatfruit.wav";
	String website4 = "https://javapacman.ngrok.com/pacman_eatghost.wav";
	AudioClip clip;
	AudioClip clip2;
	AudioClip clip3;
	AudioClip clip4;
	
	AudioClip deathClip;
	
	private Image rightImage;
	private Image leftImage;
	private Image downImage;
	private Image upImage;
	private Image mouthClosedImage;
	private Image visRep2;
	private int dotCount;
	
	//private int[] dims = {50, 25};
	//private int myDim = 50;
	// AS MUCH AS YOU CAN YOU SHOULD INITIALIZE IN THE ONENABLE FUNCTION 
	// AND THEN CALL THE ONENABLE FUNCTION LIKE LISTED BELOW
	
	
	//sets position images and sounds
	public PacManObject(int x, int y, int d, boolean s){
		this.xPos = x;
		this.yPos = y;
		this.direction = d;
		this.isStatic = s;
		this.dotCount = 0;
		try{
			url = new URL(website);
			url4 = new URL(website2);
			url2 = new URL(website3);
			url3 = new URL(website4);
			//url4 = new URL(webstie4);
			clip = Applet.newAudioClip(url);
			clip2 = Applet.newAudioClip(url);
			clip3 = Applet.newAudioClip(url2);
			clip4 = Applet.newAudioClip(url3);
			deathClip = Applet.newAudioClip(url4);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
            File image1 = new File("PacRight.png");
            File image2 = new File("PacLeft.png");
            File image3 = new File("PacUp.png");
            File image4 = new File("PacDown.png");
            File image5 = new File("PacMouthClosed.png");
            rightImage = ImageIO.read(image1);
            leftImage = ImageIO.read(image2);
            upImage = ImageIO.read(image3);
            downImage = ImageIO.read(image4);
            mouthClosedImage = ImageIO.read(image5);
            visRep = leftImage;
        }
        catch (IOException e){
            e.printStackTrace();
        }
		this.OnEnable();
	}
	
	// EVERY THING THAT PACMAN DOES YOU NEED TO PUT IN HERE, RIGHT NOW IT
	// SIMPLY ADDS ON TO THE XPOSITION, THEN AFTER ALL THE UPDATES HAVE OCCURED THE REPAINT 
	// FUNCTION MOVES THE POSITION OF THE OBJECT ON THE SCREEN.
	
	// Things that happen every frame.
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		//System.out.println("PacManUpdate");
		
		// checks if we pushed the arrow keys and then sets our next direction
		// next time we can turn
		if(this.CheckChangeDirection()){
			this.ChangeDirection(nextDir);
		}
		this.Move();
		// IF COLLSION WITH OTHER OBJECT
		//	THEN CALL ONCOLLSION
	}
	
	// EVERYTHING YOU WANT TO DO WHEN THIS OBJECT COLLIDES WITH ANOTHER GAME OBJECT
	// GOES IN HERE
	
	// Called when we collide with ghosts, walls, or dots.
	@Override
	public void OnCollision(GameObject other) {
		// TODO Auto-generated method stub
		if(other.getClass() == WallObject.class){			
			if(this.direction==2){
				this.xPos = xPos-1;
				this.speedX =0;
				this.speedY =0;
			}if(this.direction==0){
				this.xPos = xPos+1;
				this.speedX =0;
				this.speedY =0;
			}if(this.direction == 3){
				this.yPos = yPos-1;
				this.speedX =0;
				this.speedY =0;
			}if(this.direction==1){
				this.yPos = yPos+1;
				this.speedX =0;
				this.speedY =0;
			}
		}
		if(other.getClass()==Ghost.class){
			Ghost a = (Ghost)other;
			if(a.canDie){
				//GameClass.gameObjects.remove(a);
				clip4.play();
				a.xPos = 650;
				a.yPos = 600;
				a.direction = 0;
				a.canDie = false;
				GameClass.points += 250;
				//a.OnDisable();
			}else {
				deathClip.play();
				GameClass.gameObjects.remove(this);
				GameClass.willContinue = false;
				JOptionPane.showMessageDialog(null, "YOU HAVE DIED");
				this.OnDisable();
			}
		}
		if(other.getClass()==DotObject.class){
			DotObject temp = (DotObject)other;
			dotCount++;
			if(dotCount%4==0){
				clip.play();
			}
			else if(dotCount%4 == 2){
				clip2.play();
			}
			
			//System.out.println("CALLED");
			if(temp.isBig){
				clip3.play();
				GameClass.points += 200;
				GameClass.ghost1.SetCanDie();
				GameClass.ghost2.SetCanDie();
				GameClass.ghost3.SetCanDie();
				GameClass.ghost4.SetCanDie();
				GameClass.ghost5.SetCanDie();
				GameClass.ghost6.SetCanDie();
				GameClass.ghost7.SetCanDie();
				GameClass.ghost8.SetCanDie();
				GameClass.ghost9.SetCanDie();
				GameClass.ghost10.SetCanDie();
				GameClass.ghost11.SetCanDie();
				GameClass.ghost12.SetCanDie();
				GameClass.staticGameObjects.remove(other);
				GameClass.numOfDots++;
				//System.out.println(GameClass.numOfDots);
			}else {
				GameClass.numOfDots++;
				GameClass.points += 100;
				//System.out.println(GameClass.numOfDots);
				GameClass.staticGameObjects.remove(other);
			}
			if(GameClass.numOfDots == GameClass.totalNumOfDots){
				GameClass.willContinue = false;
				JOptionPane.showMessageDialog(null, "YOU HAVE WON!");
			}
		}
	}
	
	// THIS IS WHAT WILL HAPPEN EVERYTIME WE ADD A GAME OBJECT TO THE GAME
	// !EVERY GAME OBJECT WILL NEED TO ADD ITSELF TO THE LIST OF GAMEOBJECTS OR STATICGAMEOBJECTS
	// AS SHOWN BELOW!
	
	@Override
	public void OnEnable() {
		// This is basically the constructor
		GameClass.gameObjects.add(this);
	}
	
	// THIS GETS CALLED WHEN WE REMOVE THE GAME OBJECT FROM THE GAME SOMETHINGS YOU
	// MIGHT WANT TO DO WITH IT ARE REINITIALIZE VARIABLES OR SEND A MESSAGE TO THE OTHER GAMEOBJECTS
	// TO DO SOMETHING, FOR EXAMPLE, IF A GHOST DIES, INCREASE THE SPEED OF THE OTHER GHOSTS
	@Override
	public void OnDisable() {
		// TODO Auto-generated method stub
		
	}
	
	// THIS IS WHAT DRAWS THE IMAGE TO THE SCREEN IT REALLY SHOULDNT DO ANYTHING MORE THAN
	// WHAT IS SHOWN HERE EXCEPT IT WILL DRAW AN IMAGE INSTEAD OF A RECTANGLE.
	@Override
	public void PaintToScreen(Graphics2D g) {
		// TODO Auto-generated method stub
		
		//g.fillRect(xPos - 12, yPos - 12, 24, 24);
		g.drawImage(visRep, xPos-12, yPos-12, null );
		
	}
	
	public void ChangeNextDirection(int dir){
		//System.out.println("this works");
		if(this.direction == 0 && dir == 2){
			this.ChangeDirection(dir);
			this.nextDir = dir;
			return;
		}
		if(this.direction == 1 && dir == 3){
			this.ChangeDirection(dir);
			this.nextDir = dir;
			return;
		}
		if(this.direction == 2 && dir == 0){
			this.ChangeDirection(dir);
			this.nextDir = dir;
			return;
		}
		if(this.direction == 3 && dir == 1){
			this.ChangeDirection(dir);
			this.nextDir = dir;
			return;
		}
		if(this.direction == dir)
			return;
		
		this.nextDir = dir;
		
	}
	
	// changes our direction and image when called
	public void ChangeDirection(int dir){
		this.speedX =1;
		this.speedY =1;
		this.direction = dir;
		if(dir == 0) visRep2 = leftImage;
		if(dir == 1) visRep2 = upImage;
		if(dir == 2) visRep2 = rightImage;
		if(dir == 3) visRep2 = downImage;
	}
	
	// checks if we are in place where we can change direction, we 
	// do this because if the player pushes the arrow key one frame too early then
	// you will get stuck.
	public boolean CheckChangeDirection(){
		if(this.direction == 0 || this.direction ==2){
			if(this.xPos-12 == 100-12) return true;
			if(this.xPos-12 == 200-12) return true;
			if(this.xPos-12 == 300-12) return true;
			if(this.xPos-12 == 400-12) return true;
			if(this.xPos-12 == 500-12) return true;
			if(this.xPos-12 == 600-12) return true;
			if(this.xPos-12 == 700-12) return true;
			if(this.xPos-12 == 800-12) return true;
			if(this.xPos-12 == 900-12) return true;
			
			if(this.xPos-12 == 50-12) return true;
			if(this.xPos-12 == 150-12) return true;
			if(this.xPos-12 == 250-12) return true;
			if(this.xPos-12 == 350-12) return true;
			if(this.xPos-12 == 450-12) return true;
			if(this.xPos-12 == 550-12) return true;
			if(this.xPos-12 == 650-12) return true;
			if(this.xPos-12 == 750-12) return true;
			if(this.xPos-12 == 850-12) return true;
			if(this.xPos-12 == 950-12) return true;
			return false;
		}
		if (this.direction == 1 || this.direction == 3){
			if(this.yPos-12 == 0) return true;
			if(this.yPos-12 == 100-12) return true;
			if(this.yPos-12 == 200-12) return true;
			if(this.yPos-12 == 300-12) return true;
			if(this.yPos-12 == 400-12) return true;
			if(this.yPos-12 == 500-12) return true;
			if(this.yPos-12 == 600-12) return true;
			if(this.yPos-12 == 50-12) return true;
			if(this.yPos-12 == 150-12) return true;
			if(this.yPos-12 == 250-12) return true;
			if(this.yPos-12 == 350-12) return true;
			if(this.yPos-12 == 450-12) return true;
			if(this.yPos-12 == 550-12) return true;
			if(this.yPos-12 == 650-12) return true;
			return false;		
		}
		return false;
	}
	
	
	// gets our area
	public Rectangle getBounds() {
		return new Rectangle(this.xPos-12 ,this.yPos-12, 24 , 24);
	}
	
	// moves us based off of direction
	private void Move(){
		switch(this.direction){
		case 0: this.xPos -= this.speedX;
		break;
		case 1: this.yPos -= this.speedY;
		break;
		case 2: this.xPos += this.speedX;
		break;
		case 3: this.yPos += this.speedY;
		}
	}
	
	//USE THIS TO CHANGE THE SPRITES
	
	// a separate thread to handle the mouth movement asynchronously.
	@Override
	public void run(){
		int i = 0;
		int j = 0;
		while(true){
			//System.out.println("THIS RUNS EVERY SECOND");
			//System.out.println(this.nextDir);
			if(i==0){
				visRep = visRep2;
				i++;
				//System.out.println("I am getting called");
				}
			else {
				visRep = mouthClosedImage;
				i=0;
			}
			
			//i++;
			try
			{
				
				Thread.sleep(125);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}

	

