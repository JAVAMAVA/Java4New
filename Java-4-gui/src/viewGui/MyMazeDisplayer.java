package viewGui;


import org.eclipse.swt.events.PaintEvent;


import algorithms.mazeGenerators.Maze;


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
	public void draw(PaintEvent e){
			if (this.board.boardGame!=null)
				for(int i=0;i<this.m.getRows();i++){
					for(int j=0;j<this.m.getCols();j++)
						board.boardGame[i][j].drawCell(e, (board.getSize().x/board.matrix.getCols())*j , (board.getSize().y/board.matrix.getRows())*i , (board.getSize().x/board.matrix.getCols()), (board.getSize().y/board.matrix.getRows()));
				}
	}
	
	public void setData(Object obj){
		this.m = (Maze)obj;
	}

	
	public Maze getMyMaze(int rows,int cols){ //get maze from view
		Maze maze;
		maze = new Maze(rows,cols);
		return maze;
				
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
