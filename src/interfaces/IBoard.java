package interfaces;

public interface IBoard {
	void revelarCelula(ICell Celula);
	void revelar4Celulas(ICell Celulas[]);
	void visualizarCelula(ICell Celula);
	void colocarBomba(ICell Celula);
	void colocarBombaInvisivel(ICell Celula);
	ICell descobrirGema();
}