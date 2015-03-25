package edu.usu;

import java.awt.Image;

//=====================================================
// THIS IS THE BASE GAMEOBJECT CLASS. IT USES THE THE GAMECONTROL INTERFACE.
// ALL GAME OBJECT CHILD CLASSES WILL NEED TO IMPLEMENT ALL THE GAMECONTROL FUNCTIONS
// A DISCRIPTION OF WHAT EACH FUNCTION DOES CAN BE FOUND IN THE GAMECONTROL.JAVA FILE
//=====================================================

public abstract class GameObject implements GameControl {
	protected int xPos; // THE OBJECTS X POSITION
	protected int yPos; // THE OBJECTS Y POSITION
    protected int direction; // THE OBJECTS DIRECTION LEFT: 0, UP: 1, RIGHT:2, DOWN:3
	protected boolean isStatic; // A BOOLEAN THAT IS TRUE IF THE OBJECT WILL NEVER MOVE
	protected Image visRep; // THE IMAGE THAT REPRESENTS THIS OBJECT
}
