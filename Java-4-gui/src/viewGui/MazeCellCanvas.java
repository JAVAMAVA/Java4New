package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
/**
 * this class representing a maze cell via extending {@link Canvas}
 * 
 * @author Michael & Amit
 *
 */



public class MazeCellCanvas extends Canvas {
	String side;
	
	
	public MazeCellCanvas(MyBoard Board, int style,String side,Shell shell,Display display) {
		super(Board, style);
		this.side=side;
		//this = new Canvas(shell, SWT.NONE);
		addPaintListener(new PaintListener() {
			@Override
			  public void paintControl(PaintEvent e) {
			        
			    e.gc.drawImage(new Image(display, "Images//floor"+side+".jpg"), 0, 0);
			    }
			  });
		}
}
