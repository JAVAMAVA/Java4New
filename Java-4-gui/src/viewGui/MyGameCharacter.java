package viewGui;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;

import viewGui.GameCharacter;


public class MyGameCharacter implements GameCharacter {

	int x,y;
	Image chImage;
	boolean ifMoved;
	String direction;
	
	
	public MyGameCharacter(Image img,int x,int y) {
		chImage=img;
	}
	
	public void paint(GC gc,int w,int h){
		
		
		  gc.drawImage(chImage, 0, 0,20 ,25,w*(this.y)+6,h*(this.x)+10, w-15, h-18);
		  
		
		//else gc.drawImage(chImage, 0, 0,20 ,25,w*(this.y)+6,w*(this.x)+10, w-15, h-18);
		//else gc.drawImage(chImage, srcX, srcY, srcWidth, srcHeight, destX, destY, destWidth, destHeight);
		   //gc.setForeground(new Color(null,255,0,0));
		   //gc.drawOval(x,y, w, h);
	   }

	@Override
	public void showCharacter() {
		// TODO Auto-generated method stub
		
	}
	
//	public void paint(PaintEvent e,int w,int h){  
//		   e.gc.drawImage(new Image(, data), w, h);
//		   e.gc.setForeground(new Color(null,255,0,0));
//		   e.gc.drawOval(x,y, w, h);
//	   }
	
	
	public int getXCharater()
	{
		return this.x;
	}
	
	public int getYCharater()
	{
		return this.y;
	}
	public void setXCharater(int x)
	{
		this.x=x;
		
	}
	
	public void setYCharater(int y)
	{
		this.y=y;
	}
	public Image getCimage()
	{
		return this.chImage;
	}
	public void setMoved(boolean moved)
	{
		this.ifMoved=moved;
	}
	public boolean setMoved()
	{
		return this.ifMoved;
	}
	}


