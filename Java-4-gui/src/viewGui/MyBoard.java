package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze;



public class MyBoard extends AbstractBoard{
	
	AbstractMazeDispleyer myMaze;
	String state="(0,0)";
	
	
	public MyBoard(Composite parent, int style,Display display,Shell shell,Maze m) {
		super(parent, style | SWT.DOUBLE_BUFFERED,m);
		
		myMaze = new MyMazeDisplayer(this, this.matrix);
		this.character=new MyGameCharacter(new Image(this.getDisplay(), "ImagesCharacters//BlueBoy//BHSF.png"), 0, 0);
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) { //moving the character
				if(boardGame==null)
					drawMaze(e);
				//myMaze.draw(); //send to him arg0
				character.paint(e.gc, getSize().x/matrix.getRows(), getSize().y/matrix.getCols());
				//set char
				//mymaze.redraw
				// ....
				
			}
	
		});
		addKeyListener(new KeyListener() { //listening to the client key arrows
			
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				 if (arg0.keyCode == SWT.ARROW_UP){
					 if (matrix.getCell(character.getXCharater(),character.getYCharater()).getUp()==false)
					 {
						
						//boardGame[character.getXCharater()][character.getYCharater()].redraw();
						character.setXCharater(character.getXCharater()-1);
						
						//character.paint(gc,getSize().x/matrix.getRows(), getSize().y/matrix.getCols());
						 
					 //move up
					 //list todo:
					 //moving the index of the character
					 //canvas[][].redraw ->redraws to old thing(if problem, do redraw whole maze)
					 //gamechar.paint
					
						redraw();
					 
					 }
				 }
				 if (arg0.keyCode == SWT.ARROW_DOWN){
					 if (matrix.getCell(character.getXCharater(),character.getYCharater()).getDown()==false)
					 {
						 //boardGame[character.getXCharater()][character.getYCharater()].redraw();
						 character.setXCharater(character.getXCharater()+1);
						
							//character.paint(gc,getSize().x/matrix.getRows(), getSize().y/matrix.getCols());
						 
						 redraw();
					 }
				 }
				 if (arg0.keyCode == SWT.ARROW_LEFT){
					 if (matrix.getCell(character.getXCharater(),character.getYCharater()).getLeft()==false)
					 {
						 //boardGame[character.getXCharater()][character.getYCharater()].redraw();
						 character.setYCharater(character.getYCharater()-1);
						 
						//character.paint(gc,getSize().x/matrix.getRows(), getSize().y/matrix.getCols());
						 
						 redraw();
					 }
				 }
				 if (arg0.keyCode == SWT.ARROW_RIGHT){
					 if (matrix.getCell(character.getXCharater(),character.getYCharater()).getRight()==false)
					 {
						 //boardGame[character.getXCharater()][character.getYCharater()].redraw();
						 character.setYCharater(character.getYCharater()+1);
						
						//character.paint(gc,getSize().x/matrix.getRows(), getSize().y/matrix.getCols());
						 
						 redraw();
					 }
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