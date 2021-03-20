package jellyfish.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jellyfish.Direction;
import jellyfish.FishPosition;
import jellyfish.JellyFish;
import jellyfish.JellyFishTank;
import jellyfish.Position;

public class TestJellyFishProject {

	public static void main(String args[])
	{
		// read input file
		File inputFile=new File("Input.txt");
		File outputFile=new File("Output.txt");
		String outputString="";
		try {
			BufferedReader br=new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw=new BufferedWriter(new FileWriter(outputFile));
			String str=br.readLine();
			if(str!=null)
			{
				//1st line is for tank top right co-od
				if(str.length()==2)
				{
					int xCood=Integer.parseInt(str.substring(0,1));
					int yCood=Integer.parseInt(str.substring(1,2));
					JellyFishTank.setTopRightPosition(new Position(xCood,yCood));
					
				}
				else 
				{
					System.out.println("Invalid input format please specify x and y co-ordinates ranging from 0-9. \nx co-ordinate should be followed by y co-ordinate without any space. \nEg. 53 in input infers x cood=5, y cood=3");
				}
			}
			str=br.readLine();
			//System.out.println("str="+str);
			//for each jelly fish 1ine to specify position and instruction
			while(str!=null)
			{
				//System.out.println("str="+str);
				if(str.contains(" "))
				{
					// position and instruction is space delimited
					String jellyFishLine[]=str.split(" ");
					FishPosition pos = null;
					if(jellyFishLine[0].length()==3)
					{
						int xCood=Integer.parseInt(str.substring(0,1));
						int yCood=Integer.parseInt(str.substring(1,2));
						Direction orientation=Direction.valueOf(jellyFishLine[0].substring(2));
						pos=new FishPosition(xCood, yCood, orientation);
					}
					JellyFish jellyFish=new JellyFish(pos, jellyFishLine[1]);
					jellyFish.move();
					if(outputString=="")
						outputString=outputString+jellyFish;
					else
						outputString=outputString+"\n"+jellyFish;
					//System.out.println(jellyFish);
					
				}
				
				str=br.readLine();
			}
			// write to output file
			bw.write(outputString);
			bw.flush();
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
