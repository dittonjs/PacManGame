package edu.usu;

import java.awt.Graphics2D;

public class DotObject extends GameObject {
	
	public DotObject(int x, int y){
		this.xPos = x;
		this.yPos = y;
		this.OnEnable();
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnCollision(GameObject other) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnEnable() {
		// TODO Auto-generated method stub
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
		g.fillOval(this.xPos, this.yPos, 8, 8);
		//g.drawimage(",",//image to draw)
	}

}
