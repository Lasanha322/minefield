import interfaces.IBoard;
import interfaces.ICell;

public class Board implements IBoard {
	ICell [] Celulas;
	Board(int Tamanho){
		Celulas = new ICell[Tamanho];
	}
	public ICell [] getCell () {
		return Celulas;
	}

}
