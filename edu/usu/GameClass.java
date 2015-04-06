package edu.usu;
import java.awt.Color;
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
	this.setBackground(Color.GRAY);
	
	//makedots();
	AddWalls();
	setFocusable(true);
	}
	//int[] vXPos = {-13, 187, 687};
	//int[] vYPos = {0, 0, 100};
	int[] hXPos = { 0, 100, 200, 300, 400, 500, 600, 700,800,900};
	int[] hYPos = {12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
	int[] hXPos2 = { 0, 100, 200, 300, 400, 500, 600, 700, 800, 900};
	int[] hYPos2 = {662, 662, 662, 662, 662, 662, 662, 662, 662, 662};
	int[] hXPos3 = {75,175,325,425,575,675,825};
	int[] hYPos3 = {62, 62, 62, 62, 62, 62, 62};
	int[] hXPos4 = {112,162,212};
	int[] hYPos4 = {112, 162, 112};
	int[] hXPos5 = {762,812,862};
	int[] hYPos5 = {112, 162, 112};
	int[] hXPos6 = {325,425,525,625, 325,425,525,625,325,425,525,625};
	int[] hYPos6 = {112, 112, 112, 112, 212, 212, 212, 212, 262, 262, 262, 262};
	int[] hXPos7 = {312, 362,412,462, 562,612,662, 312, 362,412,462, 562,612,662};
	int[] hYPos7 = {162, 162, 162, 162, 162, 162, 162, 462, 462, 462, 462, 462, 462, 462};
	int[] hXPos8 = {362, 412, 462, 512, 562, 612};
	int[] hYPos8 = { 312, 312, 312, 312, 312, 312};
	int[] hXPos9 = {362, 412 ,462, 562, 612};
	int[] hYPos9 = {412, 412, 412, 412, 412};
	int[] hXPos10 = {325,425,525,625, 325,425,525,625};
	int[] hYPos10 = {512, 512, 512, 512, 612, 612, 612, 612};
	int[] hXPos11 = {312, 362,412,512, 562,612,662};
	int[] hYPos11 = {562, 562, 562, 562, 562, 562, 562};
	int[] vXPos = {12,12,12,12,12,12,12};
	int[] vYPos = {0,100,200,300,400,500,600,700};
	int[] vXPos2 = {962,962,962,962,962,962,962};
	int[] vYPos2 = {0,100,200,300,400,500,600,700};
	int[] vXPos3 = {62,62,62,62,62};
	int[] vYPos3 = {75,175,325,425,575};
	int[] vXPos4 = {112,112,112,112,112};
	int[] vYPos4 = {125,175,275,425,525};
	int[] vXPos5 = {262,262,262,262,262};
	int[] vYPos5 = {125,175,275,425,525};
	int[] vXPos6 = {162,162,212,212};//
	int[] vYPos6 = {175,275,175,275};//
	int[] vXPos7 = {162,162,212,212};//
	int[] vYPos7 = {425,525,425,525};// 
	int[] vXPos8 = {812,812,862,862};//
	int[] vYPos8 = {175,275,175,275};//
	int[] vXPos9 = {812,812,862,862};//
	int[] vYPos9 = {425,525,425,525};//
	int[] vXPos10 = {762,762,762,762,762};
	int[] vYPos10 = {125,175,275,425,525};
	int[] vXPos11 = {912,912,912,912,912};
	int[] vYPos11 = {125,175,275,425,525};
	int[] vXPos12 = {312,312,712,712};
	int[] vYPos12 = {275,375,275,375};
	//int[] hYPos2 = {}
	
	// THIS FUNCTION IS TAKE THE ARRAYS ABOVE AND USES THE DATA TO ADD WALLS, ITS
	// DEFINETELY NOT DONE
	private void AddWalls(){
		/*for(int i = 0; i<3; i++){
				WallObject wall = new WallObject(true,vXPos[i],vYPos[i]);
		}*/
		for(int i = 0; i<hXPos.length; i++){
			WallObject wall = new WallObject(false, true, hXPos[i],hYPos[i]);
		}
		for(int i = 0; i<hXPos2.length; i++){
			WallObject wall = new WallObject(false, true, hXPos2[i],hYPos2[i]);
		}
		for(int i = 0; i<hXPos3.length; i++){
			WallObject wall = new WallObject(false, true, hXPos3[i],hYPos3[i]);
		}
		for(int i = 0; i<hXPos4.length; i++){
			WallObject wall = new WallObject(false, false, hXPos4[i],hYPos4[i]);
		}
		for(int i = 0; i<hXPos5.length; i++){
			WallObject wall = new WallObject(false, false, hXPos5[i],hYPos5[i]);
		}
		for(int i = 0; i<hXPos6.length; i++){
			WallObject wall = new WallObject(false, true, hXPos6[i],hYPos6[i]);
		}
		for(int i = 0; i<vXPos12.length; i++){
			WallObject wall = new WallObject(true, true, vXPos12[i],vYPos12[i]);
		}
		for(int i = 0; i<hXPos7.length; i++){
			WallObject wall = new WallObject(false, false, hXPos7[i],hYPos7[i]);
		}
		 
		
		for(int i = 0; i<hXPos8.length; i++){
			WallObject wall = new WallObject(false, false, hXPos8[i],hYPos8[i]);
		}
		WallObject hcwall7 = new WallObject(true, true, 512, 325);
		WallObject hcwall8 = new WallObject(true, true, 562, 325);
		WallObject hcwall9 = new WallObject(true, true, 362, 325);
		WallObject hcwall10 = new WallObject(true, true, 662, 325);
		for(int i = 0; i<hXPos9.length; i++){
			WallObject wall = new WallObject(false, false, hXPos9[i],hYPos9[i]);
		}
		for(int i = 0; i<hXPos10.length; i++){
			WallObject wall = new WallObject(false, true, hXPos10[i],hYPos10[i]);
		}
		for(int i = 0; i<hXPos11.length; i++){
			WallObject wall = new WallObject(false, false, hXPos11[i],hYPos11[i]);
		}
		for(int i = 0; i<vXPos.length; i++){
			WallObject wall = new WallObject(true, true, vXPos[i],vYPos[i]);
		}
		for(int i = 0; i<vXPos2.length; i++){
			WallObject wall = new WallObject(true, true, vXPos2[i],vYPos2[i]);
		}
		for(int i = 0; i<vXPos3.length; i++){
			WallObject wall = new WallObject(true, true, vXPos3[i],vYPos3[i]);
		}
		for(int i = 0; i<vXPos4.length; i++){
			WallObject wall = new WallObject(true, true, vXPos4[i],vYPos4[i]);
		}
		for(int i = 0; i<vXPos5.length; i++){
			WallObject wall = new WallObject(true, true, vXPos5[i],vYPos5[i]);
		}
		for(int i = 0; i<vXPos6.length; i++){
			WallObject wall = new WallObject(true, true, vXPos6[i],vYPos6[i]);
		}
		WallObject hcwall1 = new WallObject(false, false, 162, 362);
		WallObject hcwall2 = new WallObject(false, false, 162, 412);
		for(int i = 0; i<vXPos7.length; i++){
			WallObject wall = new WallObject(true, true, vXPos7[i],vYPos7[i]);
		}
		WallObject hcwall3 = new WallObject(false, false, 162, 612);
		for(int i = 0; i<vXPos8.length; i++){
			WallObject wall = new WallObject(true, true, vXPos8[i],vYPos8[i]);
		}
		WallObject hcwall4 = new WallObject(false, false, 812, 362);
		WallObject hcwall5 = new WallObject(false, false, 812, 412);
		for(int i = 0; i<vXPos9.length; i++){
			WallObject wall = new WallObject(true, true, vXPos9[i],vYPos9[i]);
		}
		WallObject hcwall6 = new WallObject(false, false, 812, 612);
		for(int i = 0; i<vXPos10.length; i++){
			WallObject wall = new WallObject(true, true, vXPos10[i],vYPos10[i]);
		}
		for(int i = 0; i<vXPos11.length; i++){
			WallObject wall = new WallObject(true, true, vXPos11[i],vYPos11[i]);
		}
	}
	
	// THIS FUNCTION PLACES DOTS ALL OVER THE SCREEN
	private void makedots(){

		for(int i = -4; i < 1000; i += 25){
			for(int j = -4; j < 800; j += 25){

				//DotObject Dot = new DotObject(i,j);
			}
			
		}
	}
	//==============================================
	// THIS IS A LIST OF ALL OF THE GAME OBJECTS
	// - In the constructor for the object make sure that 
	// 	 It adds itself to the gameObject array list
	//==============================================
	public static PacManObject player = new PacManObject(400, 500, 1, false);
	public static WallObject finalWall = new WallObject(false,false, 512,412);
	public static Ghost ghost1 = new Ghost(100,100,1);
	public static Ghost ghost2 = new Ghost(100,200,2);
	public static Ghost ghost3 = new Ghost(100,300,3);
	public static Ghost ghost4 = new Ghost(950,100,1);
	public static Ghost ghost5 = new Ghost(950,200,2);
	public static Ghost ghost6 = new Ghost(950,300,3);
	public static Ghost ghost7 = new Ghost(100,400,1);
	public static Ghost ghost8 = new Ghost(100,500,2);
	public static Ghost ghost9 = new Ghost(100,600,3);
	public static Ghost ghost10 = new Ghost(950,400,1);
	public static Ghost ghost11 = new Ghost(950,500,2);
	public static Ghost ghost12 = new Ghost(950,600,3);
	DebugGridClass degugGrid = new DebugGridClass();
	//==============================================
	//==============================================
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i = 0; i<staticGameObjects.size(); i++){
			// THERE WILL NEED TO BE AN IF STATEMENT FOR EACH CLASS OF STATIC GAME OBJECTS
			if(staticGameObjects.get(i).getClass() == DebugGridClass.class){
				DebugGridClass obj = (DebugGridClass)staticGameObjects.get(i);
				obj.PaintToScreen(g2d);
			}
			if(staticGameObjects.get(i).getClass() == DotObject.class){
				DotObject obj = (DotObject)staticGameObjects.get(i);
				obj.PaintToScreen(g2d);
			}
			if(staticGameObjects.get(i).getClass() == WallObject.class){
				WallObject obj = (WallObject)staticGameObjects.get(i);
				obj.PaintToScreen(g2d);
			}
		}
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
		frame.setSize(1000, 800);

		//game.setBackground(Color.black);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//(new Thread(player)).start();
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

