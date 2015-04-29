package edu.usu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;



public class DotObject extends GameObject {
	
	public boolean isBig;
	public int size;
	
	
	
	public DotObject(int x, int y, boolean b){
		this.xPos = x;
		this.yPos = y;
		this.isBig = b;
		this.OnEnable();
	}

	@Override
	public void Update() {

		// If the player is close enough then check and see if we are colliding and the call
		// The players OnCollision function passing myself as a parameter.
		if(Math.abs(this.xPos - GameClass.player.xPos) < 100 && Math.abs(this.yPos - GameClass.player.yPos) < 50){
			if(this.CheckPlayerCollision()){
				GameClass.player.OnCollision(this);
			}
		}
	}

	
	@Override
	public void OnCollision(GameObject other) {
		
		// TODO Auto-generated method stub
		// Do nothing because in our game the only object that truly handles collisions
		// is our pacman guy.
	}

	@Override
	public void OnEnable() {
		
		// Check if its a big dot and set the size accordingly
		if(this.isBig)
			size = 16;
		else 
			size = 8;
		
		// add to our list of game objects
		GameClass.staticGameObjects.add(this);
		
	}

	@Override
	public void OnDisable() {
		// remove from game object list so i dont appear on screen
		GameClass.staticGameObjects.remove(this);
	}

	@Override
	public void PaintToScreen(Graphics2D g) {
		//Draw in different places on the screen depening on size
		if(!this.isBig)
		g.fillOval(this.xPos, this.yPos, size, size);
		else g.fillOval(this.xPos -8, this.yPos - 8, this.size, this.size);
		
		g.setColor(Color.YELLOW);
		
		//g.drawimage(",",//image to draw)
	}
	
	// Gets the area that im taking up on screen
	public Rectangle getBounds() {
		return new Rectangle(this.xPos, this.yPos, this.size, this.size);
	}
	
	// Checks if my area intesects the players area. Called in the update function.
	public boolean CheckPlayerCollision(){
		if(this.getBounds().intersects(GameClass.player.getBounds()))
			GameClass.player.OnCollision(this);
		return false;
	}

}
