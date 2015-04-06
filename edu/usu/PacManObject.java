package edu.usu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

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
	
	private Image rightImage;
	private Image leftImage;
	private Image downImage;
	private Image upImage;
	
	//private int[] dims = {50, 25};
	//private int myDim = 50;
	// AS MUCH AS YOU CAN YOU SHOULD INITIALIZE IN THE ONENABLE FUNCTION 
	// AND THEN CALL THE ONENABLE FUNCTION LIKE LISTED BELOW
	
	public PacManObject(int x, int y, int d, boolean s){
		this.xPos = x;
		this.yPos = y;
		this.direction = d;
		this.isStatic = s;
		
		try{
            File image1 = new File("PacRight.png");
            File image2 = new File("PacLeft.png");
            File image3 = new File("PacUp.png");
            File image4 = new File("PacDown.png");
            rightImage = ImageIO.read(image1);
            leftImage = ImageIO.read(image2);
            upImage = ImageIO.read(image3);
            downImage = ImageIO.read(image4);
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
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		//System.out.println("PacManUpdate");
		
		
		if(this.CheckChangeDirection()){
			this.ChangeDirection(nextDir);
		}
		this.Move();
		// IF COLLSION WITH OTHER OBJECT
		//	THEN CALL ONCOLLSION
	}
	
	// EVERYTHING YOU WANT TO DO WHEN THIS OBJECT COLLIDES WITH ANOTHER GAME OBJECT
	// GOES IN HERE
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
				a.xPos = 650;
				a.yPos = 600;
				a.direction = 0;
				//a.OnDisable();
			}else {
				GameClass.gameObjects.remove(this);
				this.OnDisable();
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
	
	public void ChangeDirection(int dir){
		this.speedX =1;
		this.speedY =1;
		this.direction = dir;
		if(dir == 0) visRep = leftImage;
		if(dir == 1) visRep = upImage;
		if(dir == 2) visRep = rightImage;
		if(dir == 3) visRep = downImage;
	}
	
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
	
	
	
	public Rectangle getBounds() {
		return new Rectangle(this.xPos-12 ,this.yPos-12, 24 , 24);
	}
	
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
	@Override
	public void run(){
		//int i = 0;
		while(true){
			//System.out.println("THIS RUNS EVERY SECOND");
			//System.out.println(this.nextDir);
			//if(i > 1)
				//i=0;
			//this.myDim = this.dims[i];
			//i++;
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}

	

