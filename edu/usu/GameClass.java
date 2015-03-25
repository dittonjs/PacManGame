package edu.usu;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.*;

//=====================================================
// THIS CLASS RUNS THE GAME. FOR EVERY NEW GAMEOBJECT CLASS WE WRITE 
// WE WILL NEED TO ADD AN INSTANCE OF THE OBJECT TO THE SECTION MENTIONED BELOW
// FOLLOW THE INSTRUCTIONS IN THE EXAMPLE PACMANOBJECT CLASS WHEN CREATING NEW CLASSES
//=====================================================

public class GameClass extends JPanel {
	static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	static ArrayList<GameObject> staticGameObjects = new ArrayList<GameObject>();
	

	
	// THIS CONTROLS THE PLAYER
	public GameClass(){
	addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				player.ChangeNextDirection(0);
			if(e.getKeyCode() == KeyEvent.VK_UP)
				player.ChangeNextDirection(1);
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				player.ChangeNextDirection(2);
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
				player.ChangeNextDirection(3);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	});
	
	AddWalls();
	makedots();
	setFocusable(true);
	}
	//int[] vXPos = {-13, 187, 687};
	//int[] vYPos = {0, 0, 100};
	int[] hXPos = { 0, 100, 200, 300, 400, 500, 600, 700};
	int[] hYPos = {-13, -13, -13, -13, -13, -13, -13, -13};
	
	// THIS FUNCTION IS TAKE THE ARRAYS ABOVE AND USES THE DATA TO ADD WALLS, ITS
	// DEFINETELY NOT DONE
	private void AddWalls(){
		/*for(int i = 0; i<3; i++){
				WallObject wall = new WallObject(true,vXPos[i],vYPos[i]);
		}*/
		for(int i = 0; i<hXPos.length; i++){
			WallObject wall = new WallObject(false,hXPos[i],hYPos[i]);
		}	
	}
	
	// THIS FUNCTION PLACES DOTS ALL OVER THE SCREEN
	private void makedots(){
		for(int i = 42; i < 800; i += 50){
			for(int j = 42; j < 600; j += 50){
				DotObject Dot = new DotObject(i,j);
			}
			
		}
	}
	//==============================================
	// THIS IS A LIST OF ALL OF THE GAME OBJECTS
	// - In the constructor for the object make sure that 
	// 	 It adds itself to the gameObject array list
	//==============================================
	public static PacManObject player = new PacManObject(400, 500, 1, false);
	//Ghost ghost1 = new Ghost();
	DebugGridClass degugGrid = new DebugGridClass();
	//==============================================
	//==============================================
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for(int i = 0; i<gameObjects.size(); i++){
			// THERE WILL NEED TO BE AN IF STATEMENT FOR EACH UDATING CLASS
			if(gameObjects.get(i).getClass() == PacManObject.class){
				PacManObject obj = (PacManObject)gameObjects.get(i);
				obj.PaintToScreen(g2d);
			}
			if(gameObjects.get(i).getClass() == Ghost.class){
				Ghost obj = (Ghost)gameObjects.get(i);
				obj.PaintToScreen(g2d);
			}
		}
		for(int i = 0; i<staticGameObjects.size(); i++){
			// THERE WILL NEED TO BE AN IF STATEMENT FOR EACH CLASS OF STATIC GAME OBJECTS
			if(staticGameObjects.get(i).getClass() == DebugGridClass.class){
				DebugGridClass obj = (DebugGridClass)staticGameObjects.get(i);
				obj.PaintToScreen(g2d);
			}
			if(staticGameObjects.get(i).getClass() == WallObject.class){
				WallObject obj = (WallObject)staticGameObjects.get(i);
				obj.PaintToScreen(g2d);
			}
			if(staticGameObjects.get(i).getClass() == DotObject.class){
				DotObject obj = (DotObject)staticGameObjects.get(i);
				obj.PaintToScreen(g2d);
			}
		}
	}
	
	//======================================================================
	// THE MAIN FUNCTION CREATES THE FRAME AND THEN ADD THE GAME PANEL
	// TO THE FRAME. IT ALSO CONTAINS THE MAIN GAME LOOP.
	// EACH TIME THE WHILE LOOP ITERATES, IT WILL LOOP THROUGH ALL OF THE NON-STATIC
	// GAME OBJECTS AND CALL THERE UPDATE METHOD
	// ONCE ALL OF THE OBJECTS HAVE UPDATE IT WILL REPAINT THEM TO THE SCREEN THEN WAIT FOR
	// 10 MILLISECONDS BEFORE CALLING THE NEXT LOOP
	//======================================================================
	
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame();
		GameClass game = new GameClass();
		frame.add(game);
		frame.setSize(800, 620);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		(new Thread(player)).start();
		while(true){
			for(int i=0; i< gameObjects.size(); i++){
				if(gameObjects.get(i).getClass() == PacManObject.class){
					PacManObject obj = (PacManObject)gameObjects.get(i);
					obj.Update();
				}
				if(gameObjects.get(i).getClass() == Ghost.class){
					Ghost obj = (Ghost)gameObjects.get(i);
					obj.Update();
				}
			}
			for(int i=0; i< staticGameObjects.size(); i++){
				if(staticGameObjects.get(i).getClass() == WallObject.class){
					WallObject obj = (WallObject)staticGameObjects.get(i);
					obj.Update();
				}
			}
			game.repaint();
			Thread.sleep(10);
		}
		
	}
}

