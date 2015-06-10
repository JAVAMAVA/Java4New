package view;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import presenter.Presenter.Command;
import viewGui.MazeDispleyer;
import viewGui.MyMazeDispleyer;
/**
 * {@link MyView} extends {@link Observable} implements {@link View} is the view in the MVP pattern
 * @author Michael&Amit
 * @see Observable 
 * @see View
 *
 */

public class MyView extends Observable implements View {
	
	HashMap<String, Command> comm=new HashMap<String,Command>();
	public Command lastcommand;
	MyCLI c;
	public MyView() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		c=new MyCLI(reader,writer,this);
	}
	@Override
	public void addobserver(Observer observer)
	{
		this.addObserver(observer);
	}
	/**
	 * start method is the main method inside {@link MyView} 
	 * the method gets commands and notifies the observer
	 */
	@Override
	public void start()
	{
		setChanged();
		notifyObservers("start");
		c.start();
		//if(comm.get(str)!=null)
			//lastcommand=comm.get(str);
		//else this.notifyArg(str);
		
	}
	@Override
	public void notifyArg(Object arg) {
		setChanged();
		notifyObservers(arg);
		
	}
	/**
	 * setCommands sets a command from the hashmap to the current command
	 */
	@Override
	public void setCommands(HashMap<String, Command> comm) {
		this.comm=comm;
		c.hm=comm;
		
	}
	/**
	 * getUserCommands gets the last command the user entered
	 */	
	@Override
	public Command getUserCommand() {
		return this.lastcommand;
	}
	/**
	 * displayMaze builds and instance of {@link MyMazeDispleyer} and displays the maze to the console
	 */
	@Override
	public void displayMaze(Maze m) {
		MazeDispleyer MD=new MyMazeDispleyer();
		MD.display(m);
		
	}
	/**
	 * displaySolution gets a solution and prints it to the console
	 */
	@Override
	public void displaySolution(Solution s) {
		s.printSolution();
		
	}
	/**
	 * displaySuccess prints to the screen a string it gets
	 */
	@Override
	public void displaySuccess(String str) {
		System.out.println(str);
		
	}
	/**
	 * setLastCommand saces the last command the user entered inside the view
	 */
	@Override
	public void setLastCommand(Command comm) {
		this.lastcommand=comm;
		
	}


}
