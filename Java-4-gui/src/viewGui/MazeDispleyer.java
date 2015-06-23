package viewGui;

import org.eclipse.swt.events.PaintEvent;

/**
 * Interface for maze displaying
 * @author Michael&Amit
 *
 */

public interface MazeDispleyer {
	void draw(PaintEvent e);
	int getRows();
	int getCols();
}
