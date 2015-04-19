package edu.usu;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DataSaver {
	
	public File highScoreFile;
	public int highScore;
	
	public DataSaver(String fileName){
		try{
			this.highScoreFile = new File(fileName);
			Scanner scanner = new Scanner(this.highScoreFile);
			highScore = scanner.nextInt();
			scanner.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void Save(int score){
		try{
			FileWriter writer = new FileWriter(this.highScoreFile, false);
			writer.write(""+score);
			writer.close();
		} catch(Exception e){
			e.printStackTrace();
		}	
	}
	
}
