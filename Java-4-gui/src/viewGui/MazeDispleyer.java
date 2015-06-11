package viewGui;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze;

/**
 * Interface for maze displaying
 * @author Michael&Amit
 *
 */

public interface MazeDispleyer {
	public void display(PaintEvent maze);
	public void displaySol(PaintEvent maze);
}
