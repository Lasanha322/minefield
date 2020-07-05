import interfaces.IBoard;
import interfaces.ICell;

public class Board implements IBoard {
	private ICell[] Celulas;
	
	public Board(int tamanho, int gemasPraColocar) {
		double gemChance = (double)(gemasPraColocar)/(double)(tamanho);
		Celulas = new ICell[tamanho];
		
		for(int i = 0; i < tamanho; i++) {
			Celulas[i] = new Cell();
			
			if (gemasPraColocar > 0) {
				if (tamanho - i <= gemasPraColocar) {
					Celulas[i].setConteudo(new Gema());
					gemasPraColocar--;
				} else if (Math.random() < gemChance) {
					Celulas[i].setConteudo(new Gema());
					gemasPraColocar--;
				}							
			}
		}
	}

	@Override
	public ICell getCell(int i) {
		return Celulas[i];
	}
}