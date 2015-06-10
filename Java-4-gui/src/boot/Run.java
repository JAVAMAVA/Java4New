package boot;

import presenter.Presenter;
import viewGui.MazeWindow;
import model.MyModel;

public class Run {
	
			public static void main(String[] args) {
				MyModel m=new MyModel(4);
				MazeWindow win=new MazeWindow("My Ascii art window", 500, 500);
				Presenter c=new Presenter(win,m);
				m.addObserver(c);
				win.addobserver(c);
				win.run();
			}
	}

