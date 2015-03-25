package edu.usu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;

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
	
	//private int[] dims = {50, 25};
	//private int myDim = 50;
	// AS MUCH AS YOU CAN YOU SHOULD INITIALIZE IN THE ONENABLE FUNCTION 
	// AND THEN CALL THE ONENABLE FUNCTION LIKE LISTED BELOW
	public PacManObject(int x, int y, int d, boolean s){
		this.xPos = x;
		this.yPos = y;
		this.direction = d;
		this.isStatic = s;
		this.OnEnable();
	}
	
	// EVERY THAT PACK MAN DOES YOU NEED TO PUT IN HERE, RIGHT NOW IT
	// SIMPLY ADDS ON TO THE XPOSITION, THEN AFTER ALL THE UPDATES HAVE OCCURED THE REPAINT 
	// FUNCTION MOVES THE POSITION OF THE OBJECT ON THE SCREEN.
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		//System.out.println("PacManUpdate");
		
		if(this.CheckChangeDirection()){
			this.ChangeDirection(nextDir);
			System.out.println("true");
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
			WallObject obj = (WallObject)other;
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
		g.fillRect(xPos - 24, yPos -24, 48, 48);
		
	}
	
	public void ChangeNextDirection(int dir){
		System.out.println("this works");
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
	}
	
	public boolean CheckChangeDirection(){
		if(this.direction == 0 || this.direction ==2){
			if(this.xPos-24 == 100-24) return true;
			if(this.xPos-24 == 200-24) return true;
			if(this.xPos-24 == 300-24) return true;
			if(this.xPos-24 == 400-24) return true;
			if(this.xPos-24 == 500-24) return true;
			if(this.xPos-24 == 600-24) return true;
			if(this.xPos-24 == 700-24) return true;
			if(this.xPos-24 == 800-24) return true;
			if(this.xPos-24 == 50-24) return true;
			if(this.xPos-24 == 150-24) return true;
			if(this.xPos-24 == 250-24) return true;
			if(this.xPos-24 == 350-24) return true;
			if(this.xPos-24 == 450-24) return true;
			if(this.xPos-24 == 550-24) return true;
			if(this.xPos-24 == 650-24) return true;
			if(this.xPos-24 == 750-24) return true;
			return false;
		}
		if (this.direction == 1 || this.direction == 3){
			if(this.yPos-24 == 0) return true;
			if(this.yPos-24 == 100-24) return true;
			if(this.yPos-24 == 200-24) return true;
			if(this.yPos-24 == 300-24) return true;
			if(this.yPos-24 == 400-24) return true;
			if(this.yPos-24 == 500-24) return true;
			if(this.yPos-24 == 600-24) return true;
			if(this.yPos-24 == 50-24) return true;
			if(this.yPos-24 == 150-24) return true;
			if(this.yPos-24 == 250-24) return true;
			if(this.yPos-24 == 350-24) return true;
			if(this.yPos-24 == 450-24) return true;
			if(this.yPos-24 == 550-24) return true;
			//if(this.yPos-24 == 650-24) return true;
			return false;		
		}
		return false;
	}
	
	
	
	public Rectangle getBounds() {
		return new Rectangle(this.xPos -24 , this.yPos -24, 48 , 48);
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
		// TODO Auto-generated method stub
		int i = 0;
		while(true){
			System.out.println("THIS RUNS EVERY SECOND");
			System.out.println(this.nextDir);
			if(i > 1)
				i=0;
			//this.myDim = this.dims[i];
			i++;
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

	

