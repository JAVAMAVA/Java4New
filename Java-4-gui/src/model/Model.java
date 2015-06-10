package model;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MazeGenerator;
import algorithms.search.Solution;

public interface Model {
	void solveMaze(String name); 
	Solution getSolution(String name); 
	void stop();
	Maze getMaze();
	void getMazeInModel(String arg);
	void getSolutionInModel(String arg);
	public void saveToFile();
	public void readFromFile();
	void generateMaze(String name, int rows, int cols );

}
