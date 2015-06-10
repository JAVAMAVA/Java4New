package model;

import java.util.ArrayList;

import algorithms.mazeGenerators.Cell;
import algorithms.mazeGenerators.Maze;
import algorithms.search.MazeState;
import algorithms.search.Searchable;
import algorithms.search.State;

public class NewMazeDomain implements Searchable{
	Maze matrix;
	State startState;
	State goalState;
	private boolean diagonalRunning=false;
	
	public NewMazeDomain(Maze matrix) {
		this.matrix = matrix;
		this.startState = new State("(0,0");
		this.goalState = new State("("+(matrix.getRows()-1)+","+(matrix.getCols()-1)+")");
		
		
	}

	public State getStartState() {
		return startState;
	}

	public Maze getMatrix() {
		return matrix;
	}

	public void setMatrix(Maze matrix) {
		this.matrix = matrix;
	}

	/**
	 * the method reaches to the private parameter GoalState that presents the goal point of the maze
	 * @return goal point of the maze
	 * @Override 
	 */
	public State getGoalState() {
		return goalState;
	}
	/**
	 * The method gelAllPossibleStates checking all the possible next actions that can solve the problem
	 *@Override
	 *@param s is the state that we are trying to find his next possible ways 
	 *@return an ArrayList of all the possible states
	*/
	public ArrayList<State> getAllPossibleStates(State s) 
	{
		ArrayList<State> PStates=new ArrayList<State>();
		String temp=s.getState();
		State statetemp;
		String [] temps=temp.split("\\W");
		Cell tempDown=null,tempUp=null,tempLeft=null,tempRight=null;
		Cell c=matrix.getCell(Integer.parseInt(temps[1]), Integer.parseInt(temps[2]));
		
		if(c.getUp()==false)
		{
			String str="("+(Integer.parseInt(temps[1])-1)+","+(Integer.parseInt(temps[2]))+")";
			statetemp=new MazeState(str,s);
			statetemp.setCost(10+s.getCost());
			if(s.getCameFrom()!=null)
			{
			if(statetemp.getState().equals(s.getCameFrom().getState())==false)
			{
				PStates.add(statetemp);
				if(c.getRow()>0)
					tempUp=matrix.getCell(Integer.parseInt(temps[1])-1,Integer.parseInt(temps[2]));
			}
			}
			else
				{
				PStates.add(statetemp);
				if(c.getRow()>0)
					tempUp=matrix.getCell(Integer.parseInt(temps[1])-1,Integer.parseInt(temps[2]));
				}
		}
		if(c.getDown()==false)
		{
			String str="("+(Integer.parseInt(temps[1])+1)+","+(Integer.parseInt(temps[2]))+")";
			statetemp=new MazeState(str,s);
			statetemp.setCost(10+s.getCost());
			if(s.getCameFrom()!=null)
			{
			if(statetemp.getState().equals(s.getCameFrom().getState())==false)
			{
				PStates.add(statetemp);
				if(c.getRow()<matrix.getRows()-1)
					tempDown=matrix.getCell(Integer.parseInt(temps[1])+1, Integer.parseInt(temps[2]));
			
			}
			}
			else 
				{
					PStates.add(statetemp);
					if(c.getRow()<matrix.getRows()-1)
						tempDown=matrix.getCell(Integer.parseInt(temps[1])+1, Integer.parseInt(temps[2]));
				}
				
		}
		if(c.getLeft()==false)
		{
			String str="("+(Integer.parseInt(temps[1]))+","+(Integer.parseInt(temps[2])-1)+")";
			statetemp=new MazeState(str,s);
			statetemp.setCost(10+s.getCost());
			if(s.getCameFrom()!=null)
			{
			if(statetemp.getState().equals(s.getCameFrom().getState())==false)
			{
				PStates.add(statetemp);
				if(c.getCol()>0)
					tempLeft=matrix.getCell(Integer.parseInt(temps[1]), Integer.parseInt(temps[2])-1);
			
			}
			}
			else 
				{
				PStates.add(statetemp);
			if(c.getCol()>0)
				tempLeft=matrix.getCell(Integer.parseInt(temps[1]), Integer.parseInt(temps[2])-1);
			}
		}
		if(c.getRight()==false)
		{
			String str="("+(Integer.parseInt(temps[1]))+","+(Integer.parseInt(temps[2])+1)+")";
			statetemp=new MazeState(str,s);
			statetemp.setCost(10+s.getCost());
			if(s.getCameFrom()!=null)
			{
			if(statetemp.getState().equals(s.getCameFrom().getState())==false)
				PStates.add(statetemp);
			if(c.getCol()<matrix.getCols()-1)
				tempRight=matrix.getCell(Integer.parseInt(temps[1]), Integer.parseInt(temps[2])+1);
			}
			else 
				{
				PStates.add(statetemp);
				
			if(c.getCol()<matrix.getCols()-1)
				tempRight=matrix.getCell(Integer.parseInt(temps[1]), Integer.parseInt(temps[2])+1);
			}
		}
		if(this.getIfDiagonal()==true)
		{
			if (tempRight!=null && tempRight.getUp()==false ||tempUp!=null && tempUp.getRight()==false)
			{
			String str="("+(Integer.parseInt(temps[1])-1)+","+(Integer.parseInt(temps[2])+1)+")";
			statetemp=new MazeState(str,s);
			statetemp.setCost(15+s.getCost());
			if(s.getCameFrom()!=null)
			{
			if(statetemp.getState().equals(s.getCameFrom().getState())==false)
				PStates.add(statetemp);
			else 
					PStates.add(statetemp);
			}
			else PStates.add(statetemp);
			}
			if (tempRight!=null && tempRight.getDown()==false || tempDown!=null && tempDown.getRight()==false)
			{
			String str="("+(Integer.parseInt(temps[1])+1)+","+(Integer.parseInt(temps[2])+1)+")";
			statetemp=new MazeState(str,s);
			statetemp.setCost(15+s.getCost());
			if(s.getCameFrom()!=null)
			{
			if(statetemp.getState().equals(s.getCameFrom().getState())==false)
				PStates.add(statetemp);
			else 
					PStates.add(statetemp);
			}
			else PStates.add(statetemp);
			}
			if (tempDown!=null && tempDown.getLeft()==false || tempLeft!=null && tempLeft.getDown()==false)
			{
			String str="("+(Integer.parseInt(temps[1])+1)+","+(Integer.parseInt(temps[2])-1)+")";
			statetemp=new MazeState(str,s);
			statetemp.setCost(15+s.getCost());
			if(s.getCameFrom()!=null)
			{
			if(statetemp.getState().equals(s.getCameFrom().getState())==false)
				PStates.add(statetemp);
			else 
					PStates.add(statetemp);
			}
			else PStates.add(statetemp);
			}
			if (tempLeft!=null && tempLeft.getUp()==false || tempUp!=null && tempUp.getLeft()==false)
			{
			String str="("+(Integer.parseInt(temps[1])-1)+","+(Integer.parseInt(temps[2])-1)+")";
			statetemp=new MazeState(str,s);
			statetemp.setCost(15+s.getCost());
			if(s.getCameFrom()!=null)
			{
			if(statetemp.getState().equals(s.getCameFrom().getState())==false)
				PStates.add(statetemp);
			else 
					PStates.add(statetemp);
			}
			else PStates.add(statetemp);
			}
		}
		return PStates;
		}
	/**
	 * The method getIfDiagonal returns if the algorithms considerate diagonal movements
	 * @return true if the the algorithm uses diagonal check, return false if not
	 * @Override
	 */
	public boolean getIfDiagonal()
	 {
		 return this.diagonalRunning;
	 }
	/**
	 * The method setDiagonal allow the user to choose if to solve the problem with diagonal check or not
	 * @Override
	 * @param diagonal -true if the user wants to solve the problem with diagonal check, false if not
	 */
	public void setDiagnonal(boolean diagonal)
	{
		this.diagonalRunning=diagonal;
	}

}
