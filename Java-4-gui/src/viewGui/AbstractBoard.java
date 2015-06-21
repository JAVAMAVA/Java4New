package viewGui;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.DFSMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import algorithms.search.State;


public abstract class AbstractBoard extends Composite implements Board{

	public MazeCanvas boardGame[][];
	MyGameCharacter character;
	Maze matrix;
	AbstractMazeDispleyer myMaze;
	boolean newmaze=false;
	Boolean solve=false;
	Solution sol;
	
	public AbstractBoard(Composite parent, int style,Maze m) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		this.matrix=m;
		//DFSMazeGenerator dfs=new DFSMazeGenerator();
		//this.matrix=dfs.generateMaze(10, 10);
		matrix.print();
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
					if(solve==true)
						drawSolution(e);
					if (boardGame==null || newmaze==true)
						drawMaze(e);
					else myMaze.draw(e);
			}
		});
		
		
		
	}/*
	public void drawCharacterMove(PaintEvent e) {
		String temp="";
		if(matrix.getCell(character.getXCharater(), character.getYCharater()).getUp()==true)
			temp+="U";
		if(matrix.getCell(character.getXCharater(), character.getYCharater()).getRight()==true)
			temp+="R";
		if(matrix.getCell(character.getXCharater(), character.getYCharater()).getDown()==true)
			temp+="D";
		if(matrix.getCell(character.getXCharater(), character.getYCharater()).getLeft()==true)
			temp+="L";
		boardGame[character.getXCharater()][character.getYCharater()].drawCell(e, (getSize().x/matrix.getCols())*character.getXCharater() , (getSize().y/matrix.getRows())*character.getXCharater() , (getSize().x/matrix.getCols()), (getSize().y/matrix.getRows()));
		boardGame[character.getXCharater()][character.getYCharater()].setcImage(new Image(this.getDisplay(), "Images//FloorImages//floor"+temp+".jpg"));
		boardGame[character.getXCharater()][character.getYCharater()].setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,character.getXCharater(),character.getYCharater()));
		boardGame[character.getXCharater()][character.getYCharater()].drawCell(e, (getSize().x/matrix.getCols())*character.getXCharater() , (getSize().y/matrix.getRows())*character.getXCharater() , (getSize().x/matrix.getCols()), (getSize().y/matrix.getRows()));
		boardGame[character.getXCharater()][character.getYCharater()].redraw();
		
	}*/
	protected void drawSolution(PaintEvent e) {
		ArrayList<State> temp=this.sol.getSolution();
		String[] strings;
		State temps;
		String stringtemp;
		for(int i=temp.size()-1;i>=0;i--)
		{
			temps=temp.get(i);
			strings=temps.getState().split("[(,)]");
			stringtemp="";
			if(matrix.getCell(character.getXCharater(), character.getYCharater()).getUp()==true)
				stringtemp+="U";
			if(matrix.getCell(character.getXCharater(), character.getYCharater()).getRight()==true)
				stringtemp+="R";
			if(matrix.getCell(character.getXCharater(), character.getYCharater()).getDown()==true)
				stringtemp+="D";
			if(matrix.getCell(character.getXCharater(), character.getYCharater()).getLeft()==true)
				stringtemp+="L";
			int x=Integer.parseInt(strings[1]);
			int y=Integer.parseInt(strings[2]);
			Image myimage=new Image(this.getDisplay(), "Images//FloorImageSolution//"+temp+".jpg");
			boardGame[x][y].setcImage(myimage);
			
		}
		this.redraw();
		
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
					boardGame[i][j].drawCell(e, (getSize().x/matrix.getCols())*j , (getSize().y/matrix.getRows())*i , (getSize().x/matrix.getCols()), (getSize().y/matrix.getRows()));
					temp="";
				
				}
			}
			newmaze=false;
			
	}
		
	

}
