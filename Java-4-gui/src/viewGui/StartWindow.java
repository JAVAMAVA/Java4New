package viewGui;

import java.util.HashMap;
import java.util.Observer;

import javax.swing.ButtonModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import presenter.Presenter.Command;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import view.View;

public class StartWindow extends BasicWindow implements View  {

	public StartWindow(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	void initWidgets() {
		shell.setBackground(new Color(display.getCurrent(), 255,255, 255));
		shell.setLayout(new GridLayout(2,false));
		shell.getDisplay().loadFont("Fonts//YanoneKaffeesatz-Bold.ttf");
		
		Font font = new Font(shell.getDisplay(), "name of the font", 23, SWT.BOLD);
		Label Title=new Label(shell, SWT.BOLD);
		Title.setFont(font);
		Title.setText("Welcome To Our Maze Game");
		Title.setForeground(new Color(display.getCurrent(), 0, 0, 160));
		Title.setBackground(new Color(display.getCurrent(), 255,255, 255));
		Title.setLayoutData(new GridData(SWT.CENTER,SWT.TOP, true,false,2,1));
		
		Label creators=new Label(shell, SWT.CENTER);
		creators.setFont(new Font(shell.getDisplay(), "name of the font", 15, SWT.BOLD));
		creators.setText("Creators:\nAmit Munichor\nand\n Michael Chickov");
		creators.setForeground(new Color(display.getCurrent(), 0, 0, 160));
		creators.setBackground(new Color(display.getCurrent(), 255,255, 255));
		creators.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Label innerTitle = new Label(shell,SWT.NONE);
		innerTitle.setText("Please enter the number of rows and columns in your Maze:\n\n");
		innerTitle.setFont(new Font(display, "Arial", 10, SWT.NORMAL));
		innerTitle.setForeground(new Color(display.getCurrent(), 0, 0, 160));
		innerTitle.setBackground(new Color(display.getCurrent(), 255,255, 255));
		innerTitle.setLayoutData(new GridData(SWT.CENTER ,SWT.TOP, false,false,2,1));
		
		Label LROW=new Label(shell, SWT.NONE);
		LROW.setText("Rows:");
		LROW.setFont(new Font(display, "Arial", 10, SWT.NORMAL));
		LROW.setForeground(new Color(display.getCurrent(), 0, 0, 160));
		LROW.setBackground(new Color(display.getCurrent(), 255,255, 255));
		LROW.setLayoutData(new GridData(SWT.CENTER ,SWT.TOP, false,false,1,1));
		
		Text TROW=new Text(shell, SWT.NONE);
		TROW.setLayoutData(new GridData(SWT.CENTER | SWT.FILL ,SWT.TOP, false,false,1,1));
		TROW.setBackground(new Color(display.getCurrent(), 229,228, 226));
		
		Label LCOLUMN=new Label(shell, SWT.NONE);
		LCOLUMN.setText("Columns:");
		LCOLUMN.setFont(new Font(display, "Arial", 10, SWT.NORMAL));
		LCOLUMN.setForeground(new Color(display.getCurrent(), 0, 0, 160));
		LCOLUMN.setBackground(new Color(display.getCurrent(), 255,255, 255));
		LCOLUMN.setLayoutData(new GridData(SWT.CENTER | SWT.LEFT ,SWT.TOP, false,false,1,1));
		
		Text TCOLUMN=new Text(shell, SWT.NONE);
		TCOLUMN.setLayoutData(new GridData(SWT.CENTER | SWT.FILL ,SWT.TOP, false,false,1,1));
		TCOLUMN.setBackground(new Color(display.getCurrent(), 229,228, 226));
		
		Button okbutton =new Button(shell, SWT.None);
		okbutton.setText("OK");
		okbutton.setFont(new Font(display, "Arial", 12, SWT.NORMAL));
		okbutton.setLayoutData(new GridData(SWT.RIGHT ,SWT.BOTTOM, false,true,2,1));
		okbutton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (TROW.getText()!="" && TCOLUMN.getText()!="")
				{
					//MazeWindow mW=new MazeWindow("My Maze Window",500, 500);
					//mW.start();
					//mW.myMaze=new Maze(Integer.parseInt(TROW.getText()),Integer.parseInt(TCOLUMN.getText()));
					//shell.dispose();	
				}
			
			
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
			});
		//Image i =new Image(display,"Images//Pickacho.jpg");
		// okbutton.setImage(i);
		
		
	}

	@Override
	public Command getUserCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayMaze(Maze m) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
