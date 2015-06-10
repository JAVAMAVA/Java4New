package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ChooseWindow extends BasicWindow  {

	public ChooseWindow(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	}


	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		Label rowsLabel=new Label(shell, SWT.PUSH);
		Text rowsText=new Text(shell, SWT.PUSH);
		
	}

}
