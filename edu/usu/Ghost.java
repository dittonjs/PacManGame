package edu.usu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ghost extends GameObject{
	
	int speedX = 1;
	int speedY = 1;
	int pointsToComeAlive = 0;
	private Image rightImage;
	private Image leftImage;
	private Image downImage;
	private Image upImage;
	private Image deadImage;
	public boolean canDie;
	
	// Assign position and images depending on the color value
	public Ghost(int x, int y, int color){
		this.xPos = x;
		this.yPos = y;
		canDie = false;
		File image1;
        File image2;
        File image3;
        File image4;
        File image5;
        image1 = new File("BlueGhostRight.png");
		image2 = new File("BlueGhostLeft.png");
		image3 = new File("BlueGhostUp.png");
		image4 = new File("BlueGhostDown.png");
		image5 = new File("DeadGhost.png");
		try{
		if(color==1){
			image1 = new File("BlueGhostRight.png");
			image2 = new File("BlueGhostLeft.png");
			image3 = new File("BlueGhostUp.png");
			image4 = new File("BlueGhostDown.png");
		}
		if(color==2){
				image1 = new File("TealGhostRight.png");
				image2 = new File("TealGhostLeft.png");
				image3 = new File("TealGhostUp.png");
				image4 = new File("TealGhostDown.png");
			}
		if(color==3){
				image1 = new File("RedGhostRight.png");
				image2 = new File("RedGhostLeft.png");
				image3 = new File("RedGhostUp.png");
				image4 = new File("RedGhostDown.png");
		}
        rightImage = ImageIO.read(image1);
        leftImage = ImageIO.read(image2);
        upImage = ImageIO.read(image3);
        downImage = ImageIO.read(image4);
        deadImage = ImageIO.read(image5);
        visRep = leftImage;
		} catch(IOException e){
			e.printStackTrace();
		}
		this.OnEnable();
	}
	
	// Things that need to run every frame
	@Override
	public void Update() {
		
		// If close enough check if we are colliding
		if(Math.abs(this.xPos - GameClass.player.xPos) < 100 && Math.abs(this.yPos - GameClass.player.yPos) < 100  ){
			if(this.CheckPlayerCollision()){
				GameClass.player.OnCollision(this);
			}
		}
		
		// Check if we are at a point where we can change directions
		if(CheckIfTurn()){
			this.direction = (int)((Math.random()*4)-.01);
			this.ChangeImage();
		}
		if(GameClass.points > pointsToComeAlive){
			this.canDie = false;
			ChangeImage();
		}
		
		// Move the ghost in its direction
		this.Move();
	}

	// gets called when we collide with a wall
	@Override
	public void OnCollision(GameObject other) {
		// TODO Auto-generated method stub
		if(other.getClass() == WallObject.class){			
			if(this.direction==2){
				this.xPos = xPos-1;
			}if(this.direction==0){
				this.xPos = xPos+1;
			}if(this.direction == 3){
				this.yPos = yPos-1;
			}if(this.direction==1){
				this.yPos = yPos+1;
			}
		}
	}

	// sets a default direction and adds ghost to the list of game objects.
	@Override
	public void OnEnable() {
		// Constructor
		this.direction = 1;
		GameClass.gameObjects.add(this);
	}

	// Does nothing
	@Override
	public void OnDisable() {
		// TODO Auto-generated method stub
		
	}
	
	// Draws image to screen
	@Override
	public void PaintToScreen(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(visRep, xPos-12, yPos-12, null);
	}
	
	// changes the image base off of the direction we are facing or if we can die
	private void ChangeImage(){
		if(this.direction == 0) visRep = leftImage;
		if(this.direction == 1) visRep = upImage;
		if(this.direction == 2) visRep = rightImage;
		if(this.direction == 3) visRep = downImage;
		if(this.canDie) visRep = deadImage;
	}
	
	// moves me in the direction i am facing
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
	
	// gets my area on the screen
	public Rectangle getBounds() {
		return new Rectangle(this.xPos-12 , this.yPos-12, 24 , 24);
	}
	
	// checks if im colliding with the player
	public boolean CheckPlayerCollision(){
		if(this.getBounds().intersects(GameClass.player.getBounds()))
			GameClass.player.OnCollision(this);
		return false;
	}
	
	// checks if we are at a turn point and return true or false accordingly
	private boolean CheckIfTurn(){
		
			if(this.xPos-12 == 100-12)
				{	
				if(this.yPos-12 == 100-12)return true;
				if(this.yPos-12 == 300-12)return true;
				if(this.yPos-12 == 400-12)return true;
				if(this.yPos-12 == 550-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
				}
			if(this.xPos-12 == 200-12) {
				if(this.yPos-12 == 100-12)return true;
				if(this.yPos-12 == 150-12)return true;
				return false;
			}
			if(this.xPos-12 == 300-12) {
				if(this.yPos-12 == 50-12)return true;
				if(this.yPos-12 == 100-12)return true;
				if(this.yPos-12 == 150-12)return true;
				if(this.yPos-12 == 200-12)return true;
				if(this.yPos-12 == 250-12)return true;
				if(this.yPos-12 == 400-12)return true;
				if(this.yPos-12 == 500-12)return true;
				if(this.yPos-12 == 550-12)return true;
				if(this.yPos-12 == 600-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
			}
			if(this.xPos-12 == 400-12) return false;
			if(this.xPos-12 == 500-12) {
				if(this.yPos-12 == 550-12)return true;
				if(this.yPos-12 == 600-12)return true;
				return false;
			}
			if(this.xPos-12 == 600-12) return false;
			if(this.xPos-12 == 700-12) {
				if(this.yPos-12 == 300-12)return true;
				if(this.yPos-12 == 450-12)return true;
				return false;
			}
			if(this.xPos-12 == 800-12) {
				if(this.yPos-12 == 50-12)return true;
				if(this.yPos-12 == 100-12)return true;
				if(this.yPos-12 == 150-12)return true;
				if(this.yPos-12 == 400-12)return true;
				if(this.yPos-12 == 550-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
			}
			if(this.xPos-12 == 900-12) {
				if(this.yPos-12 == 150-12)return true;
				if(this.yPos-12 == 400-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
			}
			
			if(this.xPos-12 == 50-12) {
				if(this.yPos-12 == 50-12)return true;
				if(this.yPos-12 == 300-12)return true;
				if(this.yPos-12 == 550-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
			}
			
			if(this.xPos-12 == 150-12) {
				if(this.yPos-12 == 150-12)return true;
				if(this.yPos-12 == 400-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
			}
			if(this.xPos-12 == 250-12) {
				if(this.yPos-12 == 150-12)return true;
				if(this.yPos-12 == 400-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
			}
			if(this.xPos-12 == 350-12) {
				if(this.yPos-12 == 300-12)return true;
				if(this.yPos-12 == 450-12)return true;
				return false;
			}
			if(this.xPos-12 == 450-12) return false;
			if(this.xPos-12 == 550-12) {
				if(this.yPos-12 == 50-12)return true;
				if(this.yPos-12 == 100-12)return true;
				if(this.yPos-12 == 150-12)return true;
				if(this.yPos-12 == 200-12)return true;
				return false;
			}
			if(this.xPos-12 == 650-12) return false;
			if(this.xPos-12 == 750-12) {
				if(this.yPos-12 == 50-12)return true;
				if(this.yPos-12 == 100-12)return true;
				if(this.yPos-12 == 150-12)return true;
				if(this.yPos-12 == 200-12)return true;
				if(this.yPos-12 == 250-12)return true;
				if(this.yPos-12 == 400-12)return true;
				if(this.yPos-12 == 500-12)return true;
				if(this.yPos-12 == 550-12)return true;
				if(this.yPos-12 == 600-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
			}
			if(this.xPos-12 == 850-12) {
				if(this.yPos-12 == 100-12)return true;
				if(this.yPos-12 == 150-12)return true;
				return false;
			}
			if(this.xPos-12 == 950-12) {
				if(this.yPos-12 == 50-12)return true;
				if(this.yPos-12 == 100-12)return true;
				if(this.yPos-12 == 400-12)return true;
				if(this.yPos-12 == 650-12)return true;
				return false;
			}
			
						
		return false;
	}
	
	// called when player eats a big dot.
	void SetCanDie(){
		pointsToComeAlive = GameClass.points + 1000;
		this.canDie = true;
		this.ChangeImage();
	}
	
	

}
