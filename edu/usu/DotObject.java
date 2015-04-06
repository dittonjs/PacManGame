package edu.usu;

import java.awt.Color;
import java.awt.Graphics2D;

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
		g.fillOval(this.xPos, this.yPos, 8, 8);
		g.setColor(Color.YELLOW);
		
		//g.drawimage(",",//image to draw)
	}

}
