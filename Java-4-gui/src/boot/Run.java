package boot;

import org.eclipse.swt.widgets.Display;

import presenter.Presenter;
import view.MyView;
import viewGui.MazeWindow;
import viewGui.StartWindow;
import model.MyModel;

public class Run {
	
			public static void main(String[] args) {
			
				Display dis = new Display();
				
				StartWindow start = new StartWindow("My Window", 500, 500,dis );
				start.start();
				start.run();
				
//				MyModel m=new MyModel(4);
//				MazeWindow win=new MazeWindow("MyMaze",1000, 1000);
//				//MyView win=new MyView();
//				Presenter c=new Presenter(win,m);
//				m.addObserver(c);
//				win.addobserver(c);
//				win.run();
				
				//MazeWindow maze;
				/*StartWindow start=new StartWindow("hello", 500, 500);
				MyModel m=new MyModel(4);
				Presenter c=new Presenter(start,m);
				m.addObserver(c);
				start.addobserver(c);
				start.run();*/
				
				
			}
	}

