import interfaces.ICell;
import interfaces.IConteudo;

public class Cell implements ICell {
	boolean revelada;
	IConteudo Conteudo;

	public Cell() {
		this.revelada = false;		
		this.Conteudo = new Vazio();
	}
	
	public void setRevelada(boolean revelada) {
		this.revelada = revelada;

	}
	public void setConteudo(IConteudo conteudo) {
		this.Conteudo = conteudo;
	}
	
	public boolean getRevelada() {
		return revelada;
	}
	
	public IConteudo getConteudo() {
		return Conteudo;
	}	
}