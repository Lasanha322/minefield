import interfaces.ICell;
import interfaces.IConteudo;

public class Cell implements ICell {
	private boolean examinada;
	private IConteudo Conteudo;

	public Cell() {
		examinada = false;		
		Conteudo = new Vazio();
	}
	
	@Override
	public void setExaminada(boolean examinada) {
		this.examinada = examinada;
	}
	
	@Override
	public void setConteudo(IConteudo conteudo) {
		this.Conteudo = conteudo;
	}
	
	@Override
	public boolean examinada() {
		return examinada;
	}
	
	@Override
	public IConteudo getConteudo() {
		return Conteudo;
	}	
}