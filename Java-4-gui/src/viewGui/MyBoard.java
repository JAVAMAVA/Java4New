package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;



public abstract class MyBoard extends Composite implements Board{

	
	
	
	public MyBoard(Composite parent, int style,Display display,Shell shell) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		
		
		
	}
	
	@Override
	public void drawBoard() {
		
		
		
	}
	
	
	
	
	
	
	
	
	
//	Image wallHorizontal;
//	Canvas[][] boardGame;
//	Image wallVertical;
//	Image way;
//	private Display display;
//	private Shell shell;
//
//	public MyBoard(Composite parent, int style,Display display,Shell shell) {
//		super(parent, style);
//		
//		this.display=display;
//		this.shell=shell;
//		way=new Image(display,"Grass.jpg");
//		
//		setBackground(new Color(null, 255, 255, 255));
//		addPaintListener(new PaintListener() {
//			@Override
//			public void paintControl(PaintEvent e) {
//				int x=getSize().x;
//				int y=getSize().y;
//				e.gc.drawImage(way,0,0,way.getImageData().width,way.getImageData().height,0,0,x,y);
//				
//			}
//		});
//	}
//
//		

//		
//	}
//	public void ChangeWallHorizonal(Image wallHorizontal)
//	{
//		this.wallHorizontal=wallHorizontal;
//	}
//	
//	public void ChangeWallVertical(Image wallVertical)
//	{
//		this.wallVertical=wallVertical;
//	}
//	
//	public void ChangeWay(Image way)
//	{
//		this.way=way;
//	}
//	
}