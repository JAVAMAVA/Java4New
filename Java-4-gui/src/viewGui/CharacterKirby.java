package viewGui;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class CharacterKirby implements GameCharacter{
	int x,y;
	   public CharacterKirby(int x,int y) {
		this.x=x;this.y=y;
	   }
	   
	   public void paint(PaintEvent e,int w,int h){
		   e.gc.drawImage(new Image(, data), w, h);
		   e.gc.setForeground(new Color(null,255,0,0));
		   e.gc.drawOval(x,y, w, h);
	   }

	@Override
	public void showCharacter() {
		
		
	}

}
