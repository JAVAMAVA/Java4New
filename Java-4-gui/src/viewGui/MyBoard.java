package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Cell;
import algorithms.mazeGenerators.Maze;



public class MyBoard extends AbstractBoard{
	
	

	public boolean startgame;
	
	public MyBoard(Composite parent, int style,Display display,Shell shell,Maze m) {
		super(parent, style | SWT.DOUBLE_BUFFERED,m);
		startgame=false;
		myMaze = new MyMazeDisplayer(this, this.matrix);
		this.character=new MyGameCharacter(new Image(this.getDisplay(), "ImagesCharacters//BlueBoy//BHSF.png"), 0, 0);
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				if(boardGame==null)
					drawMaze(e);
				
				System.out.println(startgame);
				if(startgame==true)
				character.paint(e.gc, getSize().x/matrix.getRows(), getSize().y/matrix.getCols());
			
				
			}
	
		});
		addKeyListener(new KeyListener() { //listening to the client key arrows
			
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				 if (arg0.keyCode == SWT.ARROW_UP){
					 character.chImage=new Image(getDisplay(), "ImagesCharacters//BlueBoy//BHSB.png");
					 redraw();
					 if (matrix.getCell(character.getXCharater(),character.getYCharater()).getUp()==false)
					 {
						character.setMoved(true);
						
						boardGame[character.getXCharater()][character.getYCharater()].redraw();
						character.setXCharater(character.getXCharater()-1);
						
						
					
						redraw();
						if (character.getXCharater()==matrix.getRows()-1 && character.getYCharater()==matrix.getCols()-1)
						{
							System.out.println("THE END");
						}
					 
					 }
				 }
				 if (arg0.keyCode == SWT.ARROW_DOWN){
					 character.chImage=new Image(getDisplay(), "ImagesCharacters//BlueBoy//BHSF.png");
					 redraw();
					 if (matrix.getCell(character.getXCharater(),character.getYCharater()).getDown()==false)
					 {
						 
					
						 character.setXCharater(character.getXCharater()+1);
						
						
						 
						 redraw();
						 if (character.getXCharater()==matrix.getRows()-1 && character.getYCharater()==matrix.getCols()-1)
							{
								System.out.println("THE END");
							}
					 }
				 }
				 if (arg0.keyCode == SWT.ARROW_LEFT){
					 character.chImage=new Image(getDisplay(), "ImagesCharacters//BlueBoy//BHSL.png");
					 redraw();
					 if (matrix.getCell(character.getXCharater(),character.getYCharater()).getLeft()==false)
					 {
						
						character.setYCharater(character.getYCharater()-1);
						 
						
						 
						 redraw();
						 if (character.getXCharater()==matrix.getRows()-1 && character.getYCharater()==matrix.getCols()-1)
							{
								System.out.println("THE END");
							}
					 }
				 }
				 if (arg0.keyCode == SWT.ARROW_RIGHT){
					 character.chImage=new Image(getDisplay(), "ImagesCharacters//BlueBoy//BHSR.png");
					 redraw();
					 if (matrix.getCell(character.getXCharater(),character.getYCharater()).getRight()==false)
					 {
						 character.setYCharater(character.getYCharater()+1);
						 redraw();
						 if (character.getXCharater()==matrix.getRows()-1 && character.getYCharater()==matrix.getCols()-1)
							{
								System.out.println("THE END");
							}
					 }
				 }
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
	
		addMouseListener(new MouseListener() {
			int mousei=getSize().x/matrix.getCols();
			int mousej=getSize().y/matrix.getRows();
			@Override
			public void mouseUp(MouseEvent arg0) {
				if(character.y==mousei && character.x==mousej)
				{
					
					mousei=arg0.x/(getSize().x/matrix.getRows());
					mousej=arg0.y/(getSize().y/matrix.getCols());
					character.y=mousei;
					character.x=mousej;
					redraw();
					forceFocus();
				}
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				
				
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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