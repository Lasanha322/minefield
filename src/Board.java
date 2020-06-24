import interfaces.IBoard;
import interfaces.ICell;

public class Board implements IBoard {
	private ICell[] Celulas;
	
	public Board(int Tamanho){
		Celulas = new ICell[Tamanho];
	}

	@Override
	public ICell getCell(int i) {
		return Celulas[i];
	}
}