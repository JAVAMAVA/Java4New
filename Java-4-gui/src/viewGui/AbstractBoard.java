package viewGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;


public abstract class AbstractBoard extends Composite implements Board{

	public Canvas boardGame[][];
	MyGameCharacter character;
	
	public AbstractBoard(Composite parent, int style) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		boardGame=new Canvas[10][10];
		
		
	}

	public Canvas[][] getBoardGame() {
		return boardGame;
	}

	public void setBoardGame(Canvas[][] boardGame) {
		this.boardGame = boardGame;
	}

	public MyGameCharacter getCharacter() {
		return character;
	}

	public void setCharacter(MyGameCharacter character) {
		
		
		this.character = character;
	}
	
	

}
