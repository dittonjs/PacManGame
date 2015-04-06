package edu.usu;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WallObject extends GameObject{
	
	private boolean vertical;
	private int sizeX, sizeY;
	private boolean bigOrSmall;
	private Image up50;
	private Image up100;
	private Image hor50;
	private Image hor100;
	
	public WallObject(boolean vert, boolean bos, int x, int y){
		try{
            File image1 = new File("VertWall50.png");
            File image2 = new File("VertWall100.png");
            File image3 = new File("HoriWall50.png");
            File image4 = new File("HoriWall100.png");
            up50 = ImageIO.read(image1);
            up100 = ImageIO.read(image2);
            hor50 = ImageIO.read(image3);
            hor100 = ImageIO.read(image4);
        }
        catch (IOException e){
            e.printStackTrace();
        }
		this.xPos = x;
		this.yPos = y;
		this.bigOrSmall = bos;
		this.vertical = vert;
		this.OnEnable();
	} 
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		if(Math.abs(this.xPos-GameClass.player.xPos) < 100 && Math.abs(this.yPos-GameClass.player.yPos)<100){
			if(IsColliding()){
			GameClass.player.OnCollision(this);
			}
		}
		if(this.IsCollidingGhost() != -1){
			this.GhostCollisionCall(this.IsCollidingGhost());
		}
	}

	@Override
	public void OnCollision(GameObject other) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnEnable() {
		// TODO Auto-generated method stub
		
		if(vertical){
			this.sizeX = 26;
			
			if(bigOrSmall){
				
				this.sizeY = 100;
				this.visRep = up100;
			}
			else{ 
				System.out.println("What the heck");
				this.sizeY = 50;
				this.visRep = up50;
			}
		} else {
			this.sizeY = 26;
			
			if(bigOrSmall){
				this.sizeX = 100;
				this.visRep = hor100;
			}
			else{
				System.out.println("What the heck this is weird");
				this.sizeX=50;
				this.visRep = hor50;
			}
		}
		GameClass.staticGameObjects.add(this);
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
	
	int IsCollidingGhost(){
		if(GameClass.ghost1.getBounds().intersects(this.getBounds())) return 1;
		if(GameClass.ghost2.getBounds().intersects(this.getBounds())) return 2;
		if(GameClass.ghost3.getBounds().intersects(this.getBounds())) return 3;
		if(GameClass.ghost4.getBounds().intersects(this.getBounds())) return 4;
		if(GameClass.ghost5.getBounds().intersects(this.getBounds())) return 5;
		if(GameClass.ghost6.getBounds().intersects(this.getBounds())) return 6;
		if(GameClass.ghost7.getBounds().intersects(this.getBounds())) return 7;
		if(GameClass.ghost8.getBounds().intersects(this.getBounds())) return 8;
		if(GameClass.ghost9.getBounds().intersects(this.getBounds())) return 9;
		if(GameClass.ghost10.getBounds().intersects(this.getBounds())) return 10;
		if(GameClass.ghost11.getBounds().intersects(this.getBounds())) return 11;
		if(GameClass.ghost12.getBounds().intersects(this.getBounds())) return 12;
		return -1;
	}
	
	void GhostCollisionCall(int a){
		switch(a){
		case 1:
			GameClass.ghost1.OnCollision(this);
			break;
		case 2:
			GameClass.ghost2.OnCollision(this);
			break;
		case 3:
			GameClass.ghost3.OnCollision(this);
			break;
		case 4:
			GameClass.ghost4.OnCollision(this);
			break;
		case 5:
			GameClass.ghost5.OnCollision(this);
			break;
		case 6:
			GameClass.ghost6.OnCollision(this);
			break;
		case 7:
			GameClass.ghost7.OnCollision(this);
			break;
		case 8:
			GameClass.ghost8.OnCollision(this);
			break;
		case 9:
			GameClass.ghost9.OnCollision(this);
			break;
		case 10:
			GameClass.ghost10.OnCollision(this);
			break;
		case 11:
			GameClass.ghost11.OnCollision(this);
			break;
		case 12:
			GameClass.ghost12.OnCollision(this);
			break;
		
		}
		
	}
	public Rectangle getBounds() {
		return new Rectangle(this.xPos, this.yPos, this.sizeX , this.sizeY);
	}
	@Override
	public void PaintToScreen(Graphics2D g) {
		// TODO Auto-generated method stub
		if(this.vertical){
			g.drawImage(visRep, this.xPos, this.yPos - 12, null);
		}
		else{
			if(this.bigOrSmall)
			g.drawImage(visRep, this.xPos -12, this.yPos, null);
			else{
				g.drawImage(visRep, this.xPos, this.yPos, null);
			}
		}
			
	}
	
}
