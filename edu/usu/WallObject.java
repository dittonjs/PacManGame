package edu.usu;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class WallObject extends GameObject{
	
	private boolean vertical;
	private int sizeX, sizeY;
	
	public WallObject(boolean vert, int x, int y){
		this.xPos = x;
		this.yPos = y;
		this.vertical = vert;
		this.OnEnable();
	} 
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		if(IsColliding()){
			GameClass.player.OnCollision(this);
		}
	}

	@Override
	public void OnCollision(GameObject other) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnEnable() {
		// TODO Auto-generated method stub
		GameClass.staticGameObjects.add(this);
		if(vertical){
			this.sizeX = 26;
			this.sizeY = 100;
		} else {
			this.sizeX = 100;
			this.sizeY = 26;
		}
	}

	@Override
	public void OnDisable() {
		// TODO Auto-generated method stub
		
	}
	
	boolean IsColliding(){
		if(GameClass.player.getBounds().intersects(this.getBounds())){
			return true;
		}
		return false;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.xPos - 13, this.yPos -13, this.sizeX+26 , this.sizeY+26);
	}
	@Override
	public void PaintToScreen(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillRect(xPos, yPos, sizeX, sizeY);
	}
	
}
