package viewGui;

import java.util.Observable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public abstract class BasicWindow extends Observable implements Runnable{

	Display display;
	Shell shell;
	
	public BasicWindow(String title, int width, int height,Display dis) {
		display=dis;
		shell=new Shell(dis);
		shell.setText(title);
		shell.setSize(width,height);
	}
	
	abstract void initWidgets();
	abstract void closeWindow();
	
	@Override
	public void run() {
		initWidgets();
		shell.open();
		// main event loop
		 while(!shell.isDisposed()){ // while window isn't closed

		    // 1. read events, put then in a queue.
		    // 2. dispatch the assigned listener
		    if(!display.readAndDispatch()){ 	// if the queue is empty
		       display.sleep(); 			// sleep until an event occurs 
		    }

		 } // shell is disposed

//		 display.dispose(); // dispose OS components
		 closeWindow();
	}

}
