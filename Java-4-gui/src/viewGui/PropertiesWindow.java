package viewGui;


import model.Model;
import model.MyModel;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import java.util.HashMap;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

import presenter.Presenter;
import presenter.Presenter.Command;
import view.View;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

public class PropertiesWindow extends BasicWindow implements View{

	MazeWindow mW;
	Display display;
	
	public PropertiesWindow(String title, int width, int height,Display disp) {
		super(title, width, height,disp);
		display = disp;
		
	}

	@Override
	void initWidgets() {
		shell.setBackground(new Color(this.display.getCurrent(), 255,255, 255));
		shell.setLayout(new GridLayout(3,false));
		shell.getDisplay().loadFont("Fonts//YanoneKaffeesatz-Bold.ttf");
		
		
		Color basicf = new Color(display.getCurrent(), 0, 0, 160);
		Color back = new Color(display.getCurrent(), 255,255, 255);
		Font font = new Font(this.display, "name of the font", 15, SWT.BOLD);
		
		Label prop=new Label(shell, SWT.CENTER);
		prop.setFont(new Font(shell.getDisplay(), "name of the font", 23, SWT.BOLD));
		prop.setText("Enter your maze properties:");
		prop.setForeground(basicf);
		prop.setBackground(back);
		prop.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Label wid=new Label(shell, SWT.CENTER);
		wid.setFont(font);
		wid.setText("Enter the maze width:");
		wid.setForeground(basicf);
		wid.setBackground(back);
		wid.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		
		Text width = new Text(shell, SWT.CENTER);
		width.setFont(font);
		width.setForeground(basicf);
		width.setBackground(back);
		width.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Label heig=new Label(shell, SWT.CENTER );
		heig.setFont(font);
		heig.setText("Enter the maze height:");
		heig.setForeground(basicf);
		heig.setBackground(back);
		heig.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		
		Text height  = new Text(shell, SWT.CENTER | SWT.BORDER);
		height.setFont(font);
		height.setForeground(basicf);
		height.setBackground(back);
		height.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Label name=new Label(shell, SWT.CENTER);
		name.setFont(font);
		name.setText("Enter the maze name:");
		name.setForeground(basicf);
		name.setBackground(back);
		name.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		
		Text mazeName  = new Text(shell, SWT.CENTER | SWT.BORDER);
		mazeName.setFont(font);
		mazeName.setForeground(basicf);
		mazeName.setBackground(back);
		mazeName.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Image pic = new Image(display, "Images//Pickacho.jpg");
		Label img = new Label(shell, SWT.BORDER |SWT.FILL);
		img.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		img.setImage(pic);
		
		Button confirm = new Button(shell, SWT.None);
		confirm.setText("Confirm");
		confirm.setFont(new Font(display, "Arial", 12, SWT.NORMAL));
		confirm.setLayoutData(new GridData(SWT.RIGHT ,SWT.BOTTOM, false,true,2,1));
		confirm.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.out.println(width.getText());
				System.out.println(height.getText());
				if(width.getText()!= "" && width.getText()!= "0" && height.getText() != "" && height.getText() != "0"){
					
					mW=new MazeWindow("My Maze Window",500, 500,display,Integer.parseInt(width.getText()),Integer.parseInt(height.getText()),mazeName.getText());
					MyModel c=new MyModel(10);
					Presenter p=new Presenter(mW, c);
					mW.addObserver(p);
					c.addObserver(p);
					mW.start();
					mW.run();
					closeWindow();
				}
				else{
					MessageBox errorMsg = new MessageBox(shell);
					errorMsg.setMessage("Please enter correct width and height");
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	void closeWindow() {
		// TODO Auto-generated method stub
		
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

	@Override
	public HashMap<String, Command> getHM() {
		// TODO Auto-generated method stub
		return null;
	}



	

}
