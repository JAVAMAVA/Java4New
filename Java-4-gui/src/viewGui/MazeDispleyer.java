package viewGui;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

/**
 * Interface for maze displaying
 * @author Michael&Amit
 *
 */

public interface MazeDispleyer {
	void draw(PaintEvent e);
	void drawSol(GC gc, Solution sol);
	void undrawSol(GC gc, Solution sol);
	Object getTile(int i,int j);
	int getRows();
	int getCols();
}
