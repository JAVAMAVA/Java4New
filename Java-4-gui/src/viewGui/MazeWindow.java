package viewGui;


import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;

import presenter.Presenter;
import presenter.Presenter.Command;
import view.View;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;


public class MazeWindow extends BasicWindow implements View{
	
	MyBoard gameBoard;
	public Command lastcommand;
	private HashMap<String, Command> comm;
	public Maze myMaze;
	public MazeDispleyer md;
	
	
	public MazeWindow(String title,int width , int height) {
		super(title, width, height);
		
		
	}
	
	
	
	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2, false)); //just started, needs changing
		
		Maze m=new Maze(10, 10);
		gameBoard=new MyBoard(shell,SWT.None, display, shell, m);
		gameBoard.layout();
		gameBoard.redraw();
		//md=new MyMazeDisplayer(gameBoard, m);
		
		GridLayout boardLayout = new GridLayout(m.getCols(), true);
		boardLayout.horizontalSpacing = 0;
		boardLayout.verticalSpacing = 0;
		gameBoard.setLayout(boardLayout);
		
		
		//gameBoard.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,2,1));
		
		
		Button createMaze=new Button(shell,SWT.PUSH);
		
		Button startGame=new Button(shell, SWT.PUSH);
		Button exitGame=new Button(shell, SWT.PUSH);
		Button clue=new Button(shell, SWT.PUSH);
		Button options=new Button(shell,SWT.PUSH);
		
		
		createMaze.setText("Create new Maze");
		
		createMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				
				
//				lastcommand=comm.get("generate maze");
//				hasChanged();
//				notifyObservers("new maze");
//				lastcommand=comm.get("display maze");
//				hasChanged();
//				notifyObservers("display maze");
				//need to put in the board the maze that was created
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		startGame.setText("Start Game");
		startGame.setLayoutData(new GridData(SWT.FILL, SWT.NONE,false,false,1,1));
		startGame.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				setChanged();
				notifyObservers("GenerateMaze momo:6,6");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		exitGame.setText("Exit");
		exitGame.setLayoutData(new GridData(SWT.FILL, SWT.NONE,false,false,1,1));
		exitGame.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		clue.setText("Get a Clue");
		clue.setLayoutData(new GridData(SWT.FILL, SWT.NONE,false,false,1,1));
		
		
		clue.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		options.setText("Options");
		options.setLayoutData(new GridData(SWT.FILL, SWT.NONE,false,false,1,1));
		options.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		gameBoard.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,1,5));
		gameBoard.addMouseMoveListener(new MouseMoveListener() {
			
			@Override
			public void mouseMove(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
	}
	

	public void setGameBoard(MyBoard gameboard){
		this.gameBoard = gameboard;
	}
	
	public void setDisplayer(MazeDispleyer md){
		this.md = md;
	}

	@Override
	public Command getUserCommand() {
		return this.lastcommand;
	}

	@Override
	public void displayMaze(Maze m) {
	
		
	}

	@Override
	public void displaySolution(Solution s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySuccess(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCommands(HashMap<String, Command> comm) {
		//TODO
	}

	@Override
	public void notifyArg(Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastCommand(Command comm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addobserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}


	
	

}
