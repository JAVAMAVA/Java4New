package viewGui;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze;

public class MyMazeDisplayer extends MyBoard implements MazeDispleyer  {
	
Canvas boardGame[][];
	
	public MyMazeDisplayer(Composite parent, int style, Display display,Shell shell,int rows,int cols) {
		super(parent, style, display, shell);
		Maze matrix = generateMaze(rows,cols ); //getting the maze
		
		
		display(matrix, parent); //start displaying maze
		
		
		
		
		
	}

	/**
	 * The method drawMaze draws the maze it gets into the board. It draws each cell as a way and around it the wall, if the wall is vertical it draws the WallVertical and if the wall is horizontal it draws a WallHorizontal
	 * @param matrix - the {@link Maze} that need to draw in the board
	 */
	public void drawMaze(Maze matrix,Composite parent,int style, Display display,Shell shell,int rows,int cols)
	{
		for(int i=0;i<matrix.getRows();i++)
		{
			for (int j=0;j<matrix.getCols();j++)
			{
				if (matrix.getCell(i, j).getDown())
					boardGame[i][j] = new MazeCellCanvas(parent, style, "Down", shell, display);
				if (matrix.getCell(i, j).getUp())
					boardGame[i][j] = new MazeCellCanvas(parent, style, "Up", shell, display);
				if (matrix.getCell(i, j).getRight())
					boardGame[i][j] = new MazeCellCanvas(parent, style, "Right", shell, display);
				if (matrix.getCell(i, j).getRight())
					boardGame[i][j] = new MazeCellCanvas(parent, style, "Left", shell, display);
			}
		}

	}
	
	
	/**
	 * display method displays a maze in the console
	 */
	@Override
	public void display(Maze matrix,Composite parent) {
		
		drawMaze(matrix, parent);
		
		
		
		
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
		
	}
	
	public Maze generateMaze(int rows,int cols){ //get maze from view
		
		
		
		return null;
		
		
		
	}

}
