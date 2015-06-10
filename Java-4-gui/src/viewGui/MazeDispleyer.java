package viewGui;

import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze;

/**
 * Interface for maze displaying
 * @author Michael&Amit
 *
 */

public interface MazeDispleyer {
	public void display(Maze matrix,Composite parent);

}
