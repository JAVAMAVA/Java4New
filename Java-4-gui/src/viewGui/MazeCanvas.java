package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze;
/**
 * this class representing a maze cell via extending {@link Canvas}
 * 
 * @author Michael & Amit
 *
 */



public class MazeCanvas extends Canvas {
	Maze maze;
	
	public MazeCanvas(MyBoard board/*Maze maze*/,int style,String side,Shell shell,Display display) {
		super(board, style);
		this.maze=maze;
		//this = new Canvas(shell, SWT.NONE);
		//setBackground(new Color(device, red, green, blue));
		addPaintListener(new PaintListener() {
			@Override
			  public void paintControl(PaintEvent e) {
			        //for(int i=0;i<MazeCanvas.this.maze)
			    
			    }
			  });
		}
}
