package viewGui;

import java.util.ArrayList;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;

import algorithms.search.Solution;
import algorithms.search.State;

public class SolutionCharacter implements GameCharacter {
	
	Image chImage;
	

	
	
	public SolutionCharacter(Image img,int x,int y) {
		chImage=img;
	}
	public void paint(GC gc,int w,int h,Solution sol){
			State temp;
			ArrayList<State> as=sol.getSolution();
			for(int i=as.size()-1;i>=0;i--)
			{
				temp=as.get(i);
				String[] temps=temp.getState().split("[(,)]");
				
				gc.drawImage(chImage, 0, 0,20 ,25,w*(Integer.parseInt(temps[3]))+6,h*(Integer.parseInt(temps[3]))+10, w-15, h-18);
			}
	}
	@Override
	public void showCharacter() {
		// TODO Auto-generated method stub
		
	}
	
	public Image getCimage()
	{
		return this.chImage;
	}
	


}
