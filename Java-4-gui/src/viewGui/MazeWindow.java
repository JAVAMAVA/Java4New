package viewGui;


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
import org.eclipse.swt.widgets.Composite;

import presenter.Presenter;
import presenter.Presenter.Command;
import view.View;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;


public class MazeWindow extends BasicWindow implements View{
	
	MyBoard gameBoard;
	public Command lastcommand;
	private HashMap<String, Command> comm;
	
	public MazeWindow(String title,int width , int height) {
		super(title, width, height);
	
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2, false)); //just started, needs changing
		
		
		gameBoard.addKeyListener(new KeyListener() { //listening to the client key arrows
			

			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				 if (arg0.keyCode == SWT.ARROW_UP){
					 //move up
					 //list todo:
					 //moving the index of the character
					 //canvas[][].redraw ->redraws to old thing(if problem, do redraw whole maze)
					 //gamechar.paint
					 
					 
				 }
				 if (arg0.keyCode == SWT.ARROW_DOWN){
					 //move down
				 }
				 if (arg0.keyCode == SWT.ARROW_LEFT){
					 //move left
				 }
				 if (arg0.keyCode == SWT.ARROW_RIGHT){
					 //move right
				 }
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
		
		Button createMaze=new Button(shell,SWT.PUSH);
		gameBoard=new MyBoard(shell, SWT.CENTER,this.display,this.shell);
		Button startGame=new Button(shell, SWT.PUSH);
		Button exitGame=new Button(shell, SWT.PUSH);
		Button clue=new Button(shell, SWT.PUSH);
		Button options=new Button(shell,SWT.PUSH);
		
		
		createMaze.setText("Create new Maze");
		createMaze.setLayoutData(new GridData(SWT.CENTER, SWT.TOP,false,false,1,1));
		createMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				lastcommand=comm.get("generate maze");
				hasChanged();
				notifyObservers("new maze");
				lastcommand=comm.get("display maze");
				hasChanged();
				notifyObservers("display maze");
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
		this.comm=comm;
		c.hm=comm;
		
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
	public void setPresenter(Presenter c){
		this.c=c;
	}

	
	

}
