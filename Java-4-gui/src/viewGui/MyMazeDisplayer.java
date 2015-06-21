package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

public class MyMazeDisplayer extends AbstractMazeDispleyer  {
	
	//MyBoard Board;
	Maze m;
	int style;
	
	
	
	public MyMazeDisplayer(MyBoard board,Maze myMaze) {
		super();
		this.m = myMaze;
		this.board=board;
		
		//this.style = style;	
	}
	
	
	

	/**
	 * The method drawMaze draws the maze it gets into the board. It draws each cell as a way and around it the wall, if the wall is vertical it draws the WallVertical and if the wall is horizontal it draws a WallHorizontal
	 * @param matrix - the {@link Maze} that need to draw in the board
	 */
	@Override
	public void draw(PaintEvent e)
	{
			 
			if (this.board.boardGame!=null)
				for(int i=0;i<this.m.getRows();i++)
				{
					for(int j=0;j<this.m.getCols();j++)
						
						board.boardGame[i][j].drawCell(e, (board.getSize().x/board.matrix.getCols())*j , (board.getSize().y/board.matrix.getRows())*i , (board.getSize().x/board.matrix.getCols()), (board.getSize().y/board.matrix.getRows()));
				}
			

	}
	
	public void setData(Object obj){
		this.m = (Maze)obj;
	}
	
	

	
	
//	/**
//	 * display method displays a maze in the console
//	 */
//	@Override
//	public void display23(Maze matrix,Composite parent) {
//		
//		
//		
//		
//		
//		
//		for (int j = 0; j < matrix.getCols(); j++)
//			System.out.print(" _");
//			System.out.println("");
//	
//		
//		for (int i = 0; i < matrix.getRows(); i++) {
//			System.out.print("|");
//			for (int j = 0; j < matrix.getCols(); j++) {				
//				if (matrix.getCell(i, j).getDown())
//					System.out.print("_");
//				else
//					System.out.print(" ");
//				
//				if (matrix.getCell(i, j).getRight())
//					System.out.print("|");
//				else
//					System.out.print(" ");	
//								
//			}
//			System.out.println();
//		}
//		
//	}
//	
	public Maze getMyMaze(int rows,int cols){ //get maze from view
		Maze maze;
		
		maze = new Maze(rows,cols);
		
		
		return maze;
		
		
		
	}




	@Override
	public void displaySol(PaintEvent maze) {
		// TODO Auto-generated method stub
		
	}









	@Override
	public void drawSol(GC gc, Solution sol) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void undrawSol(GC gc, Solution sol) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Object getTile(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public int getCols() {
		// TODO Auto-generated method stub
		return 0;
	}




	

}
