package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractBoard extends Composite implements Board{

	public Canvas boardGame[][];
	
	public AbstractBoard(Composite parent, int style) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		
		
	}

}
