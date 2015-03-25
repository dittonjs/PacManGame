package edu.usu;

import java.awt.Graphics2D;

public class Ghost extends GameObject{
	
	int speedX = 0;
	int speedY = 1;
	
	public Ghost(){
		
		this.OnEnable();
	}
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		//System.out.println("Ghost Updated");
		this.yPos += speedY;
	}

	@Override
	public void OnCollision(GameObject other) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnEnable() {
		// Constructor
		GameClass.gameObjects.add(this);
		this.xPos = 100;
		this.yPos = 100;
	}

	@Override
	public void OnDisable() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void PaintToScreen(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillRect(xPos, yPos, 50, 50);
	}
	
	

}
