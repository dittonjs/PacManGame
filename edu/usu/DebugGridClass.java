package edu.usu;

import java.awt.Graphics2D;

//===========================================
// THIS CLASS JUST LAYS OUT A GRID ON THE SCREEN SO WE CAN PLACE ALL 
// OUR IMAGES IN THE RIGHT PLACES
//===========================================


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
		g.drawLine(100, 0, 100, 600);
		g.drawLine(200, 0, 200, 600);
		g.drawLine(300, 0, 300, 600);
		g.drawLine(400, 0, 400, 600);
		g.drawLine(500, 0, 500, 600);
		g.drawLine(600, 0, 600, 600);
		g.drawLine(700, 0, 700, 600);
		//HORIZONTAL GRID
		g.drawLine(0, 100, 800, 100);
		g.drawLine(0, 200, 800, 200);
		g.drawLine(0, 300, 800, 300);
		g.drawLine(0, 400, 800, 400);
		g.drawLine(0, 500, 800, 500);

	}
	
}
