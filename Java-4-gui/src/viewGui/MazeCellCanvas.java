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

	
	Image UpWall;
	Image DownWall;
	Image LeftWall;
	Image RightWall;
		
	
	public MazeCellCanvas(MyBoard Board, int style,String side,Shell shell,Display display) {
		super(Board, style);
		//this = new Canvas(shell, SWT.NONE);
		
		Image UpWall = new Image(display,"WallUp.jpg");
		Image DownWall = new Image(display,"WallUp.jpg");;;
		Image LeftWall = new Image(display,"WallLeft.jpg");
		Image RightWall = new Image(display,"WallUp.jpg");;;
		
		addPaintListener(new PaintListener() {
			  public void paintControl(PaintEvent e) {
			        
			    if(side == "Right"){
			    	e.gc.drawImage(RightWall, 0, 0);
			    	//e.gc.drawImage(image, 0, 0, srcWidth, srcHeight, destX, destY, destWidth, destHeight);
				}
				else
					if(side =="Left"){
						e.gc.drawImage(LeftWall, 0, 0);
					}
					else
						if(side == "Up"){
							e.gc.drawImage(UpWall, 0, 0);
						}
						else
							if(side == "Down"){
								e.gc.drawImage(DownWall, 0, 0);
							}
			  }	
		});
	}
}
