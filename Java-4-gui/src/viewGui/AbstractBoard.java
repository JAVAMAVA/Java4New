package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze;


public abstract class AbstractBoard extends Composite implements Board{

	public MazeCanvas boardGame[][];
	MyGameCharacter character;
	Maze matrix;
	
	public AbstractBoard(Composite parent, int style,Maze m) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		this.matrix=m;
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				
					drawMaze(e);
			}
		});
		
		
		
	}
	public void AddImages()
	{
		
	}

	public MazeCanvas[][] getBoardGame() {
		return boardGame;
	}

	public void setBoardGame(MazeCanvas[][] boardGame) {
		this.boardGame = boardGame;
	}

	public MyGameCharacter getCharacter() {
		return character;
	}

	public void setCharacter(MyGameCharacter character) {
		
		
		this.character = character;
	}
	
	
	public void setMaze(Maze matrix)
	{
		this.matrix=matrix;
		this.redraw();
	}
	
	/**
	 * The method draws the maze into the boardgame
	 */
	public void drawMaze(PaintEvent e)
	{
		String temp="";
		boardGame=new MazeCanvas[this.matrix.getRows()][this.matrix.getCols()];
		
			for(int i=0;i<matrix.getRows();i++)
			{
				for(int j=0;j<matrix.getCols();j++)
				{
					if(matrix.getCell(i, j).getUp()==true)
						temp+="U";
					if(matrix.getCell(i, j).getRight()==true)
						temp+="R";
					if(matrix.getCell(i, j).getDown()==true)
						temp+="D";
					if(matrix.getCell(i, j).getLeft()==true)
						temp+="L";
					
					boardGame[i][j]=new MazeCanvas(this, SWT.FILL);
					boardGame[i][j].setcImage(new Image(this.getDisplay(), "Images//FloorImages//floor"+temp+".jpg"));
					boardGame[i][j].setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
					temp="";
				
				}
			}
	}
		
	

}
