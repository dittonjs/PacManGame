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
		// TODO Auto-generated method stub
		if(Math.abs(this.xPos - GameClass.player.xPos) < 100 && Math.abs(this.yPos - GameClass.player.yPos) < 50){
			if(this.CheckPlayerCollision()){
				
				
				GameClass.player.OnCollision(this);
			}
		}
	}

	@Override
	public void OnCollision(GameObject other) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnEnable() {
		// TODO Auto-generated method stub
		if(this.isBig)
			size = 16;
		else size = 8;
		
		GameClass.staticGameObjects.add(this);
		
	}

	@Override
	public void OnDisable() {
		// TODO Auto-generated method stub
		GameClass.staticGameObjects.remove(this);
		
	}

	@Override
	public void PaintToScreen(Graphics2D g) {
		// TODO Auto-generated method stub
		if(!this.isBig)
		g.fillOval(this.xPos, this.yPos, size, size);
		else g.fillOval(this.xPos -8, this.yPos - 8, this.size, this.size);
		
		g.setColor(Color.YELLOW);
		
		//g.drawimage(",",//image to draw)
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.xPos, this.yPos, this.size, this.size);
	}
	
	public boolean CheckPlayerCollision(){
		if(this.getBounds().intersects(GameClass.player.getBounds()))
			GameClass.player.OnCollision(this);
		return false;
	}

}
