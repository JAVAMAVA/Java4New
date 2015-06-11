package viewGui;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public abstract class MyGameCharacter implements GameCharacter {

	int x,y;
	
	public void paint(PaintEvent e,int w,int h){
		   e.gc.drawImage(new Image(, data), w, h);
		   e.gc.setForeground(new Color(null,255,0,0));
		   e.gc.drawOval(x,y, w, h);
	   }
	
	
}
