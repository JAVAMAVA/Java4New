package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link MyCLI} extends {@link CLI} and implements {@link Runnable} 
 *  it is the main part behind the view commands
 * @author Michael&Amit
 * @see CLI
 * @see Runnable
 *
 */

public class MyCLI extends CLI implements Runnable  {
	
	HashMap<String, presenter.Presenter.Command> hm;
	View v;
	public MyCLI(BufferedReader in, PrintWriter out,View v) {
		super(in, out);
		hm=new HashMap<>();
		this.v=v;

	}
	
	@Override 
	public void start()
	{
		try {
		System.out.println("Enter a command");
		String Line=in.readLine();
		
			while (!Line.equals("exit"))
			{
				String[] sp = Line.split(" ");
								
				String commandName = sp[0]+" "+sp[1];
				String arg1 = null;
					if(sp.length>4)
					{
					arg1 = sp[2]+" "+sp[3]+" "+sp[4];
					v.setLastCommand(hm.get(commandName));
					v.notifyArg(arg1);
					}
					else 
					{
						v.setLastCommand(hm.get(commandName));
						v.notifyArg(sp[2]);
					}
						
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		v.notifyArg(this);		
	}

}
