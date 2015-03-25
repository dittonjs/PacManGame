package edu.usu;

import java.awt.Graphics2D;

//===========================================
// THIS CLASS JUST LAYS OUT A GRID ON THE SCREEN SO WE CAN PLACE ALL 
// OUR IMAGES IN THE RIGHT PLACES
//===========================================
//this is a comment

public class DebugGridClass extends GameObject {
	public DebugGridClass(){
		this.OnEnable();
	}
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		// do nothing
	}

	@Override
	public void OnCollision(GameObject other) {
		// TODO Auto-generated method stub
		// do nothing
	}

	@Override
	public void OnEnable() {
		// TODO Auto-generated method stub
		GameClass.staticGameObjects.add(this);
	}

	@Override
	public void OnDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PaintToScreen(Graphics2D g) {
		// TODO Auto-generated method stub
		//VERTICAL GRID
		g.drawLine(100, 0, 100, 800);
		g.drawLine(200, 0, 200, 800);
		g.drawLine(300, 0, 300, 800);
		g.drawLine(400, 0, 400, 800);
		g.drawLine(500, 0, 500, 800);
		g.drawLine(600, 0, 600, 800);
		g.drawLine(700, 0, 700, 800);
		g.drawLine(800, 0, 800, 800);
		g.drawLine(900, 0, 900, 800);
		
		g.drawLine(50, 0, 50, 800);
		g.drawLine(150, 0, 150, 800);
		g.drawLine(250, 0, 250, 800);
		g.drawLine(350, 0, 350, 800);
		g.drawLine(450, 0, 450, 800);
		g.drawLine(550, 0, 550, 800);
		g.drawLine(650, 0, 650, 800);
		g.drawLine(750, 0, 750, 800);
		g.drawLine(850, 0, 850, 800);
		g.drawLine(950, 0, 950, 800);
		
		//HORIZONTAL GRID
		g.drawLine(0, 100, 1000, 100);
		g.drawLine(0, 200, 1000, 200);
		g.drawLine(0, 300, 1000, 300);
		g.drawLine(0, 400, 1000, 400);
		g.drawLine(0, 500, 1000, 500);
		g.drawLine(0, 600, 1000, 600);
		g.drawLine(0, 700, 1000, 700);
		
		g.drawLine(0, 50, 1000, 50);
		g.drawLine(0, 150, 1000, 150);
		g.drawLine(0, 250, 1000, 250);
		g.drawLine(0, 350, 1000, 350);
		g.drawLine(0, 450, 1000, 450);
		g.drawLine(0, 550, 1000, 550);
		g.drawLine(0, 650, 1000, 650);
		g.drawLine(0, 750, 1000, 750);

	}
	
}
