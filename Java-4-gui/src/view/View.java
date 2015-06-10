package view;

import java.util.HashMap;
import java.util.Observer;

import presenter.Presenter.Command;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

public interface View  { 
	Command getUserCommand(); 
	void displayMaze(Maze m); 
	void displaySolution(Solution s);
	void displaySuccess(String str);
	void setCommands(HashMap<String,Command> comm);
	void notifyArg(Object arg);
	void start(); 
	void setLastCommand(Command comm);
	void addobserver(Observer observer);

}
