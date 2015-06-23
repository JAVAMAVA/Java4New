package viewGui;


import java.util.HashMap;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;

import org.eclipse.swt.events.MouseMoveListener;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;

import org.eclipse.swt.widgets.Listener;

import presenter.Presenter.Command;
import view.View;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import algorithms.search.State;


public class MazeWindow extends BasicWindow implements View{
	
	MyBoard gameBoard;
	public Command lastcommand;
	private HashMap<String, Command> comm;
	public Maze myMaze;
	public MazeDispleyer md;
	public String name;
	
	
	public MazeWindow(String title,int width , int height,Display dis, int i, int j, String name) {
		super(title, width, height,dis) ;
		myMaze=new Maze(i, j);
		this.name=name;
		
		
	}
	
	/**
	 * initWidgets overrides the super method
	 * it initializes the widgets in the display windows and runs them
	 */
	@Override
	void initWidgets() {
		
		shell.setLayout(new GridLayout(2, false)); //just started, needs changing
		
		
		gameBoard=new MyBoard(shell,SWT.None, display, shell, myMaze);
		gameBoard.layout();
		
		gameBoard.addListener(SWT.RESIZE, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				gameBoard.drawBoard();
			}
		});
		
		
		
		//gameBoard.redraw();
		//md=new MyMazeDisplayer(gameBoard, m);
		
		GridLayout boardLayout = new GridLayout(myMaze.getCols(), true);
		boardLayout.horizontalSpacing = 0;
		boardLayout.verticalSpacing = 0;
		gameBoard.setLayout(boardLayout);
		gameBoard.layout();
		
		
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
				generatemaze();
				
								
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
				startgame();
				gameBoard.forceFocus();
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
				
				//display.close();
				shell.close();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		clue.setText("Get the Solution!");
		clue.setLayoutData(new GridData(SWT.FILL, SWT.NONE,false,false,1,1));
		
		
		clue.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				lastcommand=comm.get("solve maze");
				setChanged();
				notifyObservers(name);
				gameBoard.forceFocus();
				lastcommand=comm.get("display solution");
				setChanged();
				notifyObservers(name);
				
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
	

	protected void startgame() {
		gameBoard.startgame=true;
		gameBoard.redraw();
		
	}

	protected void generatemaze() {
		
		setChanged();
		notifyObservers("start");
		lastcommand=comm.get("generate maze");
		setChanged();
		notifyObservers(name+" "+myMaze.getRows()+" "+myMaze.getCols());
		gameBoard.matrix.print();
		
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
		gameBoard.newmaze=true;
		gameBoard.setMaze(m);
		gameBoard.forceFocus();
		
	}

	@Override
	public void displaySolution(Solution s) {
		int x=gameBoard.character.x;
		int y=gameBoard.character.y;
		State temp;
		s.printSolution();
		gameBoard.sol=s;
		gameBoard.solve=true;
		gameBoard.redraw();
		
	}

	@Override
	public void displaySuccess(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCommands(HashMap<String, Command> comm) {
		this.comm=comm;
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
		this.addObserver(observer);
		
	}

	@Override
	public HashMap<String, Command> getHM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void closeWindow() {
		// TODO Auto-generated method stub
		
	}


	
	

}
