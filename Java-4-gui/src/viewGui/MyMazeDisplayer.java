package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze;

public class MyMazeDisplayer extends AbstractMazeDispleyer  {
	
	MyBoard Board;
	Maze m;
	Display dis;
	Shell sh;
	int style;
	
	public MyMazeDisplayer(MyBoard board, int style, Display display,Shell shell) {
		super();
		this.m = getMyMaze(10, 10);
		this.dis = display;
		this.sh =shell;
		this.style = style;
		this.Board=board; 
			
		
	}
	
	
	

	/**
	 * The method drawMaze draws the maze it gets into the board. It draws each cell as a way and around it the wall, if the wall is vertical it draws the WallVertical and if the wall is horizontal it draws a WallHorizontal
	 * @param matrix - the {@link Maze} that need to draw in the board
	 */
	public void drawMaze(Maze matrix,MyBoard Board,int style, Display display,Shell shell,int rows,int cols)
	{
		String str="";
		for(int i=0;i<matrix.getRows();i++)
		{
			for (int j=0;j<matrix.getCols();j++)
			{
				if (matrix.getCell(i, j).getUp()==true)
					str+="U";
				if (matrix.getCell(i, j).getRight()==true)
					str+="R";
				if (matrix.getCell(i, j).getDown())
					str+="D";
				if (matrix.getCell(i, j).getLeft()==true)
					str+="L";
					
				Board.boardGame[i][j] = new MazeCanvas(this.Board, style, str, shell, display);	
				str="";
			}
			
			
		}

	}
	
	
	@Override
	public void display(PaintEvent maze) {
		
		GridLayout mLayout = new GridLayout(0, false); //needs changing
		
		drawMaze(this.m, Board, style, dis, sh, this.m.getRows(), this.m.getRows());
		
		
		
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




	

}
