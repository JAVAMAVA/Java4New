package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze;



public class MyBoard extends AbstractBoard{
	
	AbstractMazeDispleyer myMaze;
	
	
	public MyBoard(Composite parent, int style,Display display,Shell shell,Maze m) {
		super(parent, style | SWT.DOUBLE_BUFFERED,m);
		
		myMaze = new MyMazeDisplayer(this, this.matrix);
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent arg0) { //moving the character
				if(boardGame==null)
					drawMaze(arg0);
				myMaze.draw(); //send to him arg0
				//set char
				//mymaze.redraw
				// ....
				
			}
	
		});
		addKeyListener(new KeyListener() { //listening to the client key arrows
			
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				 if (arg0.keyCode == SWT.ARROW_UP){
					 //move up
					 //list todo:
					 //moving the index of the character
					 //canvas[][].redraw ->redraws to old thing(if problem, do redraw whole maze)
					 //gamechar.paint
					 
					 
				 }
				 if (arg0.keyCode == SWT.ARROW_DOWN){
					 //move down
				 }
				 if (arg0.keyCode == SWT.ARROW_LEFT){
					 //move left
				 }
				 if (arg0.keyCode == SWT.ARROW_RIGHT){
					 //move right
				 }
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
		
	 
	
	
	
	
	
		
		
		
		
	}


	@Override
	public void drawBoard() {
		
		redraw();
		
	}
	
	
	
	
	
	
	
//	Image wallHorizontal;
//	Canvas[][] boardGame;
//	Image wallVertical;
//	Image way;
//	private Display display;
//	private Shell shell;
//
//	public MyBoard(Composite parent, int style,Display display,Shell shell) {
//		super(parent, style);
//		
//		this.display=display;
//		this.shell=shell;
//		way=new Image(display,"Grass.jpg");
//		
//		setBackground(new Color(null, 255, 255, 255));
//		addPaintListener(new PaintListener() {
//			@Override
//			public void paintControl(PaintEvent e) {
//				int x=getSize().x;
//				int y=getSize().y;
//				e.gc.drawImage(way,0,0,way.getImageData().width,way.getImageData().height,0,0,x,y);
//				
//			}
//		});
//	}
//
//		

//		
//	}
//	public void ChangeWallHorizonal(Image wallHorizontal)
//	{
//		this.wallHorizontal=wallHorizontal;
//	}
//	
//	public void ChangeWallVertical(Image wallVertical)
//	{
//		this.wallVertical=wallVertical;
//	}
//	
//	public void ChangeWay(Image way)
//	{
//		this.way=way;
//	}
//	
}