package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.Link;

import presenter.Presenter.Command;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import model.Model;
import view.View;
/**
 * Presenter is the the class that runs every command and control the actions. It has a {@link View} and a {@link Model} that i controls on.
 * The class implements {@link Observer} and that means it gets notifications from the {@link View} and the {@link Model}
 * @author Michael & Amit
 * @param v the view 
 * @param m the model
 * @param comm the commands hashmap
 */
public class Presenter implements Observer {
	View v;
	Model m;
	HashMap<String,Command> comm=new HashMap<String, Command>();
	public HashMap<String, Command> hm;
	public Presenter(View v,Model m) {
		this.v=v;
		this.m=m;
		this.setCommands();
		
	}
	public void setCommands()
	{
		comm.put("generate maze",new GenerateMazeCommand());
		comm.put("display maze", new DisplayMazeCommand());
		comm.put("solve maze", new SolveMazeCommand());
		comm.put("display solution", new DisplaySolutionCommand());
		comm.put("exit", new ExitCommand());
		v.setCommands(comm);
	}
	/**
	 * this method overrides the update method from {@link Observer} 
	 * this method is the main method that controls the traffic between the model and the view
	 */
	@Override
	public void update(Observable o, Object args) {
			//if the view notified the presenter
 		   if(o == v) {
			   if((String)args=="start")
			   {
				   v.setCommands(comm);
				   v.displaySuccess("done");
			   }
			   else if((String)args=="exit")
			   {
					Command newComm=new ExitCommand();
					newComm.doCommand((String)args);
			   }
			   else 
			   {
				   
				   Command newComm=v.getUserCommand();
				   newComm.doCommand((String)args);
				   v.displaySuccess("done");
			   }
		   }
		   
		   //if the model notified the presenter
		   if(o == m) {
			   switch((String)args)
			   {
			   case "Maze was found":
				   v.displayMaze(m.getMaze());
				   break;
			   case "Maze was not found":
				   v.displaySuccess((String)args);
				   break;
			   case "Solution was found":
			   		v.displaySolution(m.getSolution((String)args));
			   		break;
			   case "Solution was not found":
				   v.displaySuccess((String)args);
				   break;
			   case "Maze generated":
				   v.displaySuccess((String)args);
				   v.displayMaze(m.getMaze());
				   break;
			   case "Maze already exists":
				   v.displaySuccess((String)args);
				   break;
			   }
		   }
		}

	public interface Command {
		void doCommand(String arg);
	}
	/**
	 * {@link GenerateMazeCommand} is called when the view sends a generate maze command
	 *
	 */
	public class GenerateMazeCommand implements Command {

		@Override
		public void doCommand(String arg) {
			String[] commands=arg.split(" ");
			//check input
			m.generateMaze(commands[0],/*Integer.parseInt(commands[1]),Integer.parseInt(commands[2])*/10,10);
			v.displaySuccess("maze"+commands[0]+" is ready");
		}

	}
	/**
	 *{@link DisplayMazeCommand} is called when the display maze command is triggered 
	 *
	 */
	public class DisplayMazeCommand implements Command
	{

		@Override
		public void doCommand(String arg) {
			m.getMazeInModel(arg);
			
		}
		
	}
	/**
	 * {@link SolveMazeCommand} gets a solution from the model to the view when the solve maze command is triggered
	 *
	 */
	public class SolveMazeCommand implements Command
	{

		@Override
		public void doCommand(String arg) {
			m.solveMaze(arg);
			v.displaySuccess("solution for "+arg+" is ready");
			
		}
	}
	/**
	 * {@link DisplaySolutionCommand} asks for a maze solution when the get solution command is triggered 
	 */
	public class DisplaySolutionCommand implements Command
	{

		@Override
		public void doCommand(String arg) {
			m.getSolutionInModel(arg);
			
		}
		
	}
	/**
	 * {@link ExitCommand} is called when the user wants to terminate the program
	 */
	public class ExitCommand implements Command
	{

		@Override
		public void doCommand(String arg) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}



