package viewGui;


import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

/**
 * this class representing a maze cell via extending {@link Canvas}
 * 
 * @author Michael & Amit
 *
 */



public class MazeCanvas extends Canvas {
	
	private Image CellImage;
	
	public MazeCanvas(Composite parent, int style) {
		super(parent, style);
	}
		
		public void setcImage(Image cImage) {
				this.CellImage = cImage;
		}
		void drawCanvas(PaintEvent e)
		{
			
		}
		
		public void drawCell(PaintEvent e, int x, int y, int w, int h){
			if(CellImage!=null){ //display image of the tile
		        ImageData data = CellImage.getImageData();
		        e.gc.drawImage(CellImage,0,0,data.width,data.height,x,y,w,h);
			}
		}
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

