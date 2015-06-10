package presenter;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Properties implements Serializable{
	private static final long serialVersionUID=1L;
	int numOfThreads;
	int numofBuildAlgorithm;
	int numOfSolveAlgorithm;
	void setSettings()
	{
		int temp = 0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter number of threads for the treadpool");
		numOfThreads=scan.nextInt();
		
		while(numOfThreads>0)
		{
			System.out.println("Please enter number of threads for the treadpool");
			numOfThreads=scan.nextInt();
		}
				
		boolean flag=false;
		while(flag==false)
		{
			System.out.println("please choose the maze builder algorithm\nFor DFS algorithm press 1\nFor Random algorithm press 2");
			temp=scan.nextInt();
		switch (temp) {
		case 1:
			numofBuildAlgorithm=1;
			flag=true;
			break;
		case 2:
			numofBuildAlgorithm=2;
			flag=true;
			break;
		default:
			System.out.println("WrongInput");
		}
		}
		
		flag=false;
		while(flag==false)
		{
			System.out.println("please choose the maze solve algorithm\nFor BFS algorithm press 1\nFor A STAR algorithm press 2");
			temp=scan.nextInt();
		switch (temp) {
		case 1:
			numOfSolveAlgorithm=1;
			flag=true;
			break;
		case 2:
			numOfSolveAlgorithm=2;
			flag=true;
			break;
		default:
			System.out.println("WrongInput");
		}
		}
		
	}
	public void inToXML()
	{
		XMLEncoder e;
		try {
			e = new XMLEncoder(new FileOutputStream("properties.xml"));
			e.writeObject(this);
			e.flush();
			e.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public int getNumOfThreads() {
		return numOfThreads;
	}
	public void setNumOfThreads(int numOfThreads) {
		this.numOfThreads = numOfThreads;
	}
	public int getNumofBuildAlgorithm() {
		return numofBuildAlgorithm;
	}
	public void setNumofBuildAlgorithm(int numofBuildAlgorithm) {
		this.numofBuildAlgorithm = numofBuildAlgorithm;
	}
	public int getNumOfSolveAlgorithm() {
		return numOfSolveAlgorithm;
	}
	public void setNumOfSolveAlgorithm(int numOfSolveAlgorithm) {
		this.numOfSolveAlgorithm = numOfSolveAlgorithm;
	}
	
}
