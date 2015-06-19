package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
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
	
	private Image CellImage;
	int height;
	int width;
	
	public MazeCanvas(Composite parent, int style) {
		super(parent, style);
		height=this.getBounds().height;
		width=this.getBounds().width;
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(CellImage, 0, 0,CellImage.getBounds().width, CellImage.getBounds().height, 0, 0, width, height);
				
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
		
		public void setcImage(Image cImage) {
			synchronized (this) {
				this.CellImage = cImage;	
			}
		}
		// TODO Auto-generated constructor stub
}
	
	/*public MazeCanvas(MyBoard board,int style,String side,Shell shell,Display display) {
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
		}*/

